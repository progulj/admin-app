package com.pero.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pero.dao.IPersonDataDao;
import com.pero.model.Person;

public class PersonDataDaoImpl implements IPersonDataDao {



    @Override
    public Person getPersonCroById(long id,Session session, Transaction tx) throws Exception {


	Person person = (Person) session.get(Person.class,
		new Long(id));



	if (person == null) {
	    throw new Exception("Person doesn't exist!");
	}
	return person;
    }

    @SuppressWarnings(value = { "unchecked" })
    @Override
    public List<Person> getPersonsCroList(Session session, Transaction tx) throws Exception {

	List<Person> persons = session.createCriteria(Person.class)
		.list();

	
	return persons;
    }



    @Override
    public boolean addPerson(Person person,Session session, Transaction tx) throws Exception {

	session.save(person);

	return false;
    }

    @Override
    public boolean updatePerson(Person person,Session session, Transaction tx) throws Exception {

	session.update(person);


	return false;
    }

}
