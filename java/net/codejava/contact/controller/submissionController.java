package net.codejava.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;


import net.codejava.contact.StudentSubmission;
import net.codejava.contact.dao.StudentSubmissionDAO;

@Controller
public class submissionController {

	@Autowired
private StudentSubmissionDAO studentSubmissionDAO;
	
	
	@RequestMapping(value = "/listStudentSubmission", method = RequestMethod.GET)
	public ModelAndView newSubmit(ModelAndView model) {
		List<StudentSubmission> listStudentSubmission = studentSubmissionDAO.list();
	    model.addObject("listStudentSubmission", listStudentSubmission);
	    model.setViewName("listStudentSubmission");
	    return model;
	}
	
	@RequestMapping(value = "/createstudentsubmission", method = RequestMethod.GET)
	public ModelAndView newsubmission(ModelAndView model) {
		StudentSubmission submit = new StudentSubmission();
	    model.addObject("submit", submit);
	    model.setViewName("createstudentsubmission");
	    return model;
	}
	
	@RequestMapping("/searchSubmit")
	public ModelAndView search(@RequestParam String search) {
	    List<StudentSubmission> result = studentSubmissionDAO.searchSubmit(search);
	    ModelAndView model = new ModelAndView("searchSubmit");
	    model.addObject("result", result);
	 
	    return model;    
	}



	@RequestMapping(value = "/deleteSubmission", method = RequestMethod.GET)
	public ModelAndView deleteSubmit(HttpServletRequest request) {
	    int submissionID = Integer.parseInt(request.getParameter("submissionID"));
	    studentSubmissionDAO.delete(submissionID);
	    return new ModelAndView("redirect:/listStudentSubmission");
	}


	@RequestMapping(value = "/saveSubmit", method = RequestMethod.POST)
	 public ModelAndView upload(HttpServletRequest request,
		        HttpServletResponse response) throws Exception {
		 
		        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		        MultipartFile multipartFile = multipartRequest.getFile("file");
		        
		        StudentSubmission submit = new StudentSubmission();
		        submit.setWorkID(ServletRequestUtils.getIntParameter(request, "workID"));
		        submit.setUserID(ServletRequestUtils.getIntParameter(request, "userID"));
		        submit.setSubmissionNumber(ServletRequestUtils.getIntParameter(request, "submissionNumber"));
		        submit.setFile(multipartFile.getBytes());
		        submit.setComments(ServletRequestUtils.getStringParameter(request, "comments"));
		        submit.setGrade(ServletRequestUtils.getIntParameter(request, "grade"));
		        
		        this.studentSubmissionDAO.save(submit);
		 
		        return new ModelAndView("redirect:/listStudentSubmission");
		    }
	
	      public ModelAndView download(HttpServletRequest request,
		        HttpServletResponse response) throws Exception {
		        int submissionID = ServletRequestUtils.getRequiredIntParameter(request, "submissionID");
		 
		        StudentSubmission submit = this.studentSubmissionDAO.get(submissionID);
		 
		        response.setContentLength(submit.getFile().length);
		        response.setHeader("Content-Disposition","attachment; filename=\"" + submit.getFile() +"\"");
		 
		        FileCopyUtils.copy(submit.getFile(), response.getOutputStream());
		 
		        return null;
		 
		    }
	      
	      
	  	
			@RequestMapping(value = "/submissionStud", method = RequestMethod.GET)
			public ModelAndView newSubmitStud(ModelAndView model) {
				List<StudentSubmission> submissionStud = studentSubmissionDAO.list();
			    model.addObject("submissionStud", submissionStud);
			    model.setViewName("submissionStud");
			    return model;
			}
			
			@RequestMapping(value = "/submitWork", method = RequestMethod.GET)
			public ModelAndView newWork(ModelAndView model) {
				StudentSubmission submit = new StudentSubmission();
			    model.addObject("submit", submit);
			    model.setViewName("submitWork");
			    return model;
			}
			
			
			
			
}
