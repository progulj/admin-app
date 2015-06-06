package com.pero.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pero.dao.IEquipmentStatusDataDao;
import com.pero.model.EquipmentStatus;

public class EquipmentStatusDataDaoImpl implements IEquipmentStatusDataDao {


    @Override
    public boolean addEquipmentStatus(EquipmentStatus equimpentStatus,Session session)
	    throws Exception {
	
	session.save(equimpentStatus);


	return false;
    }

    @Override
    public boolean updateEquipmentStatus(EquipmentStatus equimpentStatus,Session session)
	    throws Exception {


	session.update(equimpentStatus);

	return false;
    }

    @Override
    public EquipmentStatus getEquipmentStatusById(long id,Session session) throws Exception {

	

	EquipmentStatus equimpentStatus = (EquipmentStatus) session.get(
		EquipmentStatus.class, new Long(id));



	if (equimpentStatus == null) {
	    throw new Exception("Equipment status type doesn't exist!");
	}
	return equimpentStatus;
    }

    @SuppressWarnings(value = { "unchecked" })
    @Override
    public List<EquipmentStatus> getEquipmentStatusesList(Session session) throws Exception {

	List<EquipmentStatus> equimpentStatus = session.createCriteria(
		EquipmentStatus.class).list();
	
	return equimpentStatus;
    }

    @SuppressWarnings(value = { "unchecked" })
    @Override
    public List<EquipmentStatus> getEquipmentStatusesListWithoutStatusTwo(Session session)
	    throws Exception {

	long statusId = 2;

	Query query = session
		.createQuery("from EquipmentStatus where id not in (:statusId) ");
	query.setParameter("statusId", statusId);

	List<EquipmentStatus> equimpentStatus = (List<EquipmentStatus>) query
		.list();


	return equimpentStatus;
    }

    @Override
    public boolean deleteEquipmentStatus(long id,Session session) throws Exception {

	Object o = session.get(EquipmentStatus.class, id);

	session.delete(o);

	return false;
    }

}
