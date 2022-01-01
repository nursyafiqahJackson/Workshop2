package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.result;


public interface resultDAO {
	
public int save(result result);
    
    public int update(result result);
     
    public int delete(int resultID);
     
    public result get(int resultID);
     
    public List<result> list();
    
    public List<result> searchGrade(String search);

}
