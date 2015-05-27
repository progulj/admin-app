package com.pero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.model.EquipmentType;

public interface IEquipmentTypeDataDao {
    
    public boolean addEquipmentType(EquipmentType equipmentType, Session session, Transaction tx)  throws Exception;
    
    public boolean updateEquipmentType(EquipmentType equipmentType, Session session, Transaction tx)  throws Exception;
    
    public EquipmentType getEquipmentTypeById(long id,Session session, Transaction tx)  throws Exception;
    
    public List<EquipmentType> getEquipmentTypesList(Session session, Transaction tx) throws Exception;
    
    public boolean deleteEquipmentType(long id,Session session, Transaction tx)  throws Exception;

}
