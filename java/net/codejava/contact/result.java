package net.codejava.contact;

public class result {

	private Integer resultID;
	private Integer userID;
	private Integer subjectID;
	private String subjectName;
	private Integer grade;
	private subjectSchool subject;
	
	
	public subjectSchool getSubject() {
		return subject;
	}
	public void setSubject(subjectSchool subject) {
		this.subject = subject;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Integer getResultID() {
		return resultID;
	}
	public void setResultID(Integer resultID) {
		this.resultID = resultID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
}
