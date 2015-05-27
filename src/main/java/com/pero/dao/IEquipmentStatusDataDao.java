package com.pero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.model.EquipmentStatus;

public interface IEquipmentStatusDataDao {
    
    public boolean addEquipmentStatus(EquipmentStatus equipmentStatus, Session session, Transaction tx) throws Exception;
    
    public boolean updateEquipmentStatus(EquipmentStatus equipmentStatus, Session session, Transaction tx) throws Exception;
    
    public EquipmentStatus getEquipmentStatusById(long id, Session session, Transaction tx) throws Exception;
    
    public List<EquipmentStatus> getEquipmentStatusesList(Session session, Transaction tx) throws Exception;
    
    public boolean deleteEquipmentStatus(long id, Session session, Transaction tx) throws Exception;

    List<EquipmentStatus> getEquipmentStatusesListWithoutStatusTwo(Session session, Transaction tx)
	    throws Exception;

}
