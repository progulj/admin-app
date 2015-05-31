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

import com.pero.model.Equipment;
import com.pero.model.EquipmentModel;
import com.pero.model.EquipmentStatus;
import com.pero.model.EquipmentType;
import com.pero.model.response.EquipmentResponse;
import com.pero.model.response.Response;
import com.pero.model.response.Status;
import com.pero.service.IEquipmentModelService;
import com.pero.service.IEquipmentService;
import com.pero.service.IEquipmentStatusService;
import com.pero.service.IEquipmentTypeService;

@Controller
@RequestMapping("/equipment")
public class EquipmentRestController {

    @Autowired
    IEquipmentTypeService equipmentTypeServices;

    @Autowired
    IEquipmentStatusService equipmentStatusServices;
    
    @Autowired
    IEquipmentModelService equipmentModelServices;
    
    @Autowired
    IEquipmentService equipmentServices;

  

    // *******************************************************************************************

    // Equipment

    // *******************************************************************************************

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status>  addEquimpent(
	    @RequestBody Equipment equipment) {
	
	
	Status status = new Status();
	
	try {
	    equipmentServices.addEquipment(equipment);
	    status.setMessage("Equipment added successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	  
	    e.printStackTrace();
	    status.setMessage("Equipment add failed !");
	    return new ResponseEntity<Status>( status,  HttpStatus.BAD_REQUEST );
	}

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status>  editEquipment(
	    @RequestBody Equipment equipment) {
	
	
	Status status = new Status();
	try {
	    equipmentServices.updateEquipment(equipment);
	    status.setMessage("Equipment edited successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	  
	    e.printStackTrace();
	    status.setMessage("Equipment edit failed !");
	    return new ResponseEntity<Status>( status,  HttpStatus.BAD_REQUEST );
	}

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<EquipmentResponse> getEquipment(
	    @PathVariable("id") long id) {
	EquipmentResponse equipment = null;
	
	try {
	    equipment = equipmentServices.getEquipmentById(id);

	} catch (Exception e) {
	  
	    e.printStackTrace();
	    return new ResponseEntity<EquipmentResponse>(equipment,HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<EquipmentResponse>(equipment,HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<EquipmentResponse>> getEquipment() {

	List<EquipmentResponse> equipments= null;
	
	try {
	    equipments = equipmentServices.getEquipmentsList();

	} catch (Exception e) {
	  
	    return new ResponseEntity<List<EquipmentResponse>>(equipments,HttpStatus.BAD_REQUEST);
	}

	return new ResponseEntity<List<EquipmentResponse>>(equipments,HttpStatus.OK);
    }
          
    
    @RequestMapping(value = "/debenture/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<EquipmentResponse>> getDebentureEquipment() {

	List<EquipmentResponse> equipments= null;
	
	try {
	    equipments = equipmentServices.getDebentureEquipmentsList();

	} catch (Exception e) {
	  
	    e.printStackTrace();
	    return new ResponseEntity<List<EquipmentResponse>>(equipments,HttpStatus.BAD_REQUEST);
	}

	return new ResponseEntity<List<EquipmentResponse>>(equipments,HttpStatus.OK);
    }


    
    @RequestMapping(value = "/selection", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<EquipmentResponse> getEquipmentSelection() {

	EquipmentResponse equipmentResponse= null;
	
	try {
	    equipmentResponse = equipmentServices.getEquipmentSelection();

	} catch (Exception e) {
	  
	    return new ResponseEntity<EquipmentResponse>(equipmentResponse,HttpStatus.NO_CONTENT);
	}

	return new ResponseEntity<EquipmentResponse>(equipmentResponse,HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<Object> deleteEquipment(@PathVariable("id") String id) {

	try {
	    equipmentServices.deleteEquipment(id);
	    return new Response<Object>(200, "Equipment deleted successfully !");
	} catch (Exception e) {
	  
	    return new Response<Object>(0, e.toString());
	}

    }


    // *******************************************************************************************

    // Equipment Type

    // *******************************************************************************************

    @RequestMapping(value = "/type/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  ResponseEntity<Status>  addEquimpentType(
	    @RequestBody EquipmentType equipmentType) {
	
	Status status = new Status();
	
	try {
	    equipmentTypeServices.addEquipmentType(equipmentType);
	    status.setMessage("Equipment type added successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	  
	    e.printStackTrace();
	    status.setMessage("Equipment type add failed !");
	    return new ResponseEntity<Status>( status,  HttpStatus.BAD_REQUEST );
	}

    }

    @RequestMapping(value = "/type/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status> editEquipmentType(
	    @RequestBody EquipmentType equipmentType) {
	
	
	Status status = new Status();
	
	try {
	    equipmentTypeServices.updateEquipmentType(equipmentType);
	    status.setMessage("Equipment type edited successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	  
	    e.printStackTrace();
	    status.setMessage("Equipment type edit failed !");
	    return new ResponseEntity<Status>( status,  HttpStatus.BAD_REQUEST );
	}

    }

    @RequestMapping(value = "/type/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<EquipmentType> getEquipmentType(
	    @PathVariable("id") long id) {
	EquipmentType equipmentType = null;
	try {
	    equipmentType = equipmentTypeServices.getEquipmentTypeById(id);

	} catch (Exception e) {
	  
	    return new Response<EquipmentType>(0, e.toString(), equipmentType);
	}
	return new Response<EquipmentType>(200, "Equipment type fetched successfully !", equipmentType);
    }

    @RequestMapping(value = "/type/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<EquipmentType>> getEquipmentType() {

	
	List<EquipmentType> equipmentTypes = null;
	
	try {
	    equipmentTypes = equipmentTypeServices.getEquipmentTypesList();
	    

	} catch (Exception e) {
	  
	    e.printStackTrace();
	    return new ResponseEntity<List<EquipmentType>>( equipmentTypes,  HttpStatus.BAD_REQUEST );
	}

	return new ResponseEntity<List<EquipmentType>>( equipmentTypes,  HttpStatus.OK );
    }
    
    @RequestMapping(value = "/type/list/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<EquipmentType>> getEquipmentTypeModels() {

	
	List<EquipmentType> equipmentTypes = null;
	
	try {
	    equipmentTypes = equipmentTypeServices.getAllEquipmentTypes();
	    

	} catch (Exception e) {
	  
	    e.printStackTrace();
	    return new ResponseEntity<List<EquipmentType>>( equipmentTypes,  HttpStatus.BAD_REQUEST );
	}

	return new ResponseEntity<List<EquipmentType>>( equipmentTypes,  HttpStatus.OK );
    }

    @RequestMapping(value = "/type/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<Object> deleteEquipmentType(@PathVariable("id") long id) {

	try {
	    equipmentTypeServices.deleteEquipmentType(id);
	    return new Response<Object>(200, "Equipment type deleted successfully !");
	} catch (Exception e) {
	  
	    return new Response<Object>(0, e.toString());
	}

    }

    // *******************************************************************************************

    // Equipment Status

    // *******************************************************************************************

    @RequestMapping(value = "/status/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<Object> addEquimpentStatus(
	    @RequestBody EquipmentStatus equipmentStatus) {
	try {
	    equipmentStatusServices.addEquipmentStatus(equipmentStatus);
	    return new Response<Object>(200, "Equipment status added successfully !");
	} catch (Exception e) {
	  
	    return new Response<Object>(0, e.toString());
	}

    }

    @RequestMapping(value = "/status/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<Object> editEquipmentStatus(
	    @RequestBody EquipmentStatus equipmentStatus) {
	try {
	    equipmentStatusServices.updateEquipmentStatus(equipmentStatus);
	    return new Response<Object>(200, "Equipment status edited successfully !");
	} catch (Exception e) {
	  
	    return new Response<Object>(0, e.toString());
	}

    }

    @RequestMapping(value = "/status/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<EquipmentStatus> getEquipmentStatus(
	    @PathVariable("id") long id) {
	EquipmentStatus equipmentStatus = null;
	try {
	    equipmentStatus = equipmentStatusServices
		    .getEquipmentStatusById(id);

	} catch (Exception e) {
	  
	    return new Response<EquipmentStatus>(0, e.toString(), equipmentStatus);
	}
	return new Response<EquipmentStatus>(200, "Equipment status fetched successfully !", equipmentStatus);
    }

    @RequestMapping(value = "/status/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<EquipmentStatus>> getEquipmentStatus() {

	List<EquipmentStatus> equipmentStatuses = null;
	
	try {
	    equipmentStatuses = equipmentStatusServices
		    .getEquipmentStatusesList();

	} catch (Exception e) {
	  
	    e.printStackTrace();
	    return new ResponseEntity<List<EquipmentStatus>>( equipmentStatuses,  HttpStatus.BAD_REQUEST );
	}

	return new ResponseEntity<List<EquipmentStatus>>( equipmentStatuses,  HttpStatus.OK );
    }

    @RequestMapping(value = "/status/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<Object> deleteEquipmentStatus(
	    @PathVariable("id") long id) {

	
	try {
	    equipmentStatusServices.deleteEquipmentStatus(id);
	    return new Response<Object>(200, "Equipment status deleted successfully !");
	} catch (Exception e) {
	  
	    return new Response<Object>(0, e.toString());
	}

    }

    // *******************************************************************************************

    // Equipment Model

    // *******************************************************************************************

    @RequestMapping(value = "/model/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Status> addEquimpentModel(
	    @RequestBody EquipmentModel equipmentModel) {
	
	
	Status status = new Status();
	
	try {
	    equipmentModelServices.addEquipmentModel(equipmentModel);
	    status.setMessage("Equipment model added successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	  
	    e.printStackTrace();
	    status.setMessage("Equipment model add failed !");
	    return new ResponseEntity<Status>( status,  HttpStatus.BAD_REQUEST );
	}

    }

    @RequestMapping(value = "/model/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  ResponseEntity<Status> editEquipmentModel(
	    @RequestBody EquipmentModel equipmentModel) {
	
	
	Status status = new Status();
	
	try {
	    equipmentModelServices.updateEquipmentModel(equipmentModel);
	    status.setMessage("Equipment model edited successfully !");
	    return new ResponseEntity<Status>( status , HttpStatus.OK);
	} catch (Exception e) {
	  
	    e.printStackTrace();
	    status.setMessage("Equipment model edit failed !");
	    return new ResponseEntity<Status>( status,  HttpStatus.BAD_REQUEST );
	}

    }

    @RequestMapping(value = "/model/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<EquipmentModel> getEquipmentModel(
	    @PathVariable("id") long id) {
	EquipmentModel equipmentModel = null;
	try {
	    equipmentModel = equipmentModelServices
		    .getEquipmentModelById(id);

	} catch (Exception e) {
	  
	    return new Response<EquipmentModel>(0, e.toString(), equipmentModel);
	}
	return new Response<EquipmentModel>(200, "Equipment model fetched successfully !", equipmentModel);
    }

    @RequestMapping(value = "/model/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<EquipmentModel>> getEquipmentModel() {

	List<EquipmentModel> equipmentModels = null;

	
	try {
	    equipmentModels = equipmentModelServices
		    .getEquipmentModelsList();
	    

	} catch (Exception e) {
	  
	    e.printStackTrace();
	    return new ResponseEntity<List<EquipmentModel>>( equipmentModels,  HttpStatus.BAD_REQUEST );
	}

	return new ResponseEntity<List<EquipmentModel>>( equipmentModels,  HttpStatus.OK );
    }

    @RequestMapping(value = "/model/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response<Object> deleteEquipmentModel(
	    @PathVariable("id") long id) {

	try {
	    equipmentModelServices.deleteEquipmentModel(id);
	    return new Response<Object>(200, "Equipment model deleted successfully !");
	} catch (Exception e) {
	  
	    return new Response<Object>(0, e.toString());
	}

    }
    
    
}
