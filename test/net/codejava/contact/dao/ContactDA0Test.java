package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.Contact;

class ContactDA0Test {
    private DriverManagerDataSource datasource;
    private ContactDAO dao;
    
    void setupCeforeEach() {
	datasource = new DriverManagerDataSource();
	datasource.setDriverClassName("com.mysql.jdbc.Driver");
    datasource.setUrl("jdbc:mysql://localhost:3306/contactdb");
    datasource.setUsername("root");
    datasource.setPassword("abc123");
    dao = new ContactDAOImpl(datasource);
    
    
    }
	@Test
	void testSave() {
        Contact contact = new Contact ("Steve Jobs","prince201@gmail.com","Cupertino,CA","1700123456789");
	    int result = (int) dao.save(contact);
	    assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		 Contact contact = new Contact (2, "nina","prince201@gmail.com","Cupertino,CA","123456789");
		    int result = (int) dao.update(contact);
		    assertTrue(result > 0);
	}

	@Test
	void testDelete() { 
		Integer id= 2;
		int result = (int)dao.delete(id);
		
		 assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id= 1;
		 Contact contact = dao.get(id);
		if(contact != null)
		{
			System.out.println(contact);
		}
		    assertNotNull(contact);
	}

	@Test
	void testList() {
		
	    List<Contact> listContact = dao.list();
	    
	 
	     for (Contact aContact : listContact) {
	    	 
	    	 System.out.println(aContact);
	    	 
	     } 
	     assertTrue(listContact.isEmpty());
	   
	}

}
