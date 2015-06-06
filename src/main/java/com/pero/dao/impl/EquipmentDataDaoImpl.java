package com.pero.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.pero.dao.IEquipmentDataDao;
import com.pero.model.Equipment;

public class EquipmentDataDaoImpl implements IEquipmentDataDao {

 

    @Override
    public boolean addEquipment(Equipment  equipment, Session session)
	    throws Exception {

	
	session.save(equipment);
	


	return false;
    }
      


    @Override
    public boolean updateEquipment(Equipment  equipment, Session session)
	    throws Exception {


	session.update(equipment);


	return false;
    }

    @Override
    public Equipment getEquipmentBySerialNum(String serialNum,Session session) throws Exception {



	Query query = session
		.createQuery("from Equipment where serial_number in (:serialNum)");
	query.setParameter("serialNum", serialNum);

	@SuppressWarnings("unchecked")
	List<Equipment> equiplist = (List<Equipment>) query.list();

	
	if (equiplist == null || equiplist.size() != 1) {
	    throw new Exception("Equipment doesn't exist!");
	}
	return equiplist.get(0);
    }

    
    @Override
    public Equipment  getEquipmentById(long id,Session session) throws Exception {

	
	Equipment equipment = (Equipment)session.get(Equipment.class, id);

	
	if (equipment  == null) {
	    throw new Exception("Equipment doesn't exist!");
	}
	return equipment ;
    }
    
    @SuppressWarnings(value = { "unchecked" })
    @Override
    public List<Equipment > getEquipmentsList(Session session) throws Exception {


	Criteria criteria = session.createCriteria(Equipment.class);
	
	List<Equipment > equipment = criteria.list();

	
	return equipment ;
    }
    
 
    
    
        @SuppressWarnings(value = { "unchecked" })
    @Override
    public List<Equipment>  getEquipmentByStatusList(Session session, long statusID) throws Exception {

         
   
	Criteria criteria = session.createCriteria(Equipment.class).add( Restrictions.eq("statusId", statusID))
		.addOrder( Order.desc("id") );
	
	List<Equipment > equipment = criteria.list();

	return equipment ;
    }

    @Override
    public boolean deleteEquipment (String id, Session session) throws Exception {


	Object o = session.get(Equipment.class, id);

	session.delete(o);

	
	return false;
    }






}
