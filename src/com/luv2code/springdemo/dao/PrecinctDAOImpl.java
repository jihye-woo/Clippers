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
public class PrecinctDAOImpl implements PrecinctDAO {

   @Autowired
   private SessionFactory sessionFactory;
   
   @Override
   @Transactional
   public List<String> getPrecinctsBoundaries() {

//      Session currentSession = (Session) new Configuration().configure()
//    		  .buildSessionFactory();
      Session currentSession = sessionFactory.getCurrentSession();
      
      Query<String> theQuery = currentSession.createQuery("select geoJson from Precincts", String.class);
      List<String> precincts = theQuery.getResultList();
      
//      for(String tempPrecinct : precincts) {
//         System.out.println(tempPrecinct);
//      }
      
      return precincts;
   }


@Override
public List<Precincts> getPrecincts() {
	Session currentSession = sessionFactory.getCurrentSession();
    
    Query<Precincts> theQuery = currentSession.createQuery("from Precincts", Precincts.class);
    List<Precincts> precincts = theQuery.getResultList();
    return precincts;
}

}