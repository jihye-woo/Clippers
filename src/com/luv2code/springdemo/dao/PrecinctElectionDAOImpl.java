package com.luv2code.springdemo.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.region.PrecinctElection;
import com.luv2code.springdemo.region.Precincts;


@Repository
public class PrecinctElectionDAOImpl implements PrecinctElectionDAO {

   @Autowired
   private SessionFactory sessionFactory;
   

   @Override
   @Transactional
   public PrecinctElection getPrecinctElections(int precinctId, ElectionTerm et) {

//      Session currentSession = (Session) new Configuration().configure()
//    		  .buildSessionFactory();
      Session currentSession = sessionFactory.getCurrentSession();
      
      Query<PrecinctElection> theQuery = currentSession.createQuery(
    		  "select * from PrecinctElection where pid:=precinctid AND electionType=:electiontype AND electionYear=:electionyear", PrecinctElection.class);
      theQuery.setParameter("precinctid", precinctId);
      theQuery.setParameter("electiontype", et.getElectionType());
      theQuery.setParameter("electionyear", et.getElectionYear());
      PrecinctElection precinctElections = theQuery.getSingleResult();
      
//      for(String tempPrecinct : precincts) {
//         System.out.println(tempPrecinct);
//      }
      
      return precinctElections;
   }

}