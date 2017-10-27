package edu.pucmm.practica11_Quiz3.modelo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable{
    @Id
    @Column(name = "username")
    private String username;
    @Column(columnDefinition = "TEXT")
    private String photo;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "pass")
    private String password;
    @Column(name = "permission")
    private boolean admin;

    // Constuctors
    public User(){

    }

    public User(String username, String firstName, String lastName, String password, boolean admin){
        this.setUsername(username);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAdmin(admin);
    }

}
