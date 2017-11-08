package edu.pucmm.practica11_Quiz3.modelo;

import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;

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
    @Column(columnDefinition = "TEXT")
    private Byte[] photo;

    // Constructor
    public Client(){

    }

    public Client(String identificationNumber, String firstName, String lastName, String telephone, String address, Byte[] photo){
        this.setIdentificationNumber(identificationNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTelephone(telephone);
        this.setAddress(address);
        this.setPhoto(photo);
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        if(this.photo == null)
            return null;

        byte[] imgBytesAsBase64 = Base64.encodeBase64(toPrimitives(this.photo));
        return new String(imgBytesAsBase64);
    }

    private byte[] toPrimitives(Byte[] buffer) {

        byte[] bytes = new byte[buffer.length];
        for(int i = 0; i < buffer.length; i++){
            bytes[i] = buffer[i];
        }
        return bytes;

    }
}
