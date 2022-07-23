

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.springBoot.controller.EmployeeController;
import com.prokarma.springBoot.dao.EmployeeDao;
import com.prokarma.springBoot.details.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	private static Logger logger = Logger.getLogger(VehicleServiceImpl.class);

	@Autowired
	private VehicleDAO vehicleDAO;

	public void setVehicleDAO(VehicleDAO vehicleDAO) {
		this.vehicleDAO = vehicleDAO;
	}

	@Override
	public void saveVehicle(Vehicle vehicle) {
		logger.debug(">>ServiceImpl: saved method called");
		vehicleDAO.saveVehicle(vehicle);

		

	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		logger.debug(">>ServiceImpl: update method called");
		vehicleDAO.updateVehicle(vehicle);
		

	}

	

	@Override
	public List<Vehicle> getAllDetails() {
		return vehicleDAO.getAllDetails();
	}

	@Override
	public Vehicle getDetailsById(int id) {
		return vehicleDAO.getDetailsById(id);
	}

	@Override
	public void delete(int id) {
		vehicleDAO.delete(id);
	}

}
