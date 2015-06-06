package com.pero.dao;

import java.util.List;

import org.hibernate.Session;

import com.pero.model.EquipmentType;

public interface IEquipmentTypeDataDao {
    
    public boolean addEquipmentType(EquipmentType equipmentType, Session session)  throws Exception;
    
    public boolean updateEquipmentType(EquipmentType equipmentType, Session session)  throws Exception;
    
    public EquipmentType getEquipmentTypeById(long id,Session session)  throws Exception;
    
    public List<EquipmentType> getEquipmentTypesList(Session session) throws Exception;
    
    public boolean deleteEquipmentType(long id,Session session)  throws Exception;

}
