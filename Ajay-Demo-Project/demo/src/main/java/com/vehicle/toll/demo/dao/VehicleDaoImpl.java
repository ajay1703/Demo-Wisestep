

import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prokarma.springBoot.rowmapper.EmployeeRowMapper;
import com.prokarma.springBoot.controller.EmployeeController;
import com.prokarma.springBoot.dao.*;
import com.prokarma.springBoot.details.Vehicle;

@Repository
public class VehicleDAOImpl implements VehicleDAO {
	log.Info("Call entered into DAO layer");

	private static Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void saveVehicle(Vehicle vehicle) {

		String query = "insert into VEHICLE(Id,NAME,Distance,Type) VALUES(?,?,?,?)";
		Object[] inputs = { vehicle.getId(), vehicle.getName(),
				vehicle.getDistance(), vehicle.getType() };

		jdbcTemplate.update(query, inputs);

		logger.debug(">>DaoImpl: Data saved in Database");
		

	}

	@Override
	public void updateVehicle(Vehicle vehicle) {

		String query = "Update VEHICLE SET NAME =?,Distance=?,Type=? where ID=?";
		Object[] inputs = { vehicle.getName(),
				vehicle.getDistance(), vehicle.getType(), vehicle.getId() };
		jdbcTemplate.update(query, inputs);

		logger.debug(">>DaoImpl: Data updated in Database");

	}

	

	@Override
	public List<Vehicle> getAllDetails() {
		String sql = "SELECT * FROM VEHICLE";
		List<Vehicle> vehicleList = jdbcTemplate.query(sql, new VehicleRowMapper());
		return vehicleList;
	}

	@Override
	public Vehicle getDetailsById(int id) {

		String query = "SELECT * FROM VEHICLE WHERE ID = ?";
		Vehicle vehicleDetails = jdbcTemplate.queryForObject(query, new Object[] { id }, new VehicleRowMapper());

		return vehicleDetails;
	}

	public void delete(int id) {
		String SQL = "Delete from VEHICLE where id = ?";
		jdbcTemplate.update(SQL, id);
		logger.debug(">>DaoImpl: Id deleted in Database");
	}

}
