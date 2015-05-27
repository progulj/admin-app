package com.pero.service;

import java.util.List;

import com.pero.model.EquipmentModel;

public interface IEquipmentModelService {
    
    public boolean addEquipmentModel(EquipmentModel equipmentModel) throws Exception;
    
    public boolean updateEquipmentModel(EquipmentModel equipmentModel) throws Exception;
    
    public EquipmentModel getEquipmentModelById(long id) throws Exception;
    
    public List<EquipmentModel> getEquipmentModelsList() throws Exception;
    
    public boolean deleteEquipmentModel(long id) throws Exception;

}
