package edu.pucmm.practica11_Quiz3.modelo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "family")
public class Family implements Serializable{
    // Attributes
    @Id
    @Column(name = "fkey")
    private String familyKey;
    @Column(name = "fname")
    private String familyName;

    // Constructors
    public Family(){

    }

    public Family(String familyName){
        this.setFamilyKey("PUCMM-FA-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setFamilyName(familyName);
    }

}
