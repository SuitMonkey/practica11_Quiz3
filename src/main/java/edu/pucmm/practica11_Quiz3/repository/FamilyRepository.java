package edu.pucmm.practica11_Quiz3.repository;


import edu.pucmm.practica11_Quiz3.modelo.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, String>{

    Family findByFamilyKey(String familyKey);

    Family findByFamilyName(String familyName);
}
