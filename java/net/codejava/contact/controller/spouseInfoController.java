	package net.codejava.contact.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

	import org.springframework.stereotype.Controller;


	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	import org.springframework.web.servlet.ModelAndView;


import net.codejava.contact.spouseInfo;

	import net.codejava.contact.dao.spouseInfoDAO;

@Controller

public class spouseInfoController {

		@Autowired	

		private spouseInfoDAO spouseInfoDAO;
		

		@RequestMapping(value = "/listspouseInfo", method = RequestMethod.GET)
		public ModelAndView editUser(HttpServletRequest request) {
			Integer userDetailID = Integer.parseInt(request.getParameter("userDetailID"));
		    spouseInfo SpouseInfo = spouseInfoDAO.get(userDetailID);
		    ModelAndView model = new ModelAndView("listspouseInfo");
		    model.addObject("spouseInfo", SpouseInfo);

		    return model;
		}
		




		

		
		
		
	}
		
		

		

