package net.codejava.contact.dao;


import java.util.List;

import net.codejava.contact.StudentHomework;
import net.codejava.contact.StudentSubmission;

public interface StudentSubmissionDAO {
	
	public int save(StudentSubmission submit) ;
    
    public int update(StudentSubmission submit);
     
    public int delete(int submissionID);
     
    public StudentSubmission get(int submissionID);
     
    public List<StudentSubmission> list();
 
    public List<StudentSubmission> searchSubmit(String search);
    


}
