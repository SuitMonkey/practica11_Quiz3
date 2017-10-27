package edu.pucmm.practica11_Quiz3.service;


import edu.pucmm.practica11_Quiz3.modelo.Client;
import edu.pucmm.practica11_Quiz3.modelo.Equipment;
import edu.pucmm.practica11_Quiz3.modelo.Receipt;
import edu.pucmm.practica11_Quiz3.modelo.Rent;
import edu.pucmm.practica11_Quiz3.repository.ClientRepository;
import edu.pucmm.practica11_Quiz3.repository.EquipmentRepository;
import edu.pucmm.practica11_Quiz3.repository.ReceiptRepository;
import edu.pucmm.practica11_Quiz3.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AlquiService {

    private static final long MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;

    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private ClientRepository clientRepository;

    // Core Functions
    public void lendRegisteredEquipment(String equipmentId, Date promisedDate, float priceRate, String identificationNumber){
        if (!doesEquipmentIdExist(equipmentId))
            throw new IllegalArgumentException("\n\nThis equipment id is invalid");

        if (!doesIdentificationNumberExist(identificationNumber))
            throw new IllegalArgumentException("\n\nThis identification number is invalid");

        Equipment equipment = equipmentRepository.findByEquipmentId(equipmentId);

        equipment.setStock(equipment.getStock() - 1);

        equipmentRepository.save(equipment);

        rentRepository.save(new Rent(promisedDate, priceRate, clientRepository.findByIdentificationNumber(identificationNumber), equipmentRepository.findByEquipmentId(equipmentId)));
    }

    public void returnRegisteredEquipment(String equipmentId, String rentId){

        if (!doesEquipmentIdExist(equipmentId))
            throw new IllegalArgumentException("\n\nThis equipment id is invalid");

        if (!doesRentIdExist(rentId))
            throw new IllegalArgumentException("\n\nThis rent id is invalid");

        Equipment equipment = equipmentRepository.findByEquipmentId(equipmentId);

        equipment.setStock(equipment.getStock() + 1);

        equipmentRepository.save(equipment);

        Rent rent = rentRepository.findByRentId(rentId);

        rent.setActive(false);

        rentRepository.save(rent);

        createNewReceipt(calculateTotalPriceForRent(rent.getStartDate(), rent.getPromisedDate(), rent.getPriceRate()), rent.getBorrower(), rent.getEquipment());
    }

    public List<Rent> findAllActiveRents(){
        return rentRepository.findByActiveStatus(true);
    }

    public List<Rent> findAllCompletedRent(){
        return rentRepository.findByActiveStatus(false);
    }

    public List<Rent> findAllRents(){
        return rentRepository.findAll();
    }

    public List<Receipt> findAllReceipts(){
        return receiptRepository.findAll();
    }

    // Auxiliary Functions
    private boolean doesEquipmentIdExist(String equipmentId){
        Equipment equipment = equipmentRepository.findByEquipmentId(equipmentId);

        return (equipment != null);
    }

    private boolean doesIdentificationNumberExist(String identificationNumber){
        Client client = clientRepository.findByIdentificationNumber(identificationNumber);

        return (client != null);
    }

    private boolean doesRentIdExist(String rentId){
        Rent rent = rentRepository.findByRentId(rentId);

        return (rent != null);
    }

    private void createNewReceipt(float totalPrice, Client borrower, Equipment equipment){
        receiptRepository.save(new Receipt(totalPrice, borrower, equipment));
    }

    private float calculateTotalPriceForRent(Date startDate, Date promisedDate, float priceRate){
        java.util.Date utilDate = new java.util.Date();
        Date today = new Date(utilDate.getTime());

        if (differenceInDays(today, promisedDate) >=  0) // Equipment is returned on time, NO PENALTY
            return priceRate * differenceInDays(startDate, today);
        else // Equipment is returned late, PENALTY
            return priceRate * differenceInDays(startDate, promisedDate) + (priceRate/2) * differenceInDays(promisedDate, today);
    }

    private int differenceInDays(Date start, Date end){
        return (int)((end.getTime() - start.getTime()) / MILLISECONDS_IN_A_DAY);
    }
}
