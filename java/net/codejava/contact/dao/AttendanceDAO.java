package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.Attendance;


public interface AttendanceDAO {
	
	   public int save(Attendance attendance);
	    
	    public int update(Attendance attendance);
	     
	    public int delete(Integer attendanceID);
	     
	    public Attendance get(Integer attendanceID);
	     
	    public List<Attendance> list();
	    
	    public int getUserIdByAttendanceName(String attendance_name);
	    
	    public List<Attendance> search(String search);

}
