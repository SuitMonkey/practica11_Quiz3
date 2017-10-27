package edu.pucmm.practica11_Quiz3.repository;


import edu.pucmm.practica11_Quiz3.modelo.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface RentRepository extends JpaRepository<Rent, String> {

    Rent findByRentId(String rentId);

    @Query("select r from Rent r where r.startDate = :startDate")
    List<Rent> findByStartDate(@Param("startDate") Date startDate);
/*
    @Query("select r from Rent r where r.startdate between :beginning and :ending")
    List<Rent> findByStartDateBetween(@Param("beginning") Date startDate, @Param("ending") Date endDate);
*/
    @Query("select r from Rent r where r.promisedDate = :promisedDate")
    List<Rent> findByPromisedDate(@Param("promisedDate") Date promisedDate);
/*
    @Query("select r from Rent r where r.promiseddate between :beginning and :ending")
    List<Rent> findPromisedDateBetween(@Param("beginning") Date startDate, @Param("ending") Date endDate);
*/
    @Query("select r from Rent r where r.borrower.identificationNumber = :identificationNumber")
    List<Rent> findByBorrower(@Param("identificationNumber") String identificationNumber);

    @Query("select r from Rent r where r.equipment.equipmentId = :equipmentId")
    List<Rent> findByEquipent(@Param("equipmentId") String equipmentId);

    @Query("select r from Rent r where r.active = :active")
    List<Rent> findByActiveStatus(@Param("active") boolean active);
}
