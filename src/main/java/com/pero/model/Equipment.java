package com.pero.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name = "oprema")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipment implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_OPREMA_ID") 
    @SequenceGenerator(name="SEQ_OPREMA_ID", sequenceName = "SEQ_OPREMA_ID")
    @Column(name = "ID")
    private long id;

    @Column(name = "inventarni_broj")
    private String inventoryNumber;
    
    @Column(name = "model_id")
    private long modelId;
    
    
    @Column(name = "serijski_broj")
    private String serialNumber;
    
    @Column(name = "dat_nabave")
    private Timestamp aquisitionDate;
    
    @Column(name = "dat_istek_jamstva")
    private Timestamp guaranteeExpiryDate;
    
    @Column(name = "status_id")
    private long statusId;
          
    @Column(name = "napomena")
    private String comment;
    
    @Column(name = "licenca")
    private String licence;
    
    @Column(name = "hostname")
    private String hostname;
    
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

    public Timestamp getGuaranteeExpiryDate() {
        return guaranteeExpiryDate;
    }

    public void setGuaranteeExpiryDate(Timestamp guaranteeExpiryDate) {
        this.guaranteeExpiryDate = guaranteeExpiryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
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
