package edu.pucmm.practica11_Quiz3.modelo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "client")
public class Client implements Serializable{
    // Attributes
    @Id
    @Size(min=5, max=30)
    private String identificationNumber; // Cedula
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "address")
    private String address;
//    @Column(columnDefinition = "TEXT")
//    private String photo;

    // Constructor
    public Client(){

    }

    public Client(String identificationNumber, String firstName, String lastName, String telephone, String address){
        this.setIdentificationNumber(identificationNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTelephone(telephone);
        this.setAddress(address);
    }

}
