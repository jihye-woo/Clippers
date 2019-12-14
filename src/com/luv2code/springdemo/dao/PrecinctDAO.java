package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.region.Precincts;


public interface PrecinctDAO {

   public List<Precincts> getPrecincts();
   public List<String> getPrecinctsBoundaries();
}