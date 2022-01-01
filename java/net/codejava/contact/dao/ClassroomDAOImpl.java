package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.Classroom;

public class ClassroomDAOImpl implements ClassroomDAO {

private JdbcTemplate jdbcTemplate;
	
	public ClassroomDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
	@Override
	public int save(Classroom classroom) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO classroom (class_name,form,class_teacher_name) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, classroom.getClassName(), classroom.getForm(), classroom.getTeacherName());
		
	}

	@Override
	public int update(Classroom classroom) {
		// TODO Auto-generated method stub
		String sql = "UPDATE classroom SET class_name=?, form=?, class_teacher_name=? WHERE classroom_id=?";
		return jdbcTemplate.update(sql, classroom.getClassName(), classroom.getForm(), classroom.getTeacherName(),
				classroom.getClassroomId());

		
	}

	@Override
	public int delete(Integer classroomId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM classroom WHERE classroom_id=?";
		return jdbcTemplate.update(sql, classroomId);
		
	}

	@Override
	public Classroom get(Integer classroomId) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM classroom WHERE classroom_id=" + "'" + classroomId + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<Classroom>() {

			@Override
			public Classroom extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					Classroom classroom = new Classroom();
					classroom.setClassroomId(rs.getInt("classroom_id"));
					classroom.setClassName(rs.getString("class_name"));
					classroom.setForm(rs.getInt("form"));
					classroom.setTeacherName(rs.getString("class_teacher_name"));
					
					return classroom;
				}
				return null;

			}

		});
		
		
	}

	@Override
	public List<Classroom> list() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM classroom ORDER BY class_name";
		List<Classroom> list = jdbcTemplate.query(sql, new RowMapper<Classroom>() {

			@Override
			public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {

				Classroom classroom = new Classroom();
				classroom.setClassroomId(rs.getInt("classroom_id"));
				classroom.setClassName(rs.getString("class_name"));
				classroom.setForm(rs.getInt("form"));
				classroom.setTeacherName(rs.getString("class_teacher_name"));
				return classroom;
			}
		});
		return list;
		
	}
	
	public String checkClassName(String className) {
		
		String sql = "SELECT class_name FROM classroom WHERE class_name=" + "'" + className + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				return rs.next() ? rs.getString("class_name") : null;
			}
		});
	}
	
	public String checkClassNameById(Integer classroomId) {

		String sql = "SELECT class_name FROM classroom WHERE classroom_id =" + classroomId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				return rs.next() ? rs.getString("class_name") : null;
			}
		});

	}
	
	public List<Classroom> emptyClassroom() {

		String sql = "SELECT classroom.class_name FROM classroom WHERE classroom.classroom_id NOT IN (SELECT classroom_id FROM class_participant)";
		List<Classroom> list = jdbcTemplate.query(sql, new RowMapper<Classroom>() {

			@Override
			public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
				Classroom classroom = new Classroom();
				classroom.setClassName(rs.getString("class_name"));
				return classroom;
			}
		});
		return list;
	}
	
	public List<Classroom> searchClassroomByName(String search) {
		
		String sql = "SELECT * FROM classroom WHERE classroom.class_name LIKE " + "'%" + search + "%'";
		List<Classroom> list = jdbcTemplate.query(sql, new RowMapper<Classroom>() {

			@Override
			public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {

				Classroom classroom = new Classroom();
				classroom.setClassroomId(rs.getInt("classroom_id"));
				classroom.setClassName(rs.getString("class_name"));
				classroom.setForm(rs.getInt("form"));
				classroom.setTeacherName(rs.getString("class_teacher_name"));
				
				return classroom;
			}
		});
		return list;
	}

	public List<Classroom> searchClassroomByTeacherName(String search) {
		
		String sql = "SELECT * FROM classroom WHERE classroom.class_teacher_name LIKE " + "'%" + search + "%'";
		List<Classroom> list = jdbcTemplate.query(sql, new RowMapper<Classroom>() {

			@Override
			public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {

				Classroom classroom = new Classroom();
				classroom.setClassroomId(rs.getInt("classroom_id"));
				classroom.setClassName(rs.getString("class_name"));
				classroom.setForm(rs.getInt("form"));
				classroom.setTeacherName(rs.getString("class_teacher_name"));
				
				return classroom;
			}
		});
		return list;
	}

	public List<Classroom> searchClassroomByForm(String search) {
		
		String sql = "SELECT * FROM classroom WHERE classroom.form LIKE " + "'%" + search + "%'";
		List<Classroom> list = jdbcTemplate.query(sql, new RowMapper<Classroom>() {

			@Override
			public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {

				Classroom classroom = new Classroom();
				classroom.setClassroomId(rs.getInt("classroom_id"));
				classroom.setClassName(rs.getString("class_name"));
				classroom.setForm(rs.getInt("form"));
				classroom.setTeacherName(rs.getString("class_teacher_name"));
				
				return classroom;
			}
		});
		return list;
	}

}
