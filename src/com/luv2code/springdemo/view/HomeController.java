package com.luv2code.springdemo.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.PrecinctDAO;
import com.luv2code.springdemo.region.Precincts;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		
		return "main-menu";
	}
}
