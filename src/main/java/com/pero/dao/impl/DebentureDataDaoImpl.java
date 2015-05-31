package com.pero.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.dao.IDebentureDataDao;
import com.pero.model.Debenture;

public class DebentureDataDaoImpl implements IDebentureDataDao{
    
    

    @Override
    public long addDebenture(Debenture debenture, Session session, Transaction tx) throws Exception {
	
	
	
	
	 session.save(debenture);
	

	return debenture.getId();
    }

    @Override
    public boolean updateDebenture(Debenture debenture, Session session, Transaction tx) throws Exception {

	session.update(debenture);

	return false;
    }

    @Override
    public Debenture getDebentureById(long id, Session session, Transaction tx) throws Exception {
	

	
	Debenture debenture = (Debenture) session.get(Debenture.class,
		new Long(id));

	
	return debenture;
	
    }

    @Override
    public List<Debenture> getDebenturesList(Session session, Transaction tx) throws Exception {

	Criteria criteria = session.createCriteria(Debenture.class);
	
	@SuppressWarnings("unchecked")
	List<Debenture > debenture = criteria.list();

	
	return debenture ;
    }

 

    @Override
    public Debenture getDebenture(Debenture debenture, Session session, Transaction tx) throws Exception {
	

	Query query = session.createQuery("from Debenture where id_equipment =(:serialNum) and id_location = (:locationId)  and id_person =(:personId) and discharge_date is null");
        query.setParameter("serialNum", debenture.getIdEquipment());
        query.setParameter("locationId", debenture.getIdLocation());
        query.setParameter("personId", debenture.getIdPerson());
        

        @SuppressWarnings("unchecked")
	List<Debenture> debList =(List<Debenture>)query.list();
        
	
	if (debList  == null || debList.size() != 1) {
	    throw new Exception("Debenture doesn't exist!");
	}
	return debList.get(0) ;
    }

    @Override
    public List<Debenture> getDebenturesList(long id, Session session, Transaction tx) throws Exception {
	

	Query query = session.createQuery("from Debenture where id_person in(:personId) and discharge_date is null");
        query.setParameter("personId", id);
        

        @SuppressWarnings("unchecked")
	List<Debenture> debentures =(List<Debenture>)query.list();
	

	
	return debentures ;
    }

}
