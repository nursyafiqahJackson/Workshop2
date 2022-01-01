package net.codejava.contact;

public class ReportCard {
	
	private Integer userID;
	private Integer resultID;
	private Integer attendanceReport;
	private String attitudeReport;
	
	private result Result;
	
	public result getResult() {
		return Result;
	}
	public void setResult(result result) {
		Result = result;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getResultID() {
		return resultID;
	}
	public void setResultID(Integer resultID) {
		this.resultID = resultID;
	}
	public Integer getAttendanceReport() {
		return attendanceReport;
	}
	public void setAttendanceReport(Integer attendanceReport) {
		this.attendanceReport = attendanceReport;
	}
	public String getAttitudeReport() {
		return attitudeReport;
	}
	public void setAttitudeReport(String attitudeReport) {
		this.attitudeReport = attitudeReport;
	}

}
