package com.pero.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.pero.dao.IEquipmentModelDataDao;
import com.pero.dao.IEquipmentTypeDataDao;
import com.pero.model.EquipmentModel;
import com.pero.model.EquipmentType;
import com.pero.service.IEquipmentModelService;

public class EquipmentModelServiceImpl implements IEquipmentModelService {

	@Autowired
	IEquipmentModelDataDao dataDao;

	@Autowired
	IEquipmentTypeDataDao typeDao;

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEquipmentModel(EquipmentModel equipmentModel)
			throws Exception {

		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao.addEquipmentModel(equipmentModel, session);

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
	public boolean updateEquipmentModel(EquipmentModel equipmentModel)
			throws Exception {
		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao.updateEquipmentModel(equipmentModel, session);

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
	public EquipmentModel getEquipmentModelById(long id) throws Exception {
		EquipmentModel result = null;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			result = dataDao.getEquipmentModelById(id, session);

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
	public List<EquipmentModel> getEquipmentModelsList() throws Exception {

		List<EquipmentModel> result = new ArrayList<EquipmentModel>();

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			List<EquipmentType> types = new ArrayList<EquipmentType>();
			List<EquipmentModel> models = new ArrayList<EquipmentModel>();

			types = typeDao.getEquipmentTypesList(session);
			models = dataDao.getEquipmentModelsList(session);

			if (models == null || models.size() == 0) {
				throw new Exception("No models were selected!");
			}

			for (EquipmentModel model : models) {

				for (EquipmentType type : types) {

					if (type.getId() == model.getTypeId()) {
						model.setType(type);

					}
				}

				result.add(model);

			}

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
	public boolean deleteEquipmentModel(long id) throws Exception {
		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			result = dataDao.deleteEquipmentModel(id, session);

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
