package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.Attendance;
import net.codejava.contact.StudentHomework;

public class StudentHomeworkDAOImpl implements StudentHomeworkDAO {

	private JdbcTemplate jdbcTemplate;

	public StudentHomeworkDAOImpl (DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	

	@Override
	public int save(StudentHomework work) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO work (work_id,subject_id,work_name,work_description,work_start,work_end) VALUES (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,work.getWorkID(),work.getSubjectID(), work.getWorkName(),work.getWorkDescription(),work.getWorkStart(),work.getWorkEnd());
	}

	@Override
	public int update(StudentHomework work) {
		// TODO Auto-generated method stub
		String sql = "UPDATE work SET work_id=?, subject_id=?,work_name=?,work_description=?,work_start=?,work_end=? WHERE work_id=?";
		return jdbcTemplate.update(sql, work.getWorkID(),work.getSubjectID(),work.getWorkName(),work.getWorkDescription(),work.getWorkStart(),work.getWorkEnd());
	}

	@Override
	public int delete(Integer workID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM work WHERE work_id=?";
		return jdbcTemplate.update(sql, workID);
	}

	@Override
	public StudentHomework get(Integer workID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM work WHERE work_id=" + "'" + workID + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<StudentHomework>() {

			@Override
			public StudentHomework extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					StudentHomework work = new StudentHomework();
					work.setWorkID(rs.getInt("work_id"));
					work.setSubjectID(rs.getInt("subject_id"));
					work.setWorkName(rs.getString("work_name"));
					work.setWorkDescription(rs.getString("work_description"));
					work.setWorkStart(rs.getDate("work_start"));
					work.setWorkEnd(rs.getDate("work_end"));
					return work;
				}
				return null;

			}

		});
	}

	@Override
	public List<StudentHomework> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT work.*,subject.subject_id  FROM work "
				+ "JOIN subject "
				+ "ON work.subject_id=subject.subject_id";
				

		List<StudentHomework> list = jdbcTemplate.query(sql, new RowMapper<StudentHomework>() {

			public StudentHomework mapRow(ResultSet rs, int rowNum) throws SQLException {

				StudentHomework work = new StudentHomework();
				work.setWorkID(rs.getInt("work_id"));
				work.setSubjectID(rs.getInt("subject_id"));
				work.setWorkName(rs.getString("work_name"));
				work.setWorkDescription(rs.getString("work_description"));
				work.setWorkStart(rs.getDate("work_start"));
				work.setWorkEnd(rs.getDate("work_end"));
				return work;
				
				
			}

		});
		return list;
	}
	
	public List<StudentHomework> searchWork(String search) {
		
		String sql = "SELECT * FROM work WHERE work.work_name LIKE " + "'%" + search + "%' "  ;
		List<StudentHomework> list = jdbcTemplate.query(sql, new RowMapper<StudentHomework>() {

			@Override
			public StudentHomework mapRow(ResultSet rs, int rowNum) throws SQLException {

				StudentHomework work = new StudentHomework();
				work.setWorkID(rs.getInt("work_id"));
				work.setSubjectID(rs.getInt("subject_id"));
				work.setWorkName(rs.getString("work_name"));
				work.setWorkDescription(rs.getString("work_description"));
				work.setWorkStart(rs.getDate("work_start"));
				work.setWorkEnd(rs.getDate("work_end"));
				return work;
			}
		});
		return list;
	}
	
	

}
