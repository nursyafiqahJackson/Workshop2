package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.subjectSchool;

public interface subjectSchoolDAO {
	

	   public int save(subjectSchool SubjectSchool);
	    
	    public int update(subjectSchool SubjectSchool);
	     
	    public int delete(Integer subjectID);
	     
	    public subjectSchool get(Integer subjectID);
	     
	    public List<subjectSchool> list();

}
