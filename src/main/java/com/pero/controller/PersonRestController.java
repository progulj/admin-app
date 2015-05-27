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

import com.pero.model.Person;
import com.pero.model.response.Response;
import com.pero.model.response.Status;
import com.pero.service.IPersonService;
import com.pero.util.Header;


@Controller
@RequestMapping("/person")
public class PersonRestController {
    
    @Autowired
    IPersonService dataServices;
    
    static final Logger logger = Logger.getLogger(PersonRestController.class);
    
    @RequestMapping(value = "/internal/{id}", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<Person> getPersonInternal(@PathVariable("id") long id) {
	Person person = null;
	try {
	    person = dataServices.getPersonCroById(id);

	} catch (Exception e) {
	    logger.error(e);
	    return  new Response<Person>(0, e.toString(), person);
	}
	return  new Response<Person>(200,"Person fetched successfully",person);
    }

    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Person>> getPersonsInternal() {

	List<Person> personList = null;
	Header header = new Header();
	try {
	    personList = dataServices.getPersonsCroList();

	} catch (Exception e) {
	    logger.error(e);
	    e.printStackTrace();
	    return new ResponseEntity<List<Person>>(personList,header,HttpStatus.BAD_REQUEST);
	    
	}

	return new ResponseEntity<List<Person>>(personList,header,HttpStatus.OK);
    }
 
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status> addPerson(@RequestBody Person person) {
	
	Header header = new Header();
	Status status = new Status();
	try {
	    dataServices.addPerson(person);
	    status.setMessage("Person added successfully !");
	    return new ResponseEntity<Status>( status ,header, HttpStatus.OK);
	} catch (Exception e) {
	    logger.error(e);
	    e.printStackTrace();
	    status.setMessage("Person add failed !");
	    return new ResponseEntity<Status>( status, header, HttpStatus.BAD_REQUEST );
	}

    }

    
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status> editPerson(@RequestBody Person person) {
	Header header = new Header();
	Status status = new Status();
	
	try {
	    dataServices.updatePerson(person);
	    
	    status.setMessage("Person edited successfully !");
	    return new ResponseEntity<Status>( status ,header, HttpStatus.OK);
	} catch (Exception e) {
	    logger.error(e);
	    e.printStackTrace();
	    status.setMessage("Person update failed !");
	    return new ResponseEntity<Status>( status, header, HttpStatus.BAD_REQUEST );
	}

    }

}
