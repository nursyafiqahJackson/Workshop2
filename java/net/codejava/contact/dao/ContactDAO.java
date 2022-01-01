package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.Contact;

public interface ContactDAO {
	
	     
	    public int save(Contact contact);
	    
	    public int update(Contact contact);
	     
	    public int delete(Integer id);
	     
	    public Contact get(int contactId);
	     
	    public List<Contact> list();

		

		
	
}
