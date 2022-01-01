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


import net.codejava.contact.Attendance;
import net.codejava.contact.dao.AttendanceDAO;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceDAO attendanceDAO;

    @RequestMapping(value = "/listAttendance", method = RequestMethod.GET)
public ModelAndView newAttendance(ModelAndView model) {
	List<Attendance> listAttendance = attendanceDAO.list();
    model.addObject("listAttendance", listAttendance);
    model.setViewName("listAttendance");
    return model;
}

@RequestMapping(value = "/newAttendance", method = RequestMethod.GET)
public ModelAndView newContact(ModelAndView model) {
    Attendance newAttendance = new Attendance();
    model.addObject("attendance", newAttendance);
    model.setViewName("createattendance");
    return model;
}

@RequestMapping(value = "/saveAttendance", method = RequestMethod.POST)
public ModelAndView saveAttendance(@ModelAttribute Attendance attendance) {
	attendanceDAO.save(attendance);
    return new ModelAndView("redirect:/listAttendance");
}

@RequestMapping(value = "/deleteAttendance", method = RequestMethod.GET)
public ModelAndView deleteAttendance(HttpServletRequest request) {
    int attendanceID = Integer.parseInt(request.getParameter("attendanceID"));
    attendanceDAO.delete(attendanceID);
    return new ModelAndView("redirect:/listAttendance");
}

@RequestMapping(value = "/editAttendance", method = RequestMethod.GET)
public ModelAndView editAttendance(HttpServletRequest request) {
    int attendanceID = Integer.parseInt(request.getParameter("attendanceID"));
    Attendance attendance = attendanceDAO.get(attendanceID);
    ModelAndView model = new ModelAndView("createattendance");
    model.addObject("attendance", attendance);

    return model;
}

@RequestMapping("/searchAttendance")
public ModelAndView search(@RequestParam String search) {
    List<Attendance> result = attendanceDAO.search(search);
    ModelAndView model = new ModelAndView("searchAttendance");
    model.addObject("result", result);
 
    return model;    
}



}




