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
import com.pero.service.IEquipmentTypeService;

public class EquipmentTypeServiceImpl implements IEquipmentTypeService {

	@Autowired
	IEquipmentTypeDataDao dataDao;

	@Autowired
	IEquipmentModelDataDao modelDao;

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEquipmentType(EquipmentType equipmentType)
			throws Exception {
		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao.addEquipmentType(equipmentType, session);

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
	public boolean updateEquipmentType(EquipmentType equipmentType)
			throws Exception {
		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao.updateEquipmentType(equipmentType, session);

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
	public EquipmentType getEquipmentTypeById(long id) throws Exception {
		EquipmentType result = null;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			dataDao.getEquipmentTypeById(id, session);

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
	public List<EquipmentType> getEquipmentTypesList() throws Exception {

		List<EquipmentType> types = new ArrayList<EquipmentType>();
		List<EquipmentType> retTypes = new ArrayList<EquipmentType>();
		List<EquipmentModel> models = new ArrayList<EquipmentModel>();

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			types = dataDao.getEquipmentTypesList(session);
			models = modelDao.getEquipmentModelsList(session);
			if (types == null || types.size() == 0) {
				throw new Exception("No types were selected!");
			}

			for (EquipmentType type : types) {
				List<EquipmentModel> typModels = new ArrayList<EquipmentModel>();
				for (EquipmentModel model : models) {

					if (type.getId() == model.getTypeId()) {
						typModels.add(model);

					}
				}
				type.setModels(typModels);
				// if (typModels != null && typModels.size() > 0) {
				retTypes.add(type);
				// }
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

		return retTypes;
	}

	@Override
	public List<EquipmentType> getAllEquipmentTypes() throws Exception {
		List<EquipmentType> result = null;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao.getEquipmentTypesList(session);

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
	public boolean deleteEquipmentType(long id) throws Exception {
		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao.deleteEquipmentType(id, session);

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
