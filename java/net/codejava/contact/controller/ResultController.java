

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


import net.codejava.contact.result;

import net.codejava.contact.dao.resultDAO;


@Controller
public class ResultController {
	@Autowired
	private resultDAO ResultDAO;

	
	
	@RequestMapping(value = "/listresult", method = RequestMethod.GET)
   public ModelAndView newResult(ModelAndView model) {
	List<result> listresult = ResultDAO.list();
    model.addObject("listresult", listresult);
    model.setViewName("listresult");
    return model;
}
	


@RequestMapping(value = "/createresult", method = RequestMethod.GET)
public ModelAndView newHomework(ModelAndView model) {
	result result = new result();
    model.addObject("result", result);
    model.setViewName("createresult");
    return model;
}

@RequestMapping(value = "/saveResult", method = RequestMethod.POST)
public ModelAndView saveResult(@ModelAttribute result result) {
	ResultDAO.save(result);
    return new ModelAndView("redirect:/listresult");
}

@RequestMapping(value = "/deleteResult", method = RequestMethod.GET)
public ModelAndView deleteResult(HttpServletRequest request) {
    int resultID = Integer.parseInt(request.getParameter("resultID"));
    ResultDAO.delete(resultID);
    return new ModelAndView("redirect:/listresult");
}




@RequestMapping(value = "/editResult", method = RequestMethod.GET)
public ModelAndView editResult(HttpServletRequest request) {
    int resultID = Integer.parseInt(request.getParameter("resultID"));
    result result = ResultDAO.get(resultID);
    ModelAndView model = new ModelAndView("createresult");
    model.addObject("result", result);

    return model;
}

@RequestMapping(value = "/resultstud", method = RequestMethod.GET)
public ModelAndView newResultstud(ModelAndView model) {
	List<result> listresult = ResultDAO.list();
    model.addObject("listresult", listresult);
    model.setViewName("resultstud");
    return model;
}

@RequestMapping("/searchResult")
public ModelAndView search(@RequestParam String search) {
    List<result> result = ResultDAO.searchGrade(search);
    ModelAndView model = new ModelAndView("searchGrade");
    model.addObject("result", result);
 
    return model;    
}

}
