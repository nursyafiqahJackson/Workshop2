package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.UserDetails;

public interface UserDetailsDAO {
	public int save(UserDetails detail);
    
    public int update(UserDetails detail);
     
    public int delete(int userDetailID);
     
    public UserDetails getStudentById(Integer userId);
    
    public List<UserDetails> list();
    
    public List<UserDetails> teacherList();
    
    public List<UserDetails> unassignedStudentList();
    
    public List<UserDetails> StudentList();
    
    public List<UserDetails> searchStudentByName(String search);
    
    public List<UserDetails> searchStudentByIC(String search);
    
    public List<UserDetails> participantList(Integer classroomId);
    
    public UserDetails get(Integer userDetailID);
    
    public List<UserDetails> TeacherDisplay();
}
