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

import com.pero.model.Debenture;
import com.pero.model.response.DebentureResponse;
import com.pero.model.response.Response;
import com.pero.model.response.Status;
import com.pero.service.IDebentureService;


@Controller
@RequestMapping("/debenture")
public class DebenetureRestController {
    
    @Autowired
    IDebentureService dataServices;
    
   
    


    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<DebentureResponse>> getDebentureList() {

	List<DebentureResponse> debenetureList = null;
	
	try {
	    debenetureList = dataServices.getDebenturesList();

	} catch (Exception e) {
	   
	    e.printStackTrace();
	    return new ResponseEntity<List<DebentureResponse>>(debenetureList,HttpStatus.BAD_REQUEST);
	    
	}

	return new ResponseEntity<List<DebentureResponse>>(debenetureList,HttpStatus.OK);
    }

    
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<DebentureResponse>> getDebentureListByPerson(@PathVariable("id") long id) {

	List<DebentureResponse> debenetureList = null;
	
	try {
	    debenetureList = dataServices.getDebenturesList(id);

	} catch (Exception e) {
	    
	    e.printStackTrace();
	    return new ResponseEntity<List<DebentureResponse>>(debenetureList,HttpStatus.BAD_REQUEST);
	    
	}

	return new ResponseEntity<List<DebentureResponse>>(debenetureList,HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<Debenture> getDebenture(@PathVariable("id") long id) {
	Debenture debeneture = null;
	try {
	    debeneture = dataServices.getDebentureById(id);

	} catch (Exception e) {
	    
	    return  new Response<Debenture>(0, e.toString(), debeneture);
	}
	return  new Response<Debenture>(200,"Person fetched successfully",debeneture);
    }

    

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status>  addEquimpent(@RequestBody List<Debenture> debentures) {
	
	
	Status status = new Status();
	
	try {
	    dataServices.addDebenture(debentures);
	    status.setMessage("Debenture added successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	    
	    e.printStackTrace();
	    status.setMessage("Debenture add failed !");
	    return new ResponseEntity<Status>( status, HttpStatus.BAD_REQUEST );
	}

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status>  editDebenture(
	    @RequestBody List<Debenture> debentures) {
	
	
	Status status = new Status();
	try {
	    
		dataServices.updateDebenture(debentures);
	    
	    status.setMessage("Debenture edited successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	    
	    e.printStackTrace();
	    status.setMessage("Debenture edit failed !");
	    return new ResponseEntity<Status>( status, HttpStatus.BAD_REQUEST );
	}

    }


    
}
