package net.codejava.contact;

import java.sql.Time;

public class TimeTable {
	
	
	private Integer timetableID;
	private Integer classroomID;
	private  Integer subjectID;
	private Time time;
	
	public TimeTable(Integer timetableID, Integer classroomID, Integer subjectID, Time time ) {
		this(time);
		this.timetableID = timetableID;
		this.classroomID = classroomID;
		this.subjectID = subjectID;
	
	}

public TimeTable(Time time) {
		this.time = time;
		
		
	}
 

public TimeTable() {
	// TODO Auto-generated constructor stub
	
	
    
}

	
	public Integer getTimetableID() {
		return timetableID;
	}
	public void setTimetableID(Integer timetableID) {
		this.timetableID = timetableID;
	}
	public Integer getClassroomID() {
		return classroomID;
	}
	public void setClassroomID(Integer classroomID) {
		this.classroomID = classroomID;
	}
	public Integer getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}

}
