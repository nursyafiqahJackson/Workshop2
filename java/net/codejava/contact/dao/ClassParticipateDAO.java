package net.codejava.contact.dao;

import java.util.List;


import net.codejava.contact.ClassParticipate;

public interface ClassParticipateDAO {
	
	 public int save(ClassParticipate participate);
	    
	    public int update(ClassParticipate participate);
	     
	    public int delete(int userId);
	     
	    public ClassParticipate get(int userId);
	     
	    public List<ClassParticipate> list();
	    
	    public int getParticipantClassId(Integer userId);

}
