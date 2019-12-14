package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.region.PrecinctElection;
import com.luv2code.springdemo.region.Precincts;

public interface PrecinctElectionDAO {

   public PrecinctElection getPrecinctElections(int precinctId, ElectionTerm et);
}