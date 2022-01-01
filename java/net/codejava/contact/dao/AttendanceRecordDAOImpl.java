package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import net.codejava.contact.AttendanceRecord;

public class AttendanceRecordDAOImpl implements AttendanceRecordDAO {

	private JdbcTemplate jdbcTemplate;

	public AttendanceRecordDAOImpl (DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	@Override
	public int save(AttendanceRecord record) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO attendance_record (attendance_id,user_id,status,date) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, record.getAttendanceID(), record.getUserID(), record.getStatus(), record.getDate());
		
		
	}

	@Override
	public int update(AttendanceRecord record) {
		String sql = "UPDATE attendance_record SET attendance_id=?, user_id=?,status=?,date=? WHERE attendance_id=?";
		return jdbcTemplate.update(sql, record.getAttendanceID(), record.getUserID(), record.getStatus(), record.getDate());
	}

	@Override
	public int delete(int attendanceID) {
		String sql = "DELETE FROM attendance_record WHERE attendance_id=?";
		return jdbcTemplate.update(sql, attendanceID);
	}

	@Override
	public AttendanceRecord get(int attendanceID) {
		// TODO Auto-generated method stub
		
	
				String sql = "SELECT * FROM attendance_record WHERE  attendance_id=" + "'" +  attendanceID + "'";

				return jdbcTemplate.query(sql, new ResultSetExtractor<AttendanceRecord>() {

					@Override
					public AttendanceRecord extractData(ResultSet rs) throws SQLException, DataAccessException {

						if (rs.next()) {

							AttendanceRecord record = new AttendanceRecord();
							record.setAttendanceID(rs.getInt("attendance_id"));
							record.setUserID(rs.getInt("user_id"));
							record.setStatus(rs.getString("status"));
							record.setDate(rs.getDate("date"));
							return record;
						}
						return null;

					}

				});
	
	}

	@Override
	public List<AttendanceRecord> list() {
		String sql = "SELECT attendance_record.* FROM  attendance_record JOIN users ON attendance_record.user_id=users.user_id ";
				
		List<AttendanceRecord> list = jdbcTemplate.query(sql, new RowMapper<AttendanceRecord>() {

			public AttendanceRecord mapRow(ResultSet rs, int rowNum) throws SQLException {

				AttendanceRecord record = new AttendanceRecord();
				record.setAttendanceID(rs.getInt("attendance_id"));
				record.setUserID(rs.getInt("user_id"));
				record.setStatus(rs.getString("status"));
				record.setDate(rs.getDate("date"));
				
				return record;
			 
				
			}
		});
		return list;
	}
	
	public int getUserIdByAttendanceName(String attendance_name) {

		String sql = "SELECT user_id FROM users WHERE attendance_name=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { attendance_name }, Integer.class);
	}
	
	public int getAttendanceIdByid(Integer attendance_id) {

		String sql = "SELECT attendance_id FROM attendance WHERE attendance_id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { attendance_id }, Integer.class);
	}
	
	
public List<AttendanceRecord> searchRecord(String search) {
		
		String sql = "SELECT * FROM attendance_record WHERE attendance_record.status LIKE " + "'%" + search + "%' "  ;
		List<AttendanceRecord> list = jdbcTemplate.query(sql, new RowMapper<AttendanceRecord>() {

			@Override
			public AttendanceRecord mapRow(ResultSet rs, int rowNum) throws SQLException {

				AttendanceRecord record = new AttendanceRecord();
				record.setAttendanceID(rs.getInt("attendance_id"));
				record.setUserID(rs.getInt("user_id"));
				record.setStatus(rs.getString("status"));
				record.setDate(rs.getDate("date"));
				
				return record;
			}
		});
		return list;
	}

}
