package com.luv2code.springdemo.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.region.PartyVotes;


@Repository
public class PartyVotesDAOImpl implements PartyVotesDAO {

   @Autowired
   private SessionFactory sessionFactory;
   

   @Override
   @Transactional
   public List<PartyVotes> getPartyVotesGivenElection(int electionId) {

//      Session currentSession = (Session) new Configuration().configure()
//    		  .buildSessionFactory();
      Session currentSession = sessionFactory.getCurrentSession();
      
      Query<PartyVotes> theQuery = currentSession.createQuery(
    		  "select * from PartyVotes where eid:=electionid", PartyVotes.class);
      theQuery.setParameter("electionid", electionId);
      List<PartyVotes> partyVotes = theQuery.getResultList();
      
//      for(String tempPrecinct : precincts) {
//         System.out.println(tempPrecinct);
//      }
      
      return partyVotes;
   }

}