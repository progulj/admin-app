package com.pero.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.dao.IEquipmentModelDataDao;
import com.pero.model.EquipmentModel;

public class EquipmentModelDataDaoImpl implements IEquipmentModelDataDao {


    @Override
    public boolean addEquipmentModel(EquipmentModel equipmentModel, Session session, Transaction tx)
	    throws Exception {

	session.save(equipmentModel);

	return false;
    }

    @Override
    public boolean updateEquipmentModel(EquipmentModel equipmentModel, Session session, Transaction tx)
	    throws Exception {


	
	session.update(equipmentModel);
	


	return false;
    }

    @Override
    public EquipmentModel getEquipmentModelById(long id, Session session, Transaction tx) throws Exception {
	
	
	EquipmentModel equipmentModel = null;
	
	
	 equipmentModel = (EquipmentModel) session.get(
		EquipmentModel.class, new Long(id));
	
	
	if (equipmentModel == null) {
	    throw new Exception("Equipment model type doesn't exist!");
	}
	return equipmentModel;
    }

    @SuppressWarnings(value = { "unchecked" })
    @Override
    public List<EquipmentModel> getEquipmentModelsList( Session session, Transaction tx) throws Exception {

	
	List<EquipmentModel> equipmentModel = null;
	
	
	 equipmentModel = session.createCriteria(
		EquipmentModel.class).list();

	
	return equipmentModel;
    }

    @Override
    public boolean deleteEquipmentModel(long id, Session session, Transaction tx)  throws Exception {

	
	Object o = session.get(EquipmentModel.class, id);
	
	session.delete(o);
	
	return false;
    }


}
