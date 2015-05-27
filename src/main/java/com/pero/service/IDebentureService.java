package com.pero.service;

import java.util.List;

import com.pero.model.Debenture;
import com.pero.model.response.DebentureResponse;

public interface IDebentureService {
    
    
    
    public boolean addDebenture(List<Debenture> debentures) throws Exception;
    
    public boolean updateDebenture(List<Debenture> debentures) throws Exception;
    
    public Debenture getDebentureById(long id) throws Exception;
    
    public List<DebentureResponse> getDebenturesList() throws Exception;
    
    public boolean deleteDebenture(long id) throws Exception;

    public List<DebentureResponse> getDebenturesList(long id) throws Exception;

   


}
