package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.region.States;


public interface StateDAO {
//   public List<Precinct> getPrecincts();
   public List<String> getStates();
   public States getSingleState(String stateName);
}