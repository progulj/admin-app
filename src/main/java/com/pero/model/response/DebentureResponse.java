package com.pero.model.response;

import java.util.List;

import com.pero.model.Debenture;
import com.pero.model.Equipment;
import com.pero.model.EquipmentModel;
import com.pero.model.EquipmentStatus;
import com.pero.model.EquipmentType;
import com.pero.model.Location;
import com.pero.model.Person;

public class DebentureResponse {
    
    private Debenture debenture;
    private Person person;
    private Location location;
    private Equipment equipment;
    private EquipmentStatus equipmentStatus;
    private EquipmentModel equipmentModel;
    private EquipmentType equipmentType;
    
    private List<Equipment> equipments;
    private List<EquipmentStatus> equipmentsStatuses;
    private List<EquipmentModel> equipmentsModels;
    private List<EquipmentType> equipmentsTypes;
    public Debenture getDebenture() {
        return debenture;
    }
    public void setDebenture(Debenture debenture) {
        this.debenture = debenture;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    public EquipmentStatus getEquipmentStatus() {
        return equipmentStatus;
    }
    public void setEquipmentStatus(EquipmentStatus equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }
    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }
    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }
    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }
    public List<Equipment> getEquipments() {
        return equipments;
    }
    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
    public List<EquipmentStatus> getEquipmentsStatuses() {
        return equipmentsStatuses;
    }
    public void setEquipmentsStatuses(List<EquipmentStatus> equipmentsStatuses) {
        this.equipmentsStatuses = equipmentsStatuses;
    }
    public List<EquipmentModel> getEquipmentsModels() {
        return equipmentsModels;
    }
    public void setEquipmentsModels(List<EquipmentModel> equipmentsModels) {
        this.equipmentsModels = equipmentsModels;
    }
    public List<EquipmentType> getEquipmentsTypes() {
        return equipmentsTypes;
    }
    public void setEquipmentsTypes(List<EquipmentType> equipmentsTypes) {
        this.equipmentsTypes = equipmentsTypes;
    }

    
    
    
}
