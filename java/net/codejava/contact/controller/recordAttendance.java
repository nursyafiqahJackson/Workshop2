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



import net.codejava.contact.AttendanceRecord;
import net.codejava.contact.dao.AttendanceRecordDAO;

@Controller
public class recordAttendance {
	
	@Autowired
	private AttendanceRecordDAO recordDAO;

	@RequestMapping(value = "/listattendancestud", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		List<AttendanceRecord> listattendancestud = recordDAO.list();
	    model.addObject("listattendancestud", listattendancestud);
	    model.setViewName("listattendancestud");
	    return model;
	}
	
	
	@RequestMapping(value = "/addattendance", method = RequestMethod.GET)
	public ModelAndView editAttendance(HttpServletRequest request) {
	    int attendanceID = Integer.parseInt(request.getParameter("attendanceID"));
	    AttendanceRecord record = recordDAO.get(attendanceID);
	    ModelAndView model = new ModelAndView("addattendance");
	    model.addObject("record", record);

	    return model;
	}
	
	
	@RequestMapping(value = "/saveRecord", method = RequestMethod.POST)
	public ModelAndView saveAttendanceRecord(@ModelAttribute AttendanceRecord record) {
		recordDAO.save(record);
	    return new ModelAndView("redirect:/listAttendanceRecord");
	}
	
	@RequestMapping(value = "/listAttendanceRecord", method = RequestMethod.GET)
	public ModelAndView newRecord(ModelAndView model) {
		List<AttendanceRecord> listAttendanceRecord = recordDAO.list();
	    model.addObject("listAttendanceRecord", listAttendanceRecord);
	    model.setViewName("listAttendanceRecord");
	    return model;
	}
	
	@RequestMapping("/searchRecord")
	public ModelAndView search(@RequestParam String search) {
	    List<AttendanceRecord> result = recordDAO.searchRecord(search);
	    ModelAndView model = new ModelAndView("searchRecord");
	    model.addObject("result", result);
	 
	    return model;    
	}

}


