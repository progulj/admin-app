package com.pero.service;

import java.util.List;

import com.pero.model.EquipmentStatus;

public interface IEquipmentStatusService {
    
    
    public boolean addEquipmentStatus(EquipmentStatus equipmentStatus) throws Exception;
    
    public boolean updateEquipmentStatus(EquipmentStatus equipmentStatus) throws Exception;
    
    public EquipmentStatus getEquipmentStatusById(long id) throws Exception;
    
    public List<EquipmentStatus> getEquipmentStatusesList() throws Exception;
    
    public boolean deleteEquipmentStatus(long id) throws Exception;

}
