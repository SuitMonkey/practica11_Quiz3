package edu.pucmm.practica11_Quiz3.repository;


import edu.pucmm.practica11_Quiz3.modelo.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, String>{

    Receipt findByTransactionId(String transactionId);

    @Query("select r from Receipt r where r.transactionDate = :transactionDate")
    List<Receipt> findByTransactionDate(@Param("transactionDate") Date transactionDate);

    @Query("select r from Receipt r where r.borrower.identificationNumber = :identificationNumber")
    List<Receipt> findByBorrower(@Param("identificationNumber") String identificationNumber);

    @Query("select r from Receipt r where r.equipment.equipmentId = :equipmentId")
    List<Receipt> findByEquipent(@Param("equipmentId") String equipmentId);
/*
    @Query("select r from Receipt r where r.tansactiondate between :beginning and :ending")
    List<Receipt> findBetween(@Param("beginning") Date startDate, @Param("ending") Date endDate);*/
}
