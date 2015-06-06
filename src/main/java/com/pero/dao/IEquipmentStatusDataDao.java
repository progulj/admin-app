package com.pero.dao;

import java.util.List;

import org.hibernate.Session;

import com.pero.model.EquipmentStatus;

public interface IEquipmentStatusDataDao {
    
    public boolean addEquipmentStatus(EquipmentStatus equipmentStatus, Session session) throws Exception;
    
    public boolean updateEquipmentStatus(EquipmentStatus equipmentStatus, Session session) throws Exception;
    
    public EquipmentStatus getEquipmentStatusById(long id, Session session) throws Exception;
    
    public List<EquipmentStatus> getEquipmentStatusesList(Session session) throws Exception;
    
    public boolean deleteEquipmentStatus(long id, Session session) throws Exception;

    List<EquipmentStatus> getEquipmentStatusesListWithoutStatusTwo(Session session)
	    throws Exception;

}
