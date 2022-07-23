

import java.util.List;


import com.prokarma.springBoot.details.Vehicle;

public interface VehicleService {

	public void saveVehicle(Vehicle vehicle);

	public void updateVehicle(Vehicle vehicle);


	public List<Vehicle> getAllDetails();

	public Vehicle getDetailsById(int id);

	public void delete(int id);

}
