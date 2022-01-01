package net.codejava.contact.dao;

import java.util.List;


import net.codejava.contact.Classroom;

public interface ClassroomDAO {
	
	public int save(Classroom classroom);
    
    public int update(Classroom classroom);
     
    public int delete(Integer classroomId);
     
    public Classroom get(Integer classroomId);
     
    public List<Classroom> list();
    
    public String checkClassName(String className);
    
    public String checkClassNameById(Integer classroomId);
    
    public List<Classroom> emptyClassroom();
    
    public List<Classroom> searchClassroomByName(String search);
    
    public List<Classroom> searchClassroomByTeacherName(String search);
    
    public List<Classroom> searchClassroomByForm(String search);

}
