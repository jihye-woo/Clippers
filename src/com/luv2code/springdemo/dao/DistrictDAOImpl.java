package com.luv2code.springdemo.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.region.Precincts;


@Repository
public class DistrictDAOImpl implements DistrictDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   @Transactional
   public List<String> getDistricts() {

//      Session currentSession = (Session) new Configuration().configure()
//    		  .buildSessionFactory();
      Session currentSession = sessionFactory.getCurrentSession();
      
      Query<String> theQuery = currentSession.createQuery("select geoJson from Districts", String.class);
      List<String> districts = theQuery.getResultList();
  
      return districts;
   }

}