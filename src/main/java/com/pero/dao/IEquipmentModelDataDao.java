package com.pero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.model.EquipmentModel;

public interface IEquipmentModelDataDao {
    
    public boolean addEquipmentModel(EquipmentModel equipmentModel, Session session, Transaction tx) throws Exception;
    
    public boolean updateEquipmentModel(EquipmentModel equipmentModel, Session session, Transaction tx) throws Exception;
    
    public EquipmentModel getEquipmentModelById(long id, Session session, Transaction tx) throws Exception;
    
    public List<EquipmentModel> getEquipmentModelsList( Session session, Transaction tx)throws Exception;
    
    public boolean deleteEquipmentModel(long id, Session session, Transaction tx) throws Exception;

}
