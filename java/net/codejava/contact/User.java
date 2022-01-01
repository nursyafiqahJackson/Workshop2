package net.codejava.contact;

public class User {
	
	private Integer userID;
	private String username;
	private String password;
	private boolean enabled;
	
	public User(Integer userID, String username, boolean enabled) {
		super();
		this.userID = userID;
		this.username = username;
		this.enabled = enabled;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User() {
		
	}
	
	public Integer getUserId() {
		return userID;
	}
	public void setUserId(Integer userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	


	

}
