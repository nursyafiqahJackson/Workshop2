package net.codejava.contact.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import net.codejava.contact.ReportCard;

import net.codejava.contact.dao.ReportCardDAO;




@Controller
public class reportCardController {


	@Autowired
	
	private ReportCardDAO reportDAO;

	
	
	@RequestMapping(value="/listreportcard")
	public ModelAndView newContact(ModelAndView model) {
		List<ReportCard> listreportcard = reportDAO.list();
	    model.addObject("listreportcard", listreportcard);
	    model.setViewName("listreportcard");
	    return model;
	}
	
	
	

	
	@RequestMapping(value = "/createreportcard", method = RequestMethod.GET)
	public ModelAndView newHomework(ModelAndView model) {
		ReportCard report = new ReportCard();
	    model.addObject("report", report);
	    model.setViewName("createreportcard");
	    return model;
	}
	
	@RequestMapping(value = "/saveReport", method = RequestMethod.POST)
	public ModelAndView saveReport(@ModelAttribute ReportCard report) {
		reportDAO.save(report);
	    return new ModelAndView("redirect:/listreportcard");
	}
	
	@RequestMapping(value = "/deleteReport", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    int userID = Integer.parseInt(request.getParameter("userID"));
	    reportDAO.delete(userID);
	    return new ModelAndView("redirect:/listreportcard");
	}
	
	
	
	
	@RequestMapping(value = "/editReport", method = RequestMethod.GET)
	public ModelAndView editReport(HttpServletRequest request) {
	    int userID = Integer.parseInt(request.getParameter("userID"));
	    ReportCard report = reportDAO.get(userID);
	    ModelAndView model = new ModelAndView("createreportcard");
	    model.addObject("report", report);
	 
	    return model;
	}
	
	@RequestMapping(value="/reportstud")
	public ModelAndView newResultStud(ModelAndView model) {
		List<ReportCard> listreportcard = reportDAO.list();
	    model.addObject("listreportcard", listreportcard);
	    model.setViewName("reportstud");
	    return model;
	}
	
	
	@RequestMapping("/searchReport")
	public ModelAndView search(@RequestParam String search) {
	    List<ReportCard> report = reportDAO.searchReport(search);
	    ModelAndView model = new ModelAndView("searchReport");
	    model.addObject("result", report);
	 
	    return model;    
	}
	
}
