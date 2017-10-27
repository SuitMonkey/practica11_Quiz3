package edu.pucmm.practica11_Quiz3.service;


import edu.pucmm.practica11_Quiz3.modelo.Equipment;
import edu.pucmm.practica11_Quiz3.modelo.Family;
import edu.pucmm.practica11_Quiz3.modelo.SubFamily;
import edu.pucmm.practica11_Quiz3.repository.EquipmentRepository;
import edu.pucmm.practica11_Quiz3.repository.FamilyRepository;
import edu.pucmm.practica11_Quiz3.repository.SubFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private SubFamilyRepository subFamilyRepository;

    // Family Related Functions
    public void registerNewFamily(String familyName){
        if (doesFamilyNameExist(familyName))
            throw new IllegalArgumentException("\n\nThe family name: " + familyName + "is unavailable");

        familyRepository.save(new Family(familyName));
    }

    public Family findFamily(String familyKey){
        return familyRepository.findByFamilyKey(familyKey);
    }

    public List<Family> findAllFamilies(){
        return familyRepository.findAll();
    }

    // SubFamily Related Functions
    public void registerSubFamily(String subFamilyName, String familyKey){
        if (!doesFamilyKeyExist(familyKey))
            throw new IllegalArgumentException("\n\nThis family key is invalid");

        if (doesSubFamilyNameExist(subFamilyName))
            throw new IllegalArgumentException("\n\nThis sub-family name: " + subFamilyName + " is unavailable");

        subFamilyRepository.save(new SubFamily(subFamilyName, familyRepository.findByFamilyKey(familyKey)));
    }

    public SubFamily findSubFamily(String subFamilyKey){
        return subFamilyRepository.findBySubFamilyKey(subFamilyKey);
    }

    public List<SubFamily> findAllSubFamiliesOfFamily(String familyKey){
        return subFamilyRepository.findByFamilyKey(familyKey);
    }

    public List<SubFamily> findAllSubFamilies(){
        return subFamilyRepository.findAll();
    }

    // Equipment Related Functions
    public Equipment registerNewEquipment(String equipmentName, String subFamilyKey, Integer stock) {
        if (doesEquipmentNameExist(equipmentName))
            throw new IllegalArgumentException("\n\nThis equipment name: " + equipmentName + " is unavailable");

        if (!doesSubFamilyKeyExist(subFamilyKey))
            throw new IllegalArgumentException("\n\nThis subfamily key is invalid");

        if (stock <= 0)
            throw new IllegalArgumentException("\n\nThe stock quantity must be positive");

        return equipmentRepository.save(new Equipment(equipmentName, null, subFamilyRepository.findBySubFamilyKey(subFamilyKey), stock));
    }

    public void editEquipment(Equipment equipment){
        equipmentRepository.save(equipment);
    }

    public void restockEquipment(String equipmentId, Integer stock){ // This function ADDS to the already existing stock; DOES NOT MODIFY
        if (!doesEquipmentIdExist(equipmentId))
            throw new IllegalArgumentException("\n\nThis equipment id is invalid");

        if (stock <= 0)
            throw new IllegalArgumentException("\n\nThe stock quantity must be positive");

        Equipment equipment = equipmentRepository.findByEquipmentId(equipmentId);

        equipment.setStock(equipment.getStock() + stock);

        equipmentRepository.save(equipment);
    }

    public Equipment findEquipmentById(String equipmentId){
        return equipmentRepository.findByEquipmentId(equipmentId);
    }

    public Equipment findEquipmentByName(String equipmentName){
        return equipmentRepository.findByEquipmentName(equipmentName);
    }

    public List<Equipment> findEquipmentsByFamilyKey(String familyKey){
        return equipmentRepository.findByFamilyKey(familyKey);
    }

    public Family findFamilyByFamilyName(String familyName){ return familyRepository.findByFamilyName(familyName); }

    public List<Equipment> findEquipmentsBySubFamilyKey(String subFamilyKey){
        return equipmentRepository.findBySubFamilyKey(subFamilyKey);
    }

    public SubFamily findSubFamilyBySubFamilyName(String subFamilyName){ return subFamilyRepository.findBySubFamilyName(subFamilyName); }

    public List<Equipment> findAllEquipments(){
        return equipmentRepository.findAll();
    }

    // Auxiliary Functions
    private boolean doesFamilyNameExist(String familyName){
        Family family = familyRepository.findByFamilyName(familyName);

        return (family != null);
    }

    private boolean doesFamilyKeyExist(String familyKey){
        Family family = familyRepository.findByFamilyKey(familyKey);

        return (family != null);
    }

    private boolean doesSubFamilyNameExist(String subFamilyName){
        SubFamily subFamily = subFamilyRepository.findBySubFamilyName(subFamilyName);

        return (subFamily != null);
    }

    private boolean doesSubFamilyKeyExist(String subFamilyKey){
        SubFamily subFamily = subFamilyRepository.findBySubFamilyKey(subFamilyKey);

        return (subFamily != null);
    }

    private boolean doesEquipmentNameExist(String equipmentName){
        Equipment equipment = equipmentRepository.findByEquipmentName(equipmentName);

        return (equipment != null);
    }

    private boolean doesEquipmentIdExist(String equipmentId){
        Equipment equipment = equipmentRepository.findByEquipmentId(equipmentId);

        return (equipment != null);
    }
}
