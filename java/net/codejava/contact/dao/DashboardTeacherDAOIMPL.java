package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DashboardTeacherDAOIMPL implements DashboardTeacherDAO {
	
	private JdbcTemplate jdbcTemplate;

	public DashboardTeacherDAOIMPL(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public int countUnassignedStudent() {

		String sql = "SELECT COUNT(user_details.user_id) FROM user_details JOIN user_role ON user_details.user_id=user_role.user_id JOIN "
				+ "users ON user_details.user_id=users.user_id WHERE user_role.role='STUDENT' AND "
				+ "user_details.user_id NOT IN (SELECT user_id FROM class_participant) AND users.enabled=1";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int totalStudent() {

		String sql = "SELECT COUNT(role) FROM user_role JOIN users ON user_role.user_id=users.user_id "
				+ "WHERE user_role.role='STUDENT' AND users.enabled=1";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int totalClassroom() {

		String sql = "SELECT COUNT(classroom_id) FROM classroom";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int emptyClassroomNum() {

		String sql = "SELECT COUNT(classroom.classroom_id) FROM classroom WHERE "
				+ "classroom.classroom_id NOT IN (SELECT classroom_id FROM class_participant)";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public int getStudentCount(Integer classroomId) {

		String sql = "SELECT COUNT(classroom_id) FROM class_participant WHERE classroom_id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { classroomId }, Integer.class);

	}


	public int getUserIdByUsername(String username) {

		String sql = "SELECT user_id FROM users WHERE username=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { username }, Integer.class);
	}

	

	public List<String> emails() {

		String sql = "SELECT email FROM user_details JOIN user_role ON user_details.user_id=user_role.user_id "
				+ "WHERE user_role.role='STUDENT' OR user_role.role='PARENT'";
		List<String> list = jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {

				String email = rs.getString("email");
				return email;
			}
		});
		return list;

	}
	
	
	
	public String getEmailById(Integer userId) {
		
		String sql="SELECT email FROM user_details WHERE user_id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {userId},String.class);
		
	}

}
