package com.pero.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "equipment_model")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class EquipmentModel implements Serializable{

    
    public EquipmentModel(){
	
    }
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "ID")
    private long id;
    
    @Column(name = "model")
    private String model;

    @Column(name = "id_type")
    private long typeId;
    
    @Transient
    private EquipmentType type;

    
    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
	return "EquipmentModel [id=" + id + ", model=" + model + ", typeId="
		+ typeId + "]";
    }    

}
