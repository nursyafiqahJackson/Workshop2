package net.codejava.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import net.codejava.contact.StudentHomework;
import net.codejava.contact.dao.StudentHomeworkDAO;

@Controller
public class HomeworkController {

	
	@Autowired
	private StudentHomeworkDAO studentHomeworkDAO;
	
	
	@RequestMapping(value = "/liststudenthomework", method = RequestMethod.GET)
public ModelAndView newContact(ModelAndView model) {
	List<StudentHomework> liststudenthomework = studentHomeworkDAO.list();
    model.addObject("liststudenthomework", liststudenthomework);
    model.setViewName("liststudenthomework");
    return model;
}


@RequestMapping(value = "/createstudenthomework", method = RequestMethod.GET)
public ModelAndView newHomework(ModelAndView model) {
	StudentHomework newStudentHomework = new StudentHomework();
    model.addObject("work", newStudentHomework);
    model.setViewName("createstudenthomework");
    return model;
}

@RequestMapping(value = "/saveHomework", method = RequestMethod.POST)
public ModelAndView saveHomework(@ModelAttribute StudentHomework work) {
	studentHomeworkDAO.save(work);
    return new ModelAndView("redirect:/liststudenthomework");
}


@RequestMapping(value = "/homeworkstud", method = RequestMethod.GET)
public ModelAndView newSubmitWork(ModelAndView model) {
	List<StudentHomework> homeworkstud = studentHomeworkDAO.list();
    model.addObject("homeworkstud", homeworkstud);
    model.setViewName("homeworkstud");
    return model;
}

@RequestMapping("/searchWork")
public ModelAndView search(@RequestParam String search) {
    List<StudentHomework> result = studentHomeworkDAO.searchWork(search);
    ModelAndView model = new ModelAndView("searchWork");
    model.addObject("result", result);
 
    return model;    
}


}
