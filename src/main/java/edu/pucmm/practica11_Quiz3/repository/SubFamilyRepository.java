package edu.pucmm.practica11_Quiz3.repository;


import edu.pucmm.practica11_Quiz3.modelo.SubFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubFamilyRepository extends JpaRepository<SubFamily, String>{

    SubFamily findBySubFamilyKey(String subFamilyKey);

    SubFamily findBySubFamilyName(String subFamilyName);

    @Query("select s from SubFamily s where s.family.familyKey = :familyKey")
    List<SubFamily> findByFamilyKey(@Param("familyKey") String familyKey);
}
