package com.pero.dao;

import java.util.List;

import org.hibernate.Session;

import com.pero.model.EquipmentModel;

public interface IEquipmentModelDataDao {
    
    public boolean addEquipmentModel(EquipmentModel equipmentModel, Session session) throws Exception;
    
    public boolean updateEquipmentModel(EquipmentModel equipmentModel, Session session) throws Exception;
    
    public EquipmentModel getEquipmentModelById(long id, Session session) throws Exception;
    
    public List<EquipmentModel> getEquipmentModelsList( Session session)throws Exception;
    
    public boolean deleteEquipmentModel(long id, Session session) throws Exception;

}
