package com.pero.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.pero.dao.IPersonDataDao;
import com.pero.model.Person;
import com.pero.service.IPersonService;

public class PersonServiceImpl implements IPersonService {

	@Autowired
	IPersonDataDao dataDao;

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public Person getPersonCroById(long id) throws Exception {

		Person result = null;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		try {
			result = dataDao.getPersonCroById(id, session);

			if (tx != null && !tx.wasCommitted()) {
				tx.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {

				session.close();

			}
		}
		return result;
	}

	@Override
	public List<Person> getPersonsCroList() throws Exception {

		List<Person> result = null;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		try {
			result = dataDao.getPersonsCroList(session);
			if (tx != null && !tx.wasCommitted()) {
				tx.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {

				session.close();

			}
		}
		return result;
	}

	@Override
	public boolean addPerson(Person person) throws Exception {

		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			person.setPerson(person.getLastName() + " " + person.getFirstName());

			result = dataDao.addPerson(person, session);

			if (tx != null && !tx.wasCommitted()) {
				tx.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {

				session.close();

			}
		}
		return result;
	}

	@Override
	public boolean updatePerson(Person person) throws Exception {

		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			person.setPerson(person.getLastName() + " " + person.getFirstName());

			result = dataDao.updatePerson(person, session);

			if (tx != null && !tx.wasCommitted()) {
				tx.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {

				session.close();

			}
		}
		return result;
	}

}
