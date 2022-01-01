package net.codejava.contact;



public class StudentSubmission {

	private Integer submissionID;
	private Integer workID;
	private Integer userID;
	private Integer submissionNumber;
	private byte[] file;
	private String comments;
	private Integer grade;
	
	public StudentSubmission() {
		

	}
	
	public Integer getSubmissionID() {
		return submissionID;
	}
	public void setSubmissionID(Integer submissionID) {
		this.submissionID = submissionID;
	}
	public Integer getWorkID() {
		return workID;
	}
	public void setWorkID(Integer workID) {
		this.workID = workID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getSubmissionNumber() {
		return submissionNumber;
	}
	public void setSubmissionNumber(Integer submissionNumber) {
		this.submissionNumber = submissionNumber;
	}

	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	
	
}
