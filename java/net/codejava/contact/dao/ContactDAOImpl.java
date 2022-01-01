package net.codejava.contact.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.Contact;

public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
	
	@Override
	public int save(Contact contact) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO contact (name, email, address, telephone)"
                + " VALUES (?, ?, ?, ?)";
    return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
            contact.getAddress(), contact.getTelephone());

	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		 String sql = "UPDATE contact SET name=?, email=?, address=?, "
                 + "telephone=? WHERE contact_id=?";
     return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
             contact.getAddress(), contact.getTelephone(), contact.getId());

	}
	
	public Contact get (Integer id) {
		String sql = "SELECT * FROM Contact WHERE contact_id=" + id;
      
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
			 
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if(rs.next()) {
					String name = rs.getNString("name");
					String email = rs.getNString("email");
					String address = rs.getNString("address");
					String phone = rs.getNString("phone");
					
					return new Contact( name,  email,  address, phone);
				}
				return null;
			   }
			};
		return jdbcTemplate.query(sql, extractor);
		
	}


	@Override
	public int delete (Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM contact WHERE id=?";
	    return jdbcTemplate.update(sql, id);

	}

	@Override
	public Contact get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM contact";
	    RowMapper<Contact> rowMapper = new RowMapper <Contact>() {
	 
	        @Override
	        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
	          
	 
	            Integer id = rs.getInt("contact_id");
	            String name=rs.getString("name");
	            String email=rs.getString("email");
	            String address=rs.getString("address");
	            String telephone=rs.getString("telephone");
	 
	            return new Contact( name,  email,  address, telephone);
	        }
	 
	    };
	 
	    return jdbcTemplate.query(sql, rowMapper);
	}

}
