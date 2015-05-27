package com.pero.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "equipment_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class EquipmentType implements Serializable{

    
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "type")
    private String type;
    
    @Transient
    private List<EquipmentModel> models;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<EquipmentModel> getModels() {
	return models;
    }

    public void setModels(List<EquipmentModel> models) {
	this.models = models;
    }

    @Override
    public String toString() {
	return "EquipmentType [id=" + id + ", type=" + type + "]";
    }


    

}
