package com.pero.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.pero.dao.IEquipmentStatusDataDao;
import com.pero.model.EquipmentStatus;
import com.pero.service.IEquipmentStatusService;

public class EquipmentStatusServiceImpl implements IEquipmentStatusService {

	@Autowired
	IEquipmentStatusDataDao dataDao;

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEquipmentStatus(EquipmentStatus equipmentStatus)
			throws Exception {

		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao.addEquipmentStatus(equipmentStatus, session);

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
	public boolean updateEquipmentStatus(EquipmentStatus equipmentStatus)
			throws Exception {

		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao
					.updateEquipmentStatus(equipmentStatus, session);

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
	public EquipmentStatus getEquipmentStatusById(long id) throws Exception {

		EquipmentStatus result = null;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao.getEquipmentStatusById(id, session);

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
	public List<EquipmentStatus> getEquipmentStatusesList() throws Exception {

		List<EquipmentStatus> result = null;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			result = dataDao.getEquipmentStatusesListWithoutStatusTwo(session);

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
	public boolean deleteEquipmentStatus(long id) throws Exception {

		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			result = dataDao.deleteEquipmentStatus(id, session);

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
