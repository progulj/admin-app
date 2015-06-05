package com.pero.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pero.dao.IDebentureDataDao;
import com.pero.dao.IEquipmentDataDao;
import com.pero.dao.IEquipmentModelDataDao;
import com.pero.dao.IEquipmentStatusDataDao;
import com.pero.dao.IEquipmentTypeDataDao;
import com.pero.dao.ILocationDataDao;
import com.pero.dao.IPersonDataDao;
import com.pero.model.Debenture;
import com.pero.model.Equipment;
import com.pero.model.EquipmentModel;
import com.pero.model.EquipmentStatus;
import com.pero.model.EquipmentType;
import com.pero.model.Location;
import com.pero.model.Person;
import com.pero.model.response.DebentureResponse;
import com.pero.service.IDebentureService;

@Transactional(rollbackFor = { Exception.class })
public class DebentureServiceImpl implements IDebentureService {

	@Autowired
	IDebentureDataDao dataDao;

	@Autowired
	IEquipmentDataDao equipmentDao;

	@Autowired
	IEquipmentStatusDataDao satatusDao;

	@Autowired
	IEquipmentModelDataDao modelDao;

	@Autowired
	IEquipmentTypeDataDao typeDao;

	@Autowired
	ILocationDataDao locationDao;

	@Autowired
	IPersonDataDao personDao;

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addDebenture(List<Debenture> debentures) throws Exception {

		boolean result = false;
		boolean flag = false;
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Location location = null;

		Person person = null;

		try {
			for (Debenture debenture : debentures) {

				if (!flag) {

					location = locationDao.getLocationById(
							debenture.getIdLocation(), session, tx);

					person = personDao.getPersonCroById(
							debenture.getIdPerson(), session, tx);

					flag = true;
				}

				debenture.setDebentureDate(new Timestamp(System
						.currentTimeMillis()));
				dataDao.addDebenture(debenture, session, tx);

				Debenture deb = dataDao.getDebenture(debenture, session, tx);

				Equipment equipment = equipmentDao.getEquipmentById(
						deb.getIdEquipment(), session, tx);

				long statusId = 2;

				equipment.setStatusId(statusId);

				equipmentDao.updateEquipment(equipment, session, tx);

			}

			result = true;

			if (tx != null && !tx.wasCommitted()) {
				tx.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
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
	public boolean updateDebenture(List<Debenture> debentures) throws Exception {

		boolean result = false;
		boolean flag = false;
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Location location = null;

		Person person = null;

		try {

			for (Debenture debenture : debentures) {

				if (!flag) {

					location = locationDao.getLocationById(
							debenture.getIdLocation(), session, tx);

					person = personDao.getPersonCroById(
							debenture.getIdPerson(), session, tx);

					flag = true;
				}
				Debenture deb = dataDao.getDebentureById(debenture.getId(),
						session, tx);

				deb.setDischargeDate(new Timestamp(System.currentTimeMillis()));

				dataDao.updateDebenture(deb, session, tx);

				deb = dataDao.getDebentureById(debenture.getId(), session, tx);

				Equipment equipment = equipmentDao.getEquipmentById(
						deb.getIdEquipment(), session, tx);

				long statusId = 1;

				equipment.setStatusId(statusId);

				equipmentDao.updateEquipment(equipment, session, tx);

				EquipmentModel equipmentModel = modelDao.getEquipmentModelById(
						equipment.getModelId(), session, tx);

				EquipmentType equipmentType = typeDao.getEquipmentTypeById(
						equipmentModel.getTypeId(), session, tx);

			}

			result = true;

			if (tx != null && !tx.wasCommitted()) {
				tx.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
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
	public Debenture getDebentureById(long id) throws Exception {

		return null;
	}

	@Override
	public List<DebentureResponse> getDebenturesList() throws Exception {

		List<DebentureResponse> debentureResponses = new ArrayList<DebentureResponse>();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			List<Debenture> debentures = dataDao.getDebenturesList(session, tx);

			if (debentures == null || debentures.size() == 0) {

				return null;
			}

			Map<Integer, EquipmentModel> models = new HashMap<Integer, EquipmentModel>();

			Map<Integer, EquipmentStatus> statuses = new HashMap<Integer, EquipmentStatus>();

			Map<Integer, EquipmentType> types = new HashMap<Integer, EquipmentType>();

			Map<Integer, Location> locations = new HashMap<Integer, Location>();

			Map<Integer, Person> persons = new HashMap<Integer, Person>();

			for (EquipmentModel model : modelDao.getEquipmentModelsList(
					session, tx)) {

				models.put((int) model.getId(), model);
			}

			for (EquipmentStatus status : satatusDao.getEquipmentStatusesList(
					session, tx)) {

				statuses.put((int) status.getId(), status);
			}

			for (EquipmentType type : typeDao
					.getEquipmentTypesList(session, tx)) {

				types.put((int) type.getId(), type);
			}

			for (Location location : locationDao.getLocationsList(session, tx)) {

				locations.put((int) location.getId(), location);
			}

			for (Person person : personDao.getPersonsCroList(session, tx)) {

				persons.put((int) person.getId(), person);
			}

			for (Debenture debenture : debentures) {

				DebentureResponse debentureResponse = new DebentureResponse();
				try {

					Equipment equipment = equipmentDao.getEquipmentById(
							debenture.getIdEquipment(), session, tx);

					EquipmentStatus eStatus = statuses.get((int) equipment
							.getStatusId());
					EquipmentModel eModel = models.get((int) equipment
							.getModelId());
					EquipmentType eType = types.get((int) eModel.getTypeId());
					Person ePerson = persons.get((int) debenture.getIdPerson());
					Location eLocation = locations.get((int) debenture
							.getIdLocation());

					debentureResponse.setDebenture(debenture);
					debentureResponse.setEquipment(equipment);
					debentureResponse.setEquipmentStatus(eStatus);
					debentureResponse.setEquipmentModel(eModel);
					debentureResponse.setEquipmentType(eType);
					debentureResponse.setLocation(eLocation);
					debentureResponse.setPerson(ePerson);

				} catch (Exception e) {

					e.printStackTrace();
					System.out.println(e.toString());
				}
				debentureResponses.add(debentureResponse);
			}

			if (tx != null && !tx.wasCommitted()) {
				tx.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {

			if (session != null && session.isOpen()) {

				session.close();

			}
		}
		return debentureResponses;

	}

	@Override
	public boolean deleteDebenture(long id) throws Exception {

		return false;
	}

	@Override
	public List<DebentureResponse> getDebenturesList(long id) throws Exception {

		List<DebentureResponse> debentureResponses = new ArrayList<DebentureResponse>();

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		try {

			List<Debenture> debentures = dataDao.getDebenturesList(id, session,
					tx);

			if (debentures == null || debentures.size() == 0) {

				return null;
			}

			Map<Integer, EquipmentModel> models = new HashMap<Integer, EquipmentModel>();

			Map<Integer, EquipmentStatus> statuses = new HashMap<Integer, EquipmentStatus>();

			Map<Integer, EquipmentType> types = new HashMap<Integer, EquipmentType>();

			Map<Integer, Location> locations = new HashMap<Integer, Location>();

			Map<Integer, Person> persons = new HashMap<Integer, Person>();

			for (EquipmentModel model : modelDao.getEquipmentModelsList(
					session, tx)) {

				models.put((int) model.getId(), model);
			}

			for (EquipmentStatus status : satatusDao.getEquipmentStatusesList(
					session, tx)) {

				statuses.put((int) status.getId(), status);
			}

			for (EquipmentType type : typeDao
					.getEquipmentTypesList(session, tx)) {

				types.put((int) type.getId(), type);
			}

			for (Location location : locationDao.getLocationsList(session, tx)) {

				locations.put((int) location.getId(), location);
			}

			for (Person person : personDao.getPersonsCroList(session, tx)) {

				persons.put((int) person.getId(), person);
			}

			for (Debenture debenture : debentures) {

				DebentureResponse debentureResponse = new DebentureResponse();

				Equipment equipment = equipmentDao.getEquipmentById(
						debenture.getIdEquipment(), session, tx);

				if (equipment.getStatusId() != 2) {
					continue;
				}

				EquipmentStatus eStatus = statuses.get((int) equipment
						.getStatusId());
				EquipmentModel eModel = models
						.get((int) equipment.getModelId());
				EquipmentType eType = types.get((int) eModel.getTypeId());
				Person ePerson = persons.get((int) debenture.getIdPerson());
				Location eLocation = locations.get((int) debenture
						.getIdLocation());

				debentureResponse.setDebenture(debenture);
				debentureResponse.setEquipment(equipment);
				debentureResponse.setEquipmentStatus(eStatus);
				debentureResponse.setEquipmentModel(eModel);
				debentureResponse.setEquipmentType(eType);
				debentureResponse.setLocation(eLocation);
				debentureResponse.setPerson(ePerson);

				debentureResponses.add(debentureResponse);
			}

			if (tx != null && !tx.wasCommitted()) {
				tx.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {

			if (session != null && session.isOpen()) {

				session.close();

			}
		}
		return debentureResponses;

	}

}
