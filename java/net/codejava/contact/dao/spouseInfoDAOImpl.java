package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.spouseInfo;

public class spouseInfoDAOImpl implements spouseInfoDAO {

private JdbcTemplate jdbcTemplate;
	
	public spouseInfoDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public int save(spouseInfo spouse) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO spouse_information (user_details_id,name,ic_number,phone_number, address, nationality,ethnicity, email, occupation) VALUES (?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, spouse.getUserDetailsID(), spouse.getName(), spouse.getIcNumber(),spouse.getPhoneNumber(), spouse.getAddress(),spouse.getNationality(),spouse.getEthnicity(),spouse.getEmail(),spouse.getOccupation());
		
	}

	@Override
	public int update(spouseInfo spouse) {
		
	String sql = "UPDATE spouse_information  SET user_details_id=?, name=?, ic_number=?, phone_number=?, address=?, nationality=?,ethnicity=?, email=?, occupation=? WHERE user_details_id=?";
	return jdbcTemplate.update(sql, spouse.getUserDetailsID(), spouse.getName(), spouse.getIcNumber(),spouse.getPhoneNumber(), spouse.getAddress(),spouse.getNationality(),spouse.getEthnicity(),spouse.getEmail(),spouse.getOccupation());

	}

	@Override
	public int delete(int userDetailID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM spouse_information WHERE user_details_id=?";
		return jdbcTemplate.update(sql, userDetailID);
	}

	@Override
	public spouseInfo get(int userDetailID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM spouse_information WHERE user_details_id=" + "'" + userDetailID + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<spouseInfo>() {

			@Override
			public spouseInfo extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					spouseInfo SpouseInfo = new spouseInfo();
					SpouseInfo.setUserDetailsID(rs.getInt("user_details_id"));
					SpouseInfo.setName(rs.getString("name"));
					SpouseInfo.setIcNumber(rs.getInt("ic_number"));
					SpouseInfo.setPhoneNumber(rs.getInt("phone_number"));
					SpouseInfo.setAddress(rs.getString("address"));
					SpouseInfo.setNationality(rs.getString("nationality"));
					SpouseInfo.setEthnicity(rs.getString("ethnicity"));
					SpouseInfo.setEmail(rs.getString("email"));
					SpouseInfo.setOccupation(rs.getString("occupation"));
					return SpouseInfo;
				}
				return null;

			}

		});
	}

	@Override
	public List<spouseInfo> list(Integer userDetailID) {
		// TODO Auto-generated method stub

		String sql = "SELECT spouse_information.* FROM spouse_information JOIN user_details ON spouse_information.user_details_id=user_details.user_details_id WHERE spouse_information.user_details_id=" + "'" + userDetailID + "'";
	
		
		List<spouseInfo> list = jdbcTemplate.query(sql, new RowMapper<spouseInfo>() {

			@Override
			public spouseInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				spouseInfo SpouseInfo = new spouseInfo();
				SpouseInfo.setUserDetailsID(rs.getInt("user_details_id"));
				SpouseInfo.setName(rs.getString("name"));
				SpouseInfo.setIcNumber(rs.getInt("ic_number"));
				SpouseInfo.setPhoneNumber(rs.getInt("phone_number"));
				SpouseInfo.setAddress(rs.getString("address"));
				SpouseInfo.setNationality(rs.getString("nationality"));
				SpouseInfo.setEthnicity(rs.getString("ethnicity"));
				SpouseInfo.setEmail(rs.getString("email"));
				SpouseInfo.setOccupation(rs.getString("occupation"));
				return SpouseInfo;
			}
		});
		return list;
		
		
	}
}
