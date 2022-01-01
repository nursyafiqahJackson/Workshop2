package net.codejava.contact;

import java.util.Date;

public class Attendance {
	
	private Integer attendanceID;
	private String attendanceName;
	private Date attendanceTime;
	private Integer form;
	private String subjectName;
	
	public Attendance(Integer attendanceID, String attendanceName, Date attendanceTime, Integer form, String subjectName ) {
			this(attendanceName, attendanceTime, form, subjectName);
			this.attendanceID = attendanceID;
		
		}
	


	public Attendance(String attendanceName, Date attendanceTime, Integer form, String subjectName) {
			this.attendanceName = attendanceName;
			this.attendanceTime = attendanceTime;
			this.form = form;
			this.subjectName = subjectName;
			
		}
	 
	public Attendance() {
		// TODO Auto-generated constructor stub
		attendanceTime=new Date();
	}

	public Integer getAttendanceID() {
		return attendanceID;
	}
	public void setAttendanceID(Integer attendanceID) {
		this.attendanceID = attendanceID;
	}
	public String getAttendanceName() {
		return attendanceName;
	}
	public void setAttendanceName(String attendanceName) {
		this.attendanceName = attendanceName;
	}
	public Date getAttendanceTime() {
		return attendanceTime;
	}
	public void setAttendanceTime(Date attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	public Integer getForm() {
		return form;
	}

	public void setForm(Integer form) {
		this.form = form;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
