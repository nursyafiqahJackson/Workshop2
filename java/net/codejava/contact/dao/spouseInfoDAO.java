package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.spouseInfo;

public interface spouseInfoDAO {
	
	public int save(spouseInfo spouse);
    
    public int update(spouseInfo spouse);
     
    public int delete(int userDetailID);
     
    public spouseInfo get(int userDetailID);
     
    public List<spouseInfo> list(Integer userDetailID);


}
