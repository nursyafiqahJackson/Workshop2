package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.userRole;

public interface userRoleDAO {
	public int save(userRole role);
    
    public int update(userRole role);
     
    public int delete(int roleID);
     
    public userRole get(int roleID);
     
    public List<userRole> list();

}
