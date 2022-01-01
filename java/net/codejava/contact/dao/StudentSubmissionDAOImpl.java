package net.codejava.contact.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.StudentHomework;
import net.codejava.contact.StudentSubmission;

public class StudentSubmissionDAOImpl implements StudentSubmissionDAO {

private JdbcTemplate jdbcTemplate;
	
	public  StudentSubmissionDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    } 
	
	@Override
	public int save(StudentSubmission submit) {
		// TODO Auto-generated method stub
	
		String sql="INSERT INTO submission (work_id,user_id,submission_number,file,comments,grade) VALUES (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, submit.getWorkID(),submit.getUserID(), submit.getSubmissionNumber() ,submit.getFile(),	
				submit.getComments(), submit.getGrade());
	}

	@Override
	public int update(StudentSubmission submit) {
		// TODO Auto-generated method stub
		String sql = "UPDATE submission SET work_id=?, user_id=?, submission_number=?, file=?, comments=?,grade=? WHERE submission_id=?";
		return jdbcTemplate.update(sql, submit.getWorkID(),submit.getUserID(), submit.getSubmissionNumber() ,submit.getFile(),	
				submit.getComments(), submit.getGrade());
	}

	@Override
	public int delete(int submissionID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM submission WHERE submission_id=?";
		return jdbcTemplate.update(sql, submissionID);
	}

	@Override
	public StudentSubmission get(int submissionID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM submission WHERE submission_id=" + "'" + submissionID + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<StudentSubmission>() {

			@Override
			public StudentSubmission extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					StudentSubmission submit = new StudentSubmission();
					submit.setSubmissionID(rs.getInt("submission_id"));
					submit.setWorkID(rs.getInt("work_id"));
					submit.setUserID(rs.getInt("user_id"));
					submit.setSubmissionNumber(rs.getInt("submission_number"));
					submit. setFile(rs.getBytes("file"));
					submit.setComments(rs.getString("comments"));
					submit.setGrade(rs.getInt("grade"));
					return submit;
				}
				return null;

			}

		});
	}

	@Override
	public List<StudentSubmission> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM submission ";
				

		List<StudentSubmission> list = jdbcTemplate.query(sql, new RowMapper<StudentSubmission>() {

			public StudentSubmission mapRow(ResultSet rs, int rowNum) throws SQLException {

				StudentSubmission submit = new StudentSubmission();
				submit.setSubmissionID(rs.getInt("submission_id"));
				submit.setWorkID(rs.getInt("work_id"));
				submit.setUserID(rs.getInt("user_id"));
				submit.setSubmissionNumber(rs.getInt("submission_number"));
				submit. setFile(rs.getBytes("file"));
				submit.setComments(rs.getString("comments"));
				submit.setGrade(rs.getInt("grade"));
				return submit;
				
		
				
				
			}

		});
		return list;
	}
	
public List<StudentSubmission> searchSubmit(String search) {
		
		String sql = "SELECT * FROM submission WHERE submission.submission_number LIKE " + "'%" + search + "%' "  ;
		List<StudentSubmission> list = jdbcTemplate.query(sql, new RowMapper<StudentSubmission>() {

			@Override
			public StudentSubmission mapRow(ResultSet rs, int rowNum) throws SQLException {

				StudentSubmission submit = new StudentSubmission();
				submit.setSubmissionID(rs.getInt("submission_id"));
				submit.setWorkID(rs.getInt("work_id"));
				submit.setUserID(rs.getInt("user_id"));
				submit.setSubmissionNumber(rs.getInt("submission_number"));
				submit. setFile(rs.getBytes("file"));
				submit.setComments(rs.getString("comments"));
				submit.setGrade(rs.getInt("grade"));
				return submit;
			}
		});
		return list;
	}
	


}
