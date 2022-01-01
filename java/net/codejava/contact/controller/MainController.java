package net.codejava.contact.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import net.codejava.contact.UserDetails;

import net.codejava.contact.dao.UserDetailsDAO;





@Controller
public class MainController {

	
	@Autowired	
   private UserDetailsDAO userDetailsDAO;

	
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView newHome(ModelAndView model) {
		List<UserDetails> listuser = userDetailsDAO.TeacherDisplay();
	    model.addObject("listuser",listuser);
	    model.setViewName("home");
	    return model;
	}
	



	




	
	
	
}
	
	

	
	 
	     
	   
	
	
	
	

