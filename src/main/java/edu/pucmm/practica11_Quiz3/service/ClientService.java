package edu.pucmm.practica11_Quiz3.service;


import edu.pucmm.practica11_Quiz3.modelo.Client;
import edu.pucmm.practica11_Quiz3.modelo.Rent;
import edu.pucmm.practica11_Quiz3.repository.ClientRepository;
import edu.pucmm.practica11_Quiz3.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RentRepository rentRepository;

    // Core Functions
    public void registerNewClient(String identificationNumber, String firstName, String lastName, String telephone, String address){
        clientRepository.save(new Client(identificationNumber, firstName, lastName, telephone, address));
    }

    public Client findClient(String identificationNumber){
        return clientRepository.findByIdentificationNumber(identificationNumber);
    }

    public List<Rent> findRentHistoryForClient(String identificationNumber){ return rentRepository.findByBorrower(identificationNumber); }

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }
}
