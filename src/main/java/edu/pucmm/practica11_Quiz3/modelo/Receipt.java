package edu.pucmm.practica11_Quiz3.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "receipt")
public class Receipt implements Serializable{
    // Attributes
    @Id
    private String transactionId;
    private Date transactionDate;
    private float totalPrice;
    @ManyToOne
    private Client borrower;
    @ManyToOne
    private Equipment equipment;

    // Constructors
    public Receipt(){

    }

    public Receipt(float totalPrice, Client borrower, Equipment equipment){
        this.setTransactionId("PUCMM-R-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());

        java.util.Date utilDate = new java.util.Date();
        this.setTransactionDate(new Date(utilDate.getTime()));

        this.setTotalPrice(totalPrice);
        this.setBorrower(borrower);
        this.setEquipment(equipment);
    }

}
