package com.pero.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name = "debenture")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Debenture implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "ID")
    private long id;
 
    @Column(name = "id_person")
    private long personId;
    
    @Column(name = "id_location")
    private long locationId;
    
    @Column(name = "debenture_date")
    private Timestamp debentureDate;
    
    @Column(name = "discharge_date")
    private Timestamp dischargeDate;
    
    @Column(name = "id_equipment")
    private long equipmentId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public Timestamp getDebentureDate() {
        return debentureDate;
    }

    public void setDebentureDate(Timestamp debentureDate) {
        this.debentureDate = debentureDate;
    }

    public Timestamp getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Timestamp dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(long equipmentId) {
        this.equipmentId = equipmentId;
    }



    
    

}
