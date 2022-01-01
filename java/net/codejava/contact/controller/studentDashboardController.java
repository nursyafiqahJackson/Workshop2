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
public class studentDashboardController {
	
	@Autowired	
	private UserDetailsDAO userDetailsDAO;
		
		

		@RequestMapping(value = "/homeStud", method = RequestMethod.GET)
		public ModelAndView newStudHome(ModelAndView model) {
			List<UserDetails> StudentList = userDetailsDAO.StudentList();
		    model.addObject("listuserdetails", StudentList);
		    model.setViewName("homeStud");
		    return model;
		}


}
