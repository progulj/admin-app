package com.pero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.model.Equipment;

public interface IEquipmentDataDao {
    
    
    public boolean addEquipment(Equipment equipment, Session session, Transaction tx) throws Exception;
    
    public boolean updateEquipment(Equipment equipment, Session session, Transaction tx) throws Exception;
    
    public Equipment getEquipmentById(long id, Session session, Transaction tx) throws Exception;
    
    public Equipment getEquipmentBySerialNum(String serialNumber, Session session, Transaction tx) throws Exception;
    
    public List<Equipment> getEquipmentsList( Session session, Transaction tx) throws Exception;
    
    public boolean deleteEquipment(String id, Session session, Transaction tx) throws Exception;
       
    public List<Equipment> getEquipmentByStatusList( Session session, Transaction tx, long stausId) throws Exception;

}
