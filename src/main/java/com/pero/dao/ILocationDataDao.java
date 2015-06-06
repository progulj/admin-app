package com.pero.dao;

import java.util.List;

import org.hibernate.Session;

import com.pero.model.Location;

public interface ILocationDataDao {
    
    public boolean addLocation(Location location, Session session) throws Exception;
    
    public boolean updateLocation(Location location, Session session) throws Exception;
    
    public Location getLocationById(long id, Session session) throws Exception;
    
    public List<Location> getLocationsList(Session session) throws Exception;
    
    public boolean deleteLocation(long id, Session session) throws Exception;

}
