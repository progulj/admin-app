package com.pero.dao;

import java.util.List;

import org.hibernate.Session;

import com.pero.model.Equipment;

public interface IEquipmentDataDao {
    
    
    public boolean addEquipment(Equipment equipment, Session session) throws Exception;
    
    public boolean updateEquipment(Equipment equipment, Session session) throws Exception;
    
    public Equipment getEquipmentById(long id, Session session) throws Exception;
    
    public Equipment getEquipmentBySerialNum(String serialNumber, Session session) throws Exception;
    
    public List<Equipment> getEquipmentsList( Session session) throws Exception;
    
    public boolean deleteEquipment(String id, Session session) throws Exception;
       
    public List<Equipment> getEquipmentByStatusList( Session session,  long stausId) throws Exception;

}
