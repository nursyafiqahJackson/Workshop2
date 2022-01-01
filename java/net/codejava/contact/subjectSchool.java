package net.codejava.contact;

public class subjectSchool {
	
	
	private Integer subjectID;
	private String subjectName;
	
	 public subjectSchool(Integer subjectID, String subjectName) {
			this(subjectName);
			this.subjectID = subjectID;
		
		}
	    
	    public subjectSchool(String subjectName) {
			this.subjectName = subjectName;
		
		}

		public subjectSchool() {
			// TODO Auto-generated constructor stub
		}
		
	public Integer getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	



	

}
