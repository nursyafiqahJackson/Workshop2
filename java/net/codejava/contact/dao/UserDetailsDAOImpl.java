package net.codejava.contact.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.UserDetails;



public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	
	private JdbcTemplate jdbcTemplate;

	public UserDetailsDAOImpl (DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public int save(UserDetails detail) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO user_details (user_details_id,user_id, email, name,ic_number,phone_number, address, nationality,ethnicity, occupation,marital_status,picture) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, detail.getUserDetailId(),detail.getUserId(),detail.getEmail(),detail.getName(),detail.getIcNumber(),detail.getPhoneNumber(),detail.getAddress(),detail.getNationality(),detail.getEthnicity(),detail.getOccupation(),detail.getMaritalStatus(),detail.getPicture());
	
	}

	@Override
	public int update(UserDetails detail) {
		String sql = "UPDATE user_details  SET user_details_id=?, user_id=?, email=?, name=?, ic_number=?, phone_number=?, address=?, nationality=?,ethnicity=?,occupation=?, marital_status=?,picture=? WHERE user_details_id=?";
		return jdbcTemplate.update(sql, detail.getUserDetailId(),detail.getUserId(),detail.getEmail(),detail.getName(),detail.getIcNumber(),detail.getPhoneNumber(),detail.getAddress(),detail.getNationality(),detail.getEthnicity(),detail.getOccupation(),detail.getMaritalStatus(),detail.getPicture());

	}

	@Override
	public int delete(int userDetailID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM user_details WHERE (user_details_id=?";
		return jdbcTemplate.update(sql,  userDetailID);
	}

	public UserDetails getStudentById(Integer userId) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM user_details WHERE user_id=" + "'" + userId + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<UserDetails>() {

			@Override
			public UserDetails extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					UserDetails user = new UserDetails();
					user.setUserId(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setIcNumber(rs.getString("ic_number"));
					user.setEmail(rs.getString("email"));
					user.setPhoneNumber(rs.getString("phone_number"));
					user.setAddress(rs.getString("address"));
					user.setNationality(rs.getString("nationality"));
					user.setEthnicity(rs.getString("ethnicity"));
					user.setPicture(rs.getBlob("picture"));
					return user;
				}
				return null;

			}

		});
		
	}
	
	public UserDetails get(Integer userDetailID) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM user_details WHERE user_details_id=" + "'" + userDetailID + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<UserDetails>() {

			@Override
			public UserDetails extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					UserDetails user = new UserDetails();
					user.setUserId(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setIcNumber(rs.getString("ic_number"));
					user.setEmail(rs.getString("email"));
					user.setPhoneNumber(rs.getString("phone_number"));
					user.setAddress(rs.getString("address"));
					user.setNationality(rs.getString("nationality"));
					user.setEthnicity(rs.getString("ethnicity"));
					user.setPicture(rs.getBlob("picture"));
					return user;
				}
				return null;

			}

		});
		
	}
	
	public List<UserDetails> list() {
		// Select certain field from each table to be displayed in admin dashboard
		String sql = "SELECT * FROM user_details";

		List<UserDetails> list = jdbcTemplate.query(sql, new RowMapper<UserDetails>() {

			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				UserDetails user = new UserDetails();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setIcNumber(rs.getString("ic_number"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setNationality(rs.getString("nationality"));
				user.setEthnicity(rs.getString("ethnicity"));
				user.setPicture(rs.getBlob("picture"));
				return user;
			}
		});
		return list;
	}
	
	public List<UserDetails> teacherList() {
		// Select certain field from each table to be displayed in admin dashboard
		String sql = "SELECT user_details.user_id,user_details.name,user_details.ic_number FROM user_details JOIN user_role ON "
				+ "user_details.user_id=user_role.user_id JOIN users ON user_details.user_id=users.user_id "
				+ "WHERE user_role.role='TEACHER' AND users.enabled=1";
		List<UserDetails> list = jdbcTemplate.query(sql, new RowMapper<UserDetails>() {

			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				UserDetails user = new UserDetails();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setIcNumber(rs.getString("ic_number"));
				return user;
			}
		});
		return list;
	}
	
	public List<UserDetails> unassignedStudentList() {
		// Select certain field from each table to be displayed in admin dashboard
		String sql = "SELECT user_details.user_id,user_details.name,user_details.ic_number FROM user_details JOIN user_role ON "
				+ "user_details.user_id=user_role.user_id JOIN users ON user_details.user_id=users.user_id  "
				+ "WHERE user_details.user_id NOT IN (SELECT class_participant.user_id FROM class_participant) AND "
				+ "user_role.role='STUDENT' AND users.enabled=1";

		List<UserDetails> list = jdbcTemplate.query(sql, new RowMapper<UserDetails>() {

			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				UserDetails user = new UserDetails();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setIcNumber(rs.getString("ic_number"));
				return user;
			}
		});
		return list;
	}

	
	public List<UserDetails> StudentList() {
		// Select certain field from each table to be displayed in admin dashboard
		String sql = "SELECT user_details.* FROM user_details JOIN user_role ON user_details.user_id=user_role.user_id JOIN "
				+ "users ON user_details.user_id=users.user_id WHERE user_role.role='STUDENT' AND users.enabled=1";

		List<UserDetails> list = jdbcTemplate.query(sql, new RowMapper<UserDetails>() {

			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				UserDetails user = new UserDetails();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setIcNumber(rs.getString("ic_number"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setNationality(rs.getString("nationality"));
				user.setEthnicity(rs.getString("ethnicity"));
				user.setPicture(rs.getBlob("picture"));
				return user;
			}
		});
		return list;
	}
	
	public List<UserDetails> TeacherDisplay() {
		// Select certain field from each table to be displayed in admin dashboard
		String sql = "SELECT user_details.* FROM user_details JOIN user_role ON user_details.user_id=user_role.user_id JOIN "
				+ "users ON user_details.user_id=users.user_id WHERE user_role.role='TEACHER' AND users.enabled=1";

		List<UserDetails> list = jdbcTemplate.query(sql, new RowMapper<UserDetails>() {

			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				UserDetails user = new UserDetails();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setIcNumber(rs.getString("ic_number"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setNationality(rs.getString("nationality"));
				user.setEthnicity(rs.getString("ethnicity"));
				user.setPicture(rs.getBlob("picture"));
				return user;
			}
		});
		return list;
	}
	
	public Blob getPhotoById(int userId) {

		String query = "SELECT picture FROM user_details where user_id=?";

		Blob photo = jdbcTemplate.queryForObject(query, new Object[] { userId }, Blob.class);

		return photo;
	}

	public List<UserDetails> searchStudentByName(String search) {
		
		String sql = "SELECT user_details.* FROM user_details JOIN user_role ON user_details.user_id=user_role.user_id JOIN "
				+ "users ON user_details.user_id=users.user_id WHERE user_role.role='STUDENT' AND "
				+ "users.enabled=1 AND user_details.name LIKE " + "'%" + search + "%'";

		List<UserDetails> list = jdbcTemplate.query(sql, new RowMapper<UserDetails>() {

			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				UserDetails user = new UserDetails();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setIcNumber(rs.getString("ic_number"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setNationality(rs.getString("nationality"));
				user.setEthnicity(rs.getString("ethnicity"));
				user.setPicture(rs.getBlob("picture"));
				return user;
			}
		});
		return list;
	}

	public List<UserDetails> searchStudentByIC(String search) {
	
		String sql = "SELECT user_details.* FROM user_details JOIN user_role ON user_details.user_id=user_role.user_id JOIN "
				+ "users ON user_details.user_id=users.user_id WHERE user_role.role='STUDENT' AND "
				+ "users.enabled=1 AND user_details.ic_number LIKE " + "'%" + search + "%'";

		List<UserDetails> list = jdbcTemplate.query(sql, new RowMapper<UserDetails>() {

			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				UserDetails user = new UserDetails();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setIcNumber(rs.getString("ic_number"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setNationality(rs.getString("nationality"));
				user.setEthnicity(rs.getString("ethnicity"));
				user.setPicture(rs.getBlob("picture"));
				return user;
			}
		});
		return list;
	}

	public List<UserDetails> participantList(Integer classroomId) {
		
		String sql = "SELECT user_details.user_id,user_details.name,user_details.ic_number,user_details.email FROM user_details "
				+ "JOIN class_participant ON user_details.user_id=class_participant.user_id " + "WHERE classroom_id=classroomId";

		List<UserDetails> list = jdbcTemplate.query(sql, new RowMapper<UserDetails>() {

			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				UserDetails user = new UserDetails();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setIcNumber(rs.getString("ic_number"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		});
		return list;
	}
	
	


}
