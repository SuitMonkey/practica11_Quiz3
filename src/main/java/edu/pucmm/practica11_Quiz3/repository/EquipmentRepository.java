package edu.pucmm.practica11_Quiz3.repository;


import edu.pucmm.practica11_Quiz3.modelo.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, String>{

    Equipment findByEquipmentId(String equipmentId);

    Equipment findByEquipmentName(String equipmentName);

    @Query("select e from Equipment e where e.subFamily.subFamilyKey = :subFamilyKey")
    List<Equipment> findBySubFamilyKey(@Param("subFamilyKey") String subfamilyKey);

    @Query("select e from Equipment e where e.subFamily.family.familyKey = :familyKey")
    List<Equipment> findByFamilyKey(@Param("familyKey") String familyKey);
}
