package com.pero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.model.Debenture;

public interface IDebentureDataDao {
    
    
    public long addDebenture(Debenture debenture, Session session, Transaction tx) throws Exception;
    
    public boolean updateDebenture(Debenture debenture, Session session, Transaction tx)throws Exception;
    
    public Debenture getDebentureById(long id, Session session, Transaction tx) throws Exception;
    
    public Debenture getDebenture(Debenture debenture, Session session, Transaction tx) throws Exception;
    
    public List<Debenture> getDebenturesList( Session session, Transaction tx) throws Exception;
    
    public List<Debenture> getDebenturesList(long id, Session session, Transaction tx) throws Exception;

}
