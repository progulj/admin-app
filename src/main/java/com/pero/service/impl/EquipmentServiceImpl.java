package com.pero.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.pero.dao.IEquipmentDataDao;
import com.pero.dao.IEquipmentModelDataDao;
import com.pero.dao.IEquipmentStatusDataDao;
import com.pero.dao.IEquipmentTypeDataDao;
import com.pero.model.Equipment;
import com.pero.model.EquipmentModel;
import com.pero.model.EquipmentStatus;
import com.pero.model.EquipmentType;
import com.pero.model.response.EquipmentResponse;
import com.pero.service.IEquipmentService;

public class EquipmentServiceImpl implements IEquipmentService {

	@Autowired
	IEquipmentDataDao dataDao;

	@Autowired
	IEquipmentStatusDataDao satatusDao;

	@Autowired
	IEquipmentModelDataDao modelDao;

	@Autowired
	IEquipmentTypeDataDao typeDao;

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEquipment(Equipment equipment) throws Exception {

		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			dataDao.addEquipment(equipment, session);

			result = true;

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
	public boolean updateEquipment(Equipment equipment) throws Exception {

		boolean result = false;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			dataDao.updateEquipment(equipment, session);

			result = true;

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
	public EquipmentResponse getEquipmentById(long id) throws Exception {

		EquipmentResponse equipmentResponse = new EquipmentResponse();

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			Equipment equipment = dataDao.getEquipmentById(id, session);

			EquipmentModel equipmentModel = modelDao.getEquipmentModelById(
					equipment.getModelId(), session);

			EquipmentStatus equipmentStatus = satatusDao
					.getEquipmentStatusById(equipment.getStatusId(), session);

			equipmentResponse.setEquipment(equipment);
			equipmentResponse.setEquipmentStatus(equipmentStatus);
			equipmentResponse.setEquipmentModel(equipmentModel);
			equipmentResponse.setEquipmentType(typeDao.getEquipmentTypeById(
					equipmentModel.getTypeId(), session));

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

		return equipmentResponse;
	}

	@Override
	public List<EquipmentResponse> getEquipmentsList() throws Exception {

		List<EquipmentResponse> equipmentResponses = new ArrayList<EquipmentResponse>();

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			List<Equipment> equipments = dataDao.getEquipmentsList(session);

			if (equipments == null || equipments.size() == 0) {

				return null;
			}

			Map<Integer, EquipmentModel> models = new HashMap<Integer, EquipmentModel>();

			Map<Integer, EquipmentStatus> statuses = new HashMap<Integer, EquipmentStatus>();

			Map<Integer, EquipmentType> types = new HashMap<Integer, EquipmentType>();

			for (EquipmentModel model : modelDao.getEquipmentModelsList(
					session)) {

				models.put((int) model.getId(), model);
			}

			for (EquipmentStatus status : satatusDao.getEquipmentStatusesList(
					session)) {

				statuses.put((int) status.getId(), status);
			}

			for (EquipmentType type : typeDao
					.getEquipmentTypesList(session)) {

				types.put((int) type.getId(), type);
			}

			for (Equipment equipment : equipments) {

				EquipmentResponse equipmentResponse = new EquipmentResponse();
				try {
					equipmentResponse.setEquipment(equipment);

					EquipmentStatus eStatus = statuses.get((int) equipment
							.getStatusId());
					EquipmentModel eModel = models.get((int) equipment
							.getModelId());
					EquipmentType eType = types.get((int) eModel.getTypeId());

					equipmentResponse.setEquipmentStatus(eStatus);
					equipmentResponse.setEquipmentModel(eModel);
					equipmentResponse.setEquipmentType(eType);

				} catch (Exception e) {

					e.printStackTrace();
					System.out.println(e.toString());
				}
				equipmentResponses.add(equipmentResponse);
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
		return equipmentResponses;

	}

	@Override
	public List<EquipmentResponse> getDebentureEquipmentsList()
			throws Exception {

		List<EquipmentResponse> equipmentResponses = new ArrayList<EquipmentResponse>();

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			long statusID = 1;
			List<Equipment> equipments = dataDao.getEquipmentByStatusList(
					session, statusID);

			if (equipments == null || equipments.size() == 0) {

				return null;
			}

			Map<Integer, EquipmentModel> models = new HashMap<Integer, EquipmentModel>();

			Map<Integer, EquipmentStatus> statuses = new HashMap<Integer, EquipmentStatus>();

			Map<Integer, EquipmentType> types = new HashMap<Integer, EquipmentType>();

			for (EquipmentModel model : modelDao.getEquipmentModelsList(
					session)) {

				models.put((int) model.getId(), model);
			}

			for (EquipmentStatus status : satatusDao.getEquipmentStatusesList(
					session)) {

				statuses.put((int) status.getId(), status);
			}

			for (EquipmentType type : typeDao
					.getEquipmentTypesList(session)) {

				types.put((int) type.getId(), type);
			}

			for (Equipment equipment : equipments) {

				EquipmentResponse equipmentResponse = new EquipmentResponse();
				try {
					equipmentResponse.setEquipment(equipment);

					EquipmentStatus eStatus = statuses.get((int) equipment
							.getStatusId());
					EquipmentModel eModel = models.get((int) equipment
							.getModelId());
					EquipmentType eType = types.get((int) eModel.getTypeId());

					equipmentResponse.setEquipmentStatus(eStatus);
					equipmentResponse.setEquipmentModel(eModel);
					equipmentResponse.setEquipmentType(eType);

				} catch (Exception e) {

					e.printStackTrace();
					System.out.println(e.toString());
				}
				equipmentResponses.add(equipmentResponse);
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
		return equipmentResponses;

	}

	@Override
	public EquipmentResponse getEquipmentSelection() throws Exception {

		EquipmentResponse equipmentResponse = new EquipmentResponse();

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			List<EquipmentModel> models = modelDao.getEquipmentModelsList(
					session);
			List<EquipmentStatus> statuses = satatusDao
					.getEquipmentStatusesList(session);
			List<EquipmentType> types = typeDao.getEquipmentTypesList(session);

			equipmentResponse.setEquipmentsModels(models);
			equipmentResponse.setEquipmentsStatuses(statuses);
			equipmentResponse.setEquipmentsTypes(types);

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

		return equipmentResponse;

	}

	@Override
	public boolean deleteEquipment(String id) throws Exception {

		boolean result;
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {
			result = dataDao.deleteEquipment(id, session);

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
