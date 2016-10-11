package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Event;

@Repository("eventDAO")
@Transactional
public class EventDAOImpl implements EventDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public EventDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		
	}

	@Transactional
	public void deleteEvent(String event_id) {
		Event event = new Event();
		event.setEventid(event_id);
		sessionFactory.getCurrentSession().delete(event);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Event getEvent(String event_id) {
		String hql = "from Event where event_id=" + "'" + event_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> list = (List <Event>) query.list();
		if (list != null && !list.isEmpty())
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Event> list() {
		String hql="from Event";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listEvent=query.list();
		return listEvent;
	}

	@Transactional
	public boolean isEventExist(Event event) {
		return findByTitle(event.getEvent_title())!=null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Event findByTitle(String eventTitle) {
		String hql = "from Event where event_title=" + "'" + eventTitle + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listEvent = (List<Event>) query.list();
		if (listEvent  != null && !listEvent .isEmpty()) {
			return listEvent.get(0);
		}
		return null;
	}

}