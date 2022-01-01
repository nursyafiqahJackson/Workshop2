package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.ReportCard;

public interface ReportCardDAO {
	
	   public int save(ReportCard report);
	    
	    public int update(ReportCard report);
	     
	    public int delete(int userID);
	     
	    public ReportCard get(int userID);
	     
	    public List<ReportCard> list();
	    public List<ReportCard> searchReport(String search);
}
