package com.pero.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name = "equipment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipment implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "inventory_number")
    private String inventoryNumber;
    
    @Column(name = "id_model")
    private long modelId;
    
    
    @Column(name = "serial_number")
    private String serialNumber;
    
    @Column(name = "acquiring_date")
    private Timestamp aquisitionDate;

    
    @Column(name = "id_status")
    private long statusId;
          
    @Column(name = "comment")
    private String comment;

    @Transient
    private String person;

    
    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Timestamp getAquisitionDate() {
        return aquisitionDate;
    }

    public void setAquisitionDate(Timestamp aquisitionDate) {
        this.aquisitionDate = aquisitionDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
