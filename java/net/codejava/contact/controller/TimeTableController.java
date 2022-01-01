package net.codejava.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import net.codejava.contact.TimeTable;
import net.codejava.contact.dao.TimeTableDAO;

@Controller
public class TimeTableController {

@Autowired	
private TimeTableDAO timeTableDAO;
	
	
	@RequestMapping(value = "/listtimetable", method = RequestMethod.GET)
	public ModelAndView newtimeTable(ModelAndView model) {
		List<TimeTable> listtimetable = timeTableDAO.list();
	    model.addObject("listtimetable", listtimetable);
	    model.setViewName("listtimetable");
	    return model;
	}
	

	@RequestMapping(value = "/timetablestud", method = RequestMethod.GET)
	public ModelAndView newTimeTableStud(ModelAndView model) {
		List<TimeTable> listtimetable = timeTableDAO.list();
	    model.addObject("listtimetable", listtimetable);
	    model.setViewName("timetablestud");
	    return model;
	}
	
	@RequestMapping("/searchTime")
	public ModelAndView search(@RequestParam String search) {
	    List<TimeTable> result = timeTableDAO.searchTime(search);
	    ModelAndView model = new ModelAndView("searchTime");
	    model.addObject("result", result);
	 
	    return model;    
	}
}
