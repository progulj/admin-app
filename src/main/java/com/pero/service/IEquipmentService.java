package com.pero.service;

import java.util.List;

import com.pero.model.Equipment;
import com.pero.model.response.EquipmentResponse;

public interface IEquipmentService {
    
    public boolean addEquipment(Equipment equipment) throws Exception;
    
    public boolean updateEquipment(Equipment equipment) throws Exception;
    
    public EquipmentResponse getEquipmentById(long id) throws Exception;
    
    public List<EquipmentResponse> getEquipmentsList() throws Exception;
    
    public boolean deleteEquipment(String id) throws Exception;
    
    public EquipmentResponse getEquipmentSelection()throws Exception;
    
    public List<EquipmentResponse> getDebentureEquipmentsList() throws Exception;

}
