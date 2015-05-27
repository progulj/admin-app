package com.pero.controller;

import java.util.List;

import org.apache.log4j.Logger;
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
import com.pero.util.Header;

@Controller
@RequestMapping("/location")
public class LocationRestController {

    @Autowired
    ILocationService dataServices;

    static final Logger logger = Logger.getLogger(LocationRestController.class);

   
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status> addLocation(@RequestBody Location location) {
	
	Header header = new Header();
	Status status = new Status();
	try {
	    dataServices.addLocation(location);
	    status.setMessage("Location added successfully !");
	    return new ResponseEntity<Status>( status ,header, HttpStatus.OK);
	} catch (Exception e) {
	    logger.error(e);
	    status.setMessage("Location add failed !");
	    return new ResponseEntity<Status>( status, header, HttpStatus.BAD_REQUEST );
	}

    }

    
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status> editLocation(@RequestBody Location location) {
	Header header = new Header();
	Status status = new Status();
	
	try {
	    dataServices.updateLocation(location);
	    
	    status.setMessage("Location edited successfully !");
	    return new ResponseEntity<Status>( status ,header, HttpStatus.OK);
	} catch (Exception e) {
	    logger.error(e);
	    status.setMessage("Location update failed !");
	    return new ResponseEntity<Status>( status, header, HttpStatus.BAD_REQUEST );
	}

    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Location> getLocation(@PathVariable("id") long id) {
	Location location = null;
	Header header = new Header();
	try {
	    location = dataServices.getLocationById(id);

	} catch (Exception e) {
	    logger.error(e);
	    return  new ResponseEntity<Location>(location,header,HttpStatus.NO_CONTENT);
	}
	return  new ResponseEntity<Location>(location,header,HttpStatus.OK);
    }

    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Location>> getLocation() {

	List<Location> locationList = null;
	Header header = new Header();
	try {
	    locationList = dataServices.getLocationsList();

	} catch (Exception e) {
	    logger.error(e);
	    return  new ResponseEntity<List<Location>>(locationList,header,HttpStatus.BAD_REQUEST);
	}

	return  new ResponseEntity<List<Location>>(locationList,header,HttpStatus.OK);
    }

    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Response<Object> deleteLocation(@PathVariable("id") long id) {

	try {
	    dataServices.deleteLocation(id);
	    return new Response<Object>(200, "Location deleted successfully !");
	} catch (Exception e) {
	    logger.error(e);
	    return new Response<Object>(0, e.toString());
	}

    }

  
}


