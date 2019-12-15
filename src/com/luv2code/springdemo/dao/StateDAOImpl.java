package com.luv2code.springdemo.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.region.Precincts;
import com.luv2code.springdemo.region.States;


@Repository
public class StateDAOImpl implements StateDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   @Transactional
   public List<String> getStates() {

//      Session currentSession = (Session) new Configuration().configure()
//    		  .buildSessionFactory();
      Session currentSession = sessionFactory.getCurrentSession();
      
      Query<String> theQuery = currentSession.createQuery("select geoJson from States", String.class);
      List<String> states = theQuery.getResultList();
      
  
      return states;
   }

@Override
public States getSingleState(String stateName) {
	Session currentSession = sessionFactory.getCurrentSession();
	
	States state = currentSession.get(States.class, stateName);
	
	return state;
}

}