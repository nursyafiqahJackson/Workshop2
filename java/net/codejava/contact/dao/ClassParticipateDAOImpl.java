package net.codejava.contact.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import net.codejava.contact.ClassParticipate;

public class ClassParticipateDAOImpl implements ClassParticipateDAO {

	
	private JdbcTemplate jdbcTemplate;

	public ClassParticipateDAOImpl (DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	@Override
	public int save(ClassParticipate participate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ClassParticipate participate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int userId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM class_participant WHERE user_id=?";
		return jdbcTemplate.update(sql, userId);
	}

	@Override
	public ClassParticipate get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassParticipate> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getParticipantClassId(Integer userId) {

		String sql = "SELECT class_participant.classroom_id FROM class_participant WHERE user_id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { userId }, Integer.class);

	}


}
