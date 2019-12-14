package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.region.PartyVotes;

public interface PartyVotesDAO {

   public List<PartyVotes> getPartyVotesGivenElection(int electionId);
}