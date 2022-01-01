package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.AttendanceRecord;

public interface AttendanceRecordDAO {

	    public int save(AttendanceRecord record );
	    
	    public int update(AttendanceRecord record);
	     
	    public int delete(int attendanceID);
	     
	    public AttendanceRecord get(int attendanceID );
	     
	    public List<AttendanceRecord> list();
	    
	    public int getUserIdByAttendanceName(String attendance_name);
	    
	    public int getAttendanceIdByid(Integer attendance_id);
	    
	    public List<AttendanceRecord> searchRecord(String search);
}
