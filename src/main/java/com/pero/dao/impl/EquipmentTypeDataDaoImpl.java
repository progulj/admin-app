package com.pero.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.pero.dao.IEquipmentTypeDataDao;
import com.pero.model.EquipmentType;

public class EquipmentTypeDataDaoImpl implements IEquipmentTypeDataDao {



    @Override
    public boolean addEquipmentType(EquipmentType equipmentType, Session session)
	    throws Exception {

	session.save(equipmentType);


	return false;
    }

    @Override
    public boolean updateEquipmentType(EquipmentType equipmentType,Session session)
	    throws Exception {


	session.update(equipmentType);


	return false;
    }

    @Override
    public EquipmentType getEquipmentTypeById(long id, Session session) throws Exception {
	
	

	
	EquipmentType equipmentType = (EquipmentType) session.get(
		EquipmentType.class, new Long(id));
	


	if (equipmentType == null) {
	    throw new Exception("Equipment type type doesn't exist!");
	}

	return equipmentType;
    }

    @SuppressWarnings(value = { "unchecked" })
    @Override
    public List<EquipmentType> getEquipmentTypesList(Session session) throws Exception {


	
	List<EquipmentType> equipmentType = null;
	
	


	equipmentType = session.createCriteria(
		EquipmentType.class).list();


	return equipmentType;
    }

    @Override
    public boolean deleteEquipmentType(long id,Session session) throws Exception {



	Object o = session.get(EquipmentType.class, id);
	session.delete(o);
	

	return false;
    }

}
