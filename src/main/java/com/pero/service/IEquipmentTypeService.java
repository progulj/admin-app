package com.pero.service;

import java.util.List;

import com.pero.model.EquipmentType;

public interface IEquipmentTypeService {
    
    
    public boolean addEquipmentType(EquipmentType equipmentType) throws Exception;
    
    public boolean updateEquipmentType(EquipmentType equipmentType) throws Exception;
    
    public EquipmentType getEquipmentTypeById(long id) throws Exception;
    
    public List<EquipmentType> getEquipmentTypesList() throws Exception;
    
    public boolean deleteEquipmentType(long id) throws Exception;

    public List<EquipmentType> getAllEquipmentTypes() throws Exception;

}
