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

public class AttendanceDAOImpl implements AttendanceDAO {

	private JdbcTemplate jdbcTemplate;
	
	public AttendanceDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    } 
	@Override
	public int save(Attendance attendance) {
		// TODO Auto-generated method stub
		
	String sql="INSERT INTO attendance (attendance_name,attendence_time,form,subject_name) VALUES (?,?,?,?)";
	return jdbcTemplate.update(sql,attendance.getAttendanceName(),attendance.getAttendanceTime(),attendance.getForm(),attendance.getSubjectName());
	
	}

	@Override
	public int update(Attendance attendance) {
		// TODO Auto-generated method stub
		String sql = "UPDATE attendance SET attendance_name=?, attendence_time=?, form=?, subbject_name=? WHERE attendance_id=?";
		return jdbcTemplate.update(sql, attendance.getAttendanceName(),attendance.getAttendanceTime(),attendance.getForm(),attendance.getSubjectName());
	}

	@Override
	public int delete(Integer attendanceID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM attendance WHERE attendance_id=?";
		return jdbcTemplate.update(sql, attendanceID);
	}

	@Override
	public Attendance get(Integer attendanceID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM attendance WHERE attendance_id=" + "'" + attendanceID + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<Attendance>() {

			@Override
			public Attendance extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					Attendance attendance = new Attendance();
					attendance.setAttendanceID(rs.getInt("attendance_id"));
					attendance.setAttendanceName(rs.getString("attendance_name"));
					attendance.setAttendanceTime(rs.getDate("attendence_time"));
					attendance.setForm(rs.getInt("form"));
					attendance.setSubjectName(rs.getString("subject_name"));
				
					return attendance;
				}
				return null;

			}

		});
	}

	@Override
	public List<Attendance> list() {
		String sql = "SELECT * FROM attendance";

		List<Attendance> list = jdbcTemplate.query(sql, new RowMapper<Attendance>() {

			@Override
			public Attendance mapRow(ResultSet rs, int rowNum) throws SQLException {

				Attendance attendance = new Attendance();
				attendance.setAttendanceID(rs.getInt("attendance_id"));
				attendance.setAttendanceName(rs.getString("attendance_name"));
				attendance.setAttendanceTime(rs.getDate("attendence_time"));
				attendance.setForm(rs.getInt("form"));
				attendance.setSubjectName(rs.getString("subject_name"));
			
				return attendance;

			}
		});
		return list;
	}
	
	public int getUserIdByAttendanceName(String attendance_name) {

		String sql = "SELECT user_id FROM users WHERE attendance_name=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { attendance_name }, Integer.class);
	}
	
	public List<Attendance> search(String search) {
		
		String sql = "SELECT * FROM attendance WHERE attendance.form LIKE " + "'%" + search + "%' "  ;
		List<Attendance> list = jdbcTemplate.query(sql, new RowMapper<Attendance>() {

			@Override
			public Attendance mapRow(ResultSet rs, int rowNum) throws SQLException {

				Attendance attendance = new Attendance();
				attendance.setAttendanceID(rs.getInt("attendance_id"));
				attendance.setAttendanceName(rs.getString("attendance_name"));
				attendance.setAttendanceTime(rs.getDate("attendence_time"));
				attendance.setForm(rs.getInt("form"));
				attendance.setSubjectName(rs.getString("subject_name"));
			
				return attendance;
			}
		});
		return list;
	}
	

	

}
