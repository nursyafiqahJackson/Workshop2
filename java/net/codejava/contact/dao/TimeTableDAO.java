package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.TimeTable;

public interface TimeTableDAO {
	

	   public int save(TimeTable timeTable, Integer classroomID, Integer subjectID);
	    
	    public int update(TimeTable timeTable, Integer classroomID, Integer subjectID);
	     
	    public int delete(Integer timetableID);
	     
	    public TimeTable get(Integer timetableID, Integer classroomID, Integer subjectID);
	     
	    public List<TimeTable> list();
	    
	    public List<TimeTable> searchTime(String search);
	    


}
