package net.codejava.contact;


public class spouseInfo {
	
	private Integer userDetailID;
	private String name;
	private Integer icNumber;
	private Integer phoneNumber;
    private String address;
    private String nationality;
	private String ethnicity;
	private String email;
	private String occupation;
	private UserDetails userInfo;
	private User user;

	public spouseInfo(Integer userDetailID, String name, Integer icNumber, Integer phoneNumber,String address,String nationality,String ethnicity,String email, String occupation ) {
		this(name, icNumber,  phoneNumber,address,nationality, ethnicity,email,occupation);
		this.userDetailID = userDetailID;
	
	}



public spouseInfo(String name, Integer icNumber, Integer phoneNumber,String address,String nationality,String ethnicity,String email, String occupation) {
	    this.name = name;
	    this.icNumber = icNumber;
	    this.phoneNumber = phoneNumber;
	    this.address = address;
	    this.nationality = nationality;
	    this.ethnicity = ethnicity;
	    this.email = email;
	    this.occupation = occupation;
		
	}

public spouseInfo() {
	// TODO Auto-generated constructor stub
	
}
	

	public UserDetails getUserInfo() {
	return userInfo;
}



public void setUserInfo(UserDetails userInfo) {
	this.userInfo = userInfo;
}



public User getUser() {
	return user;
}



public void setUser(User user) {
	this.user = user;
}



	public Integer getUserDetailsID() {
		return userDetailID;
	}
	public void setUserDetailsID(Integer userDetailID) {
		this.userDetailID = userDetailID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIcNumber() {
		return icNumber;
	}
	public void setIcNumber(Integer icNumber) {
		this.icNumber = icNumber;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


}
