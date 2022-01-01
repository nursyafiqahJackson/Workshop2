package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import net.codejava.contact.ReportCard;

public class ReportCardDAOImpl implements ReportCardDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public ReportCardDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public int save(ReportCard report) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO report_card (user_id,result_id,attendance_report,attitude_report) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, report.getUserID(), report.getResultID(), report.getAttendanceReport(),report.getAttitudeReport());
		
		
	}

	@Override
	public int update(ReportCard report) {
		// TODO Auto-generated method stub
		String sql = "UPDATE report_card SET user_id=?, result_id=?, attendance_report=?, attitude_report=? WHERE user_id=? ";
		return jdbcTemplate.update(sql, report.getUserID(), report.getResultID(), report.getAttendanceReport(),report.getAttitudeReport());

	}

	@Override
	public int delete(int userID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM report_card WHERE user_id=?";
		return jdbcTemplate.update(sql, userID);
	}

	@Override
	public ReportCard get(int userID) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM report_card WHERE user_id=" + "'" + userID + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<ReportCard>() {

			@Override
			public ReportCard extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					ReportCard report = new ReportCard();
					report.setUserID(rs.getInt("user_id"));
					report.setResultID(rs.getInt("result_id"));
					report. setAttendanceReport(rs.getInt("attendance_report"));
					report.setAttitudeReport(rs.getString("attitude_report"));
					
					return report;
				}
				return null;

			}

		});
	}

	@Override
	public List<ReportCard> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT report_card.*,result.subject_id,result.grade FROM report_card JOIN result ON report_card.result_id = result.result_id ";
		
		List<ReportCard> list = jdbcTemplate.query(sql, new RowMapper<ReportCard>() {

			@Override
			public ReportCard mapRow(ResultSet rs, int rowNum) throws SQLException {
				ReportCard report = new ReportCard();
				report.setUserID(rs.getInt("user_id"));
				report.setResultID(rs.getInt("result_id"));
				report. setAttendanceReport(rs.getInt("attendance_report"));
				report.setAttitudeReport(rs.getString("attitude_report"));
				
				
				return report;
			}
		});
		return list;
	}
	
	public List<ReportCard> searchReport(String search) {
		
		String sql = "SELECT * FROM report_card WHERE report_card.attitude_report LIKE " + "'%" + search + "%' "  ;
		List<ReportCard> list = jdbcTemplate.query(sql, new RowMapper<ReportCard>() {

			@Override
			public ReportCard mapRow(ResultSet rs, int rowNum) throws SQLException {

				ReportCard report = new ReportCard();
				report.setUserID(rs.getInt("user_id"));
				report.setResultID(rs.getInt("result_id"));
				report. setAttendanceReport(rs.getInt("attendance_report"));
				report.setAttitudeReport(rs.getString("attitude_report"));
				
				
				return report;
			}
		});
		return list;
	}

}
