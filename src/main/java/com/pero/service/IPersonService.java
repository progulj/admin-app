package com.pero.service;

import java.util.List;

import com.pero.model.Person;

public interface IPersonService {
    
    public Person getPersonCroById(long id) throws Exception;
    
    public List<Person> getPersonsCroList() throws Exception;
   
    public boolean addPerson(Person person) throws Exception;
    
    public boolean updatePerson(Person person) throws Exception;

}
