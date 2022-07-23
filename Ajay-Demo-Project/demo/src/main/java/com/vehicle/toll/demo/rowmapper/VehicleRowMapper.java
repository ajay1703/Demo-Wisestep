

import java.sql.ResultSet;


import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.prokarma.springBoot.details.Vehicle;

public class VehicleRowMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {

		Vehicle details = new Vehicle();
		details.setId(rs.getInt("Id"));
		details.setName(rs.getString("NAME"));
		details.setDistance(rs.getString("Distence"));
		details.setType(rs.getInt("Type"));
		return details;
	}

}
