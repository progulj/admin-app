package com.pero.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.dao.ILocationDataDao;
import com.pero.model.Location;

public class LocationDataDaoImpl implements ILocationDataDao {

  

    @Override
    public boolean addLocation(Location location, Session session, Transaction tx) throws Exception {


	session.save(location);


	return false;
    }

    @Override
    public boolean updateLocation(Location location, Session session, Transaction tx) throws Exception {


	session.update(location);

	return false;
    }

    @Override
    public Location getLocationById(long id, Session session, Transaction tx) throws Exception {


	Location location = (Location) session
		.get(Location.class, new Long(id));

	if (location == null) {
	    throw new Exception("Location doesn't exist!");
	}
	return location;
    }

    @SuppressWarnings(value = { "unchecked" })
    @Override
    public List<Location> getLocationsList(Session session, Transaction tx) throws Exception {

	List<Location> locationList = session.createCriteria(Location.class)
		.list();


	return locationList;
    }

    @Override
    public boolean deleteLocation(long id, Session session, Transaction tx) throws Exception {

	Object o = session.get(Location.class, id);

	session.delete(o);


	return false;
    }

}
