package com.pero.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.pero.dao.ILocationDataDao;
import com.pero.model.Location;
import com.pero.service.ILocationService;

public class LocationServiceImpl implements ILocationService{
    
    @Autowired
    ILocationDataDao dataDao;
    
    @Autowired
    SessionFactory sessionFactory;
    
    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addLocation(Location location) throws Exception {
	
	boolean result = false;
	
	session = sessionFactory.openSession();
	tx = session.beginTransaction();
	try {
	    result = dataDao.addLocation(location, session,tx);
	} catch (Exception e) {
	    throw e;
	} finally {
	    if (!tx.wasCommitted()) {
		tx.commit();
	    }
	    if (session != null && session.isOpen()) {

		session.close();

	    }
	}
	return result;
    }

    @Override
    public boolean updateLocation(Location location) throws Exception {
	
	boolean result = false;
	
	session = sessionFactory.openSession();
	tx = session.beginTransaction();
	try {
	    result =  dataDao.updateLocation(location, session,tx);
	    if (tx!= null && !tx.wasCommitted()) {
		tx.commit();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    if (tx!=null) tx.rollback();
	    throw e;
	} finally {
	    if (session != null && session.isOpen()) {

		session.close();

	    }
	}
	return result;
    }

    @Override
    public Location getLocationById(long id) throws Exception {
	
	Location result = null;
	
	session = sessionFactory.openSession();
	tx = session.beginTransaction();
	try {
	    result =  dataDao.getLocationById(id,session,tx);
	    
	    if (tx!= null && !tx.wasCommitted()) {
		tx.commit();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    if (tx!=null) tx.rollback();
	    throw e;
	} finally {
	    if (session != null && session.isOpen()) {

		session.close();

	    }
	}
	return result;
    }

    @Override
    public List<Location> getLocationsList() throws Exception {
	
	List<Location> result = null;
	
	session = sessionFactory.openSession();
	tx = session.beginTransaction();
	try {
	    result =dataDao.getLocationsList(session,tx);
	    
	    if (tx!= null && !tx.wasCommitted()) {
		tx.commit();
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    if (tx!=null) tx.rollback();
	    throw e;
	} finally {
	    if (session != null && session.isOpen()) {

		session.close();

	    }
	}
	return result;
    }

    @Override
    public boolean deleteLocation(long id) throws Exception {
	
	boolean result = false;
	
	session = sessionFactory.openSession();
	tx = session.beginTransaction();
	try {
	    result = dataDao.deleteLocation(id,session,tx);
	    if (tx!= null && !tx.wasCommitted()) {
		tx.commit();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    if (tx!=null) tx.rollback();
	    throw e;
	} finally {
	    if (session != null && session.isOpen()) {

		session.close();

	    }
	}
	return result;
    }

}
