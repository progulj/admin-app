package com.pero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.model.Person;

public interface IPersonDataDao {
    
    
    public Person getPersonCroById(long id, Session session, Transaction tx) throws Exception;
    
    public List<Person> getPersonsCroList( Session session, Transaction tx) throws Exception;
    
    public boolean addPerson(Person person, Session session, Transaction tx) throws Exception;

    public boolean updatePerson(Person person, Session session, Transaction tx) throws Exception;
    

}
