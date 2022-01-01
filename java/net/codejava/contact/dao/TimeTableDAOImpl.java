package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import net.codejava.contact.TimeTable;

public class TimeTableDAOImpl implements TimeTableDAO {

private JdbcTemplate jdbcTemplate;
	
	public  TimeTableDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public int save(TimeTable timeTable,Integer classroomID, Integer subjectID) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO timetable (timetable_id,classroom_id,subject_id,time) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql,timeTable.getTimetableID(),timeTable.getClassroomID(), timeTable.getSubjectID() ,timeTable.getTime());
	
	}

	@Override
	public int update(TimeTable timeTable,Integer classroomID, Integer subjectID) {
		// TODO Auto-generated method stub
		String sql = "UPDATE timetable SET timetable_id=?, classroom_id=?, subject_id=?, time=? WHERE timetable_id=?";
		return jdbcTemplate.update(sql, timeTable.getTimetableID(),timeTable.getClassroomID(), timeTable.getSubjectID() ,timeTable.getTime());
	}

	@Override
	public int delete(Integer timetableID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM timetable WHERE timetable_id=?";
		return jdbcTemplate.update(sql, timetableID);
	}

	@Override
	public TimeTable get(Integer timetableID, Integer classroomID, Integer subjectID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM timetable WHERE timetable_id=" + "'" + timetableID + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<TimeTable>() {

			@Override
			public TimeTable extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					TimeTable timetable = new TimeTable();
					timetable.setTimetableID(rs.getInt("timetableID"));
					timetable.setClassroomID(rs.getInt("classroomID"));
					timetable.setSubjectID(rs.getInt("subjectID"));
					timetable.setTime(rs.getTime("time"));
				
					return timetable;
				}
				return null;

			}

		});
	}

	@Override
	public List<TimeTable> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM timetable ";
				

		List<TimeTable> list = jdbcTemplate.query(sql, new RowMapper<TimeTable>() {

			public TimeTable mapRow(ResultSet rs, int rowNum) throws SQLException {

				TimeTable timetable = new TimeTable();
				timetable.setTimetableID(rs.getInt("timetable_id"));
				timetable.setClassroomID(rs.getInt("classroom_id"));
				timetable.setSubjectID(rs.getInt("subject_id"));
				timetable.setTime(rs.getTime("time"));
			
				return timetable;
	
				
			}

		});
		return list;
	}
	
	
	public List<TimeTable> searchTime(String search) {
		
		String sql = "SELECT * FROM timetable WHERE timetable.time LIKE " + "'%" + search + "%' "  ;
		List<TimeTable> list = jdbcTemplate.query(sql, new RowMapper<TimeTable>() {

			@Override
			public TimeTable mapRow(ResultSet rs, int rowNum) throws SQLException {

				TimeTable timetable = new TimeTable();
				timetable.setTimetableID(rs.getInt("timetable_id"));
				timetable.setClassroomID(rs.getInt("classroom_id"));
				timetable.setSubjectID(rs.getInt("subject_id"));
				timetable.setTime(rs.getTime("time"));
			
				return timetable;
			}
		});
		return list;
	}

}
