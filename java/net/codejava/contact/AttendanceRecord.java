package net.codejava.contact;


import java.util.Date;


public class AttendanceRecord {

	private Integer attendanceID;
	private Integer userID;
	private String status;
	private Date date;
	private User user;
	private UserDetails userInfo;
	
	public AttendanceRecord(Integer attendanceID, Integer userID, String status, Date date){
		this(status,date);
		this.attendanceID = attendanceID;
		this.userID = userID;
	
	}



public AttendanceRecord(String status, Date date) {
	    this.status = status;
	    this.date = date;
	   
	}


	
	
	public UserDetails getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserDetails userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AttendanceRecord (){
		
		
		date = new Date();
	}
	
	public Integer getAttendanceID() {
		return attendanceID;
	}
	public void setAttendanceID(Integer attendanceID) {
		this.attendanceID = attendanceID;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
