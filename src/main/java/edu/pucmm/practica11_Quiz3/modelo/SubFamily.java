package edu.pucmm.practica11_Quiz3.modelo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "subfamily")
public class SubFamily implements Serializable{
    //Attributes
    @Id
    @Column(name = "skey")
    private String subFamilyKey;
    @Column(name = "sname")
    private String subFamilyName;
    @ManyToOne
    private Family family;

    // Constructors
    public SubFamily(){

    }

    public SubFamily(String subFamilyName, Family family){
        this.setSubFamilyKey("PUCMM-SFA-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setSubFamilyName(subFamilyName);
        this.setFamily(family);
    }

}
