package com.pero.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "equipment_status")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EquipmentStatus implements Serializable {

    /**
     * 
     */
    public EquipmentStatus(){
	
    }
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "status")
    private String status;


    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    @Override
    public String toString() {
	return "EquipmentStatus [id=" + id + ", status=" + status + "]";
    }

}
