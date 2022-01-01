package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.User;

public interface UserDAO {
	public int save(User user);
    
    public int update(User user);
     
    public int delete(int userID);
     
    public User get(int userID);
     
    public List<User> list();
}
