package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;



import net.codejava.contact.result;

public class resultDAOImpl implements resultDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public resultDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    } 

	@Override
	public int save(result result) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO result (user_id,subject_id,grade) VALUES (?,?,?)";
		return jdbcTemplate.update(sql,result.getUserID(),result.getSubjectID(),result.getGrade());
		
	}

	@Override
	public int update(result result) {
		// TODO Auto-generated method stub
		String sql = "UPDATE result SET user_id=?, subject_id=?, grade=? WHERE result_id=?";
		return jdbcTemplate.update(sql, result.getUserID(),result.getSubjectID(),result.getGrade(),
				result.getResultID());
	}

	@Override
	public int delete(int resultID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM result WHERE result_id=?";
		return jdbcTemplate.update(sql, resultID);
	}

	@Override
	public result get(int resultID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM result WHERE result_id=" + "'" + resultID + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<result>() {

			@Override
			public result extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					result result = new result();
					result.setResultID(rs.getInt("result_id"));
					result.setUserID(rs.getInt("user_id"));
					result.setSubjectID(rs.getInt("subject_id"));
					result.setGrade(rs.getInt("grade"));
					
					return result;
					
					
				}
				return null;

			}

		});
	}

	@Override
	public List<result> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT result.*, subject.* FROM result JOIN subject ON result.subject_id=subject.subject_id";
		List<result> list = jdbcTemplate.query(sql, new RowMapper<result>() {

			@Override
			public result mapRow(ResultSet rs, int rowNum) throws SQLException {

				result result = new result();
				result.setResultID(rs.getInt("result_id"));
				result.setUserID(rs.getInt("user_id"));
				result.setSubjectID(rs.getInt("subject_id"));
				result.setGrade(rs.getInt("grade"));
				
				return result;
			}
		});
		return list;
	}
	
	
	public List<result> searchGrade(String search) {
		// Select certain field from each table to be displayed in admin dashboard
		String sql = "SELECT * FROM result WHERE result.grade LIKE " + "'%" + search + "%'";
		List<result> list = jdbcTemplate.query(sql, new RowMapper<result>() {

			@Override
			public result mapRow(ResultSet rs, int rowNum) throws SQLException {

				result result = new result();
				result.setResultID(rs.getInt("result_id"));
				result.setUserID(rs.getInt("user_id"));
				result.setSubjectID(rs.getInt("subject_id"));
				result.setGrade(rs.getInt("grade"));
				return result;
			}
		});
		return list;
	}

}
