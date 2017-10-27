package edu.pucmm.practica11_Quiz3.modelo;

import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "equipment")
public class Equipment implements Serializable{
    // Attributes
    @Id
    private String equipmentId;
    private String equipmentName;
    @Column(columnDefinition = "TEXT")
    private Byte[] image;
    @ManyToOne
    private SubFamily subFamily;
    private Integer stock;

    // Constructors
    public Equipment(){

    }

    public Equipment(String equipmentName, Byte[] image, SubFamily subFamily, Integer stock){
        this.setEquipmentId("PUCMM-E-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setEquipmentName(equipmentName);
        this.setImage(image);
        this.setSubFamily(subFamily);
        this.setStock(stock);
    }

    // Auxiliary Function
    public Family getFamily(){
        return subFamily.getFamily();
    }

    public String getImage() {
        if(this.image == null)
            return null;

        byte[] imgBytesAsBase64 = Base64.encodeBase64(toPrimitives(this.image));
        return new String(imgBytesAsBase64);
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    // Auxiliary Function
    private byte[] toPrimitives(Byte[] buffer) {

        byte[] bytes = new byte[buffer.length];
        for(int i = 0; i < buffer.length; i++){
            bytes[i] = buffer[i];
        }
        return bytes;

    }
}
