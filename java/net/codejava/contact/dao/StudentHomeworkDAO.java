package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.StudentHomework;


public interface StudentHomeworkDAO {
	
	public int save(StudentHomework work);
    
    public int update(StudentHomework work);
     
    public int delete(Integer workID);
     
    public StudentHomework get(Integer workID);
     
    public List<StudentHomework> list();
    
    public List<StudentHomework> searchWork(String search);
   


}
