package com.pero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pero.model.Location;
import com.pero.model.response.Response;
import com.pero.model.response.Status;
import com.pero.service.ILocationService;

@Controller
@RequestMapping("/location")
public class LocationRestController {

    @Autowired
    ILocationService dataServices;


   
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status> addLocation(@RequestBody Location location) {
	
	
	Status status = new Status();
	try {
	    dataServices.addLocation(location);
	    status.setMessage("Location added successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	    
	    status.setMessage("Location add failed !");
	    return new ResponseEntity<Status>( status,  HttpStatus.BAD_REQUEST );
	}

    }

    
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status> editLocation(@RequestBody Location location) {
	
	Status status = new Status();
	
	try {
	    dataServices.updateLocation(location);
	    
	    status.setMessage("Location edited successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	    
	    status.setMessage("Location update failed !");
	    return new ResponseEntity<Status>( status,  HttpStatus.BAD_REQUEST );
	}

    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Location> getLocation(@PathVariable("id") long id) {
	Location location = null;
	
	try {
	    location = dataServices.getLocationById(id);

	} catch (Exception e) {
	    
	    return  new ResponseEntity<Location>(location,HttpStatus.NO_CONTENT);
	}
	return  new ResponseEntity<Location>(location,HttpStatus.OK);
    }

    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Location>> getLocation() {

	List<Location> locationList = null;
	
	try {
	    locationList = dataServices.getLocationsList();

	} catch (Exception e) {
	    
	    return  new ResponseEntity<List<Location>>(locationList,HttpStatus.BAD_REQUEST);
	}

	return  new ResponseEntity<List<Location>>(locationList,HttpStatus.OK);
    }

    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Response<Object> deleteLocation(@PathVariable("id") long id) {

	try {
	    dataServices.deleteLocation(id);
	    return new Response<Object>(200, "Location deleted successfully !");
	} catch (Exception e) {
	    
	    return new Response<Object>(0, e.toString());
	}

    }

  
}


