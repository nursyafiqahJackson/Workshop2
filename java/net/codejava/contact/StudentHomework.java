package net.codejava.contact;

import java.util.Date;

public class StudentHomework {
	
	private Integer workID;
	private Integer subjectID;
	private String workName;
	private String workDescription;
	private Date workStart;
	private Date workEnd;
	
	public StudentHomework(Integer workID, Integer subjectID, String workName,String workDescription ,Date workStart,Date workEnd) {
		this( subjectID, workName, workDescription , workStart,workEnd);
		this. workID =  workID;
		
	
	}

public StudentHomework( Integer subjectID, String workName,String workDescription ,Date workStart,Date workEnd) {
	this.subjectID =subjectID;
	this.workName = workName;
	    this.workDescription = workDescription;
	    this.workStart = workStart;
	    this.workEnd = workEnd;
		
	}

public StudentHomework() {
 
   
	
}
	
	public Integer getWorkID() {
		return workID;
	}
	public void setWorkID(Integer workID) {
		this.workID = workID;
	}
	public Integer getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public String getWorkDescription() {
		return workDescription;
	}
	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}
	public Date getWorkStart() {
		return workStart;
	}
	public void setWorkStart(Date workStart) {
		this.workStart = workStart;
	}
	public Date getWorkEnd() {
		return workEnd;
	}
	public void setWorkEnd(Date workEnd) {
		this.workEnd = workEnd;
	}
	

}
