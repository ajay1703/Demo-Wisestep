package com.uditagarwal.cabbooking.controllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.springBoot.controller.Autowired;
import com.prokarma.springBoot.controller.DeleteMapping;
import com.prokarma.springBoot.controller.GetMapping;
import com.prokarma.springBoot.controller.PathVariable;
import com.prokarma.springBoot.controller.PostMapping;
import com.prokarma.springBoot.controller.PutMapping;
import com.prokarma.springBoot.controller.RequestBody;
import com.prokarma.springBoot.details.Vehicle;
import com.prokarma.springBoot.service.EmployeeService;

@RestController
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@PostMapping("/saveVehicleDetails")
	public void saveVehicle(@RequestBody Vehicle vehicle) {
		logger.debug(">>Controller: save method called");
		vehicleService.saveVehicle(vehicle);
	}

	@PutMapping("/updateEmp")
	public void updateVehicle(@RequestBody Vehicle vehicle) {
		logger.debug(">>Controller: update method called");
		vehicleService.updateVehicle(vehicle);
	}

	@GetMapping("/getAllDetails")
	public List<Vehicle> getAllDetails() {
		return vehicleService.getAllDetails();
	}

	@GetMapping("/getDetails/{id}")
	public Vehicle getDetailsById(@PathVariable int id) {
		return vehicleService.getDetailsById(id);

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		vehicleService.delete(id);
	}

	

}
