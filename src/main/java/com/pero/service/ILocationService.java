package com.pero.service;

import java.util.List;

import com.pero.model.Location;

public interface ILocationService {
    
    
    public boolean addLocation(Location location) throws Exception;
    
    public boolean updateLocation(Location location) throws Exception;
    
    public Location getLocationById(long id) throws Exception;
    
    public List<Location> getLocationsList() throws Exception;
    
    public boolean deleteLocation(long id) throws Exception;

}
