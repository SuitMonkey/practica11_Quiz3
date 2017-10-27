package edu.pucmm.practica11_Quiz3.modelo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "rent")
public class Rent implements Serializable{
    // Attributes
    @Id
    private String rentId;
    private Date startDate;
    private Date promisedDate;
    private float priceRate; // Price per day
    @ManyToOne
    private Client borrower;
    @ManyToOne
    private Equipment equipment;
    private boolean active;
    @Transient
    private int daysOut;

    // Constructors
    public Rent(){

    }

    public Rent(Date promisedDate, float priceRate, Client borrower, Equipment equipment){
        this.setRentId("PUCMM-T-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());

        java.util.Date utilDate = new java.util.Date();
        this.setStartDate(new Date(utilDate.getTime()));

        this.setPromisedDate(promisedDate);
        this.setPriceRate(priceRate);
        this.setBorrower(borrower);
        this.setEquipment(equipment);
        this.setActive(true);
    }



    public int getDaysOut() {
        return (int)((new Date(new java.util.Date().getTime()).getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000));
    }

    public void setDaysOut(int daysOut) {
        this.daysOut = daysOut;
    }
}
