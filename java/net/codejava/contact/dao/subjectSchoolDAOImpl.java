package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.subjectSchool;

public class subjectSchoolDAOImpl implements subjectSchoolDAO {

private JdbcTemplate jdbcTemplate;
	
	public subjectSchoolDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    } 
	
	
	@Override
	public int save(subjectSchool SubjectSchool) {
		// TODO Auto-generated method stub
		
	String sql="INSERT INTO subject (subject_name) VALUES (?)";
	return jdbcTemplate.update(sql,SubjectSchool.getSubjectName());
		
	}

	@Override
	public int update(subjectSchool SubjectSchool) {
		// TODO Auto-generated method stub
		String sql = "UPDATE subject SET subject_name=?";
		return jdbcTemplate.update(sql, SubjectSchool.getSubjectName());
	}

	@Override
	public int delete(Integer subjectID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM subject WHERE subject_id=?";
		return jdbcTemplate.update(sql, subjectID);
	}

	@Override
	public subjectSchool get(Integer subjectID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM subject WHERE subject_id=" + "'" + subjectID + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<subjectSchool>() {

			@Override
			public subjectSchool extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					subjectSchool SubjectSchool = new subjectSchool();
					SubjectSchool.setSubjectID(rs.getInt("subject_id"));
					SubjectSchool.setSubjectName(rs.getString("subject_name"));
				
					return SubjectSchool;
				}
				return null;

			}

		});
	}

	@Override
	public List<subjectSchool> list() {

		String sql = "SELECT * FROM subject";

		List<subjectSchool> list = jdbcTemplate.query(sql, new RowMapper<subjectSchool>() {

			@Override
			public subjectSchool mapRow(ResultSet rs, int rowNum) throws SQLException {

				

					subjectSchool SubjectSchool = new subjectSchool();
					SubjectSchool.setSubjectID(rs.getInt("subject_id"));
					SubjectSchool.setSubjectName(rs.getString("subject_name"));
					
				
					return SubjectSchool;
				
				

			}

		});
		return list;
		
	}

}
