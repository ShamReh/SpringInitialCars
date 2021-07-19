package com.bae.carscontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.data.Cars;
import com.bae.service.CarService;

@RestController
public class CarsController {

	// dependency
	private CarService service;

	// Spring injecting it into my class
	public CarsController(CarService service, List<Cars> cars) {
		super();
		this.service = service;
	}

//	@GetMapping("/") // MAPS a GET request to "/" to this method
//	public String hello() {
//		return "Hello, World!";
//	}

	@PostMapping("/createCar") // fancy
	public ResponseEntity<Cars> createCar(@RequestBody Cars car1) { // less fancy
		// just Java
		System.out.println(car1);
		Cars created = this.service.createCar(car1);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

//	@DeleteMapping("/deleteCars/{id}")
//	public String deleteCars(@PathVariable int id) {
//		return "Deleted car at index: " + id;
//	}

//	@GetMapping("/getCar")
//	public Cars getCar() {
//		return new Cars("BMW", "M4", 2019);
//	}

	// Gets all cars
	@GetMapping("/getAllCars")
	public ResponseEntity<List<Cars>> getAllCars() {
		List<Cars> body = this.service.getAllCars();
		return new ResponseEntity<List<Cars>>(body, HttpStatus.OK);
	}

	@GetMapping("/getSpecificCar/{id}")
	public ResponseEntity<Cars> getCar(@PathVariable int id) {
		Cars body = this.service.getCar(id);
		return new ResponseEntity<Cars>(body, HttpStatus.OK);
	}

//	@DeleteMapping("/deleteCar/{id}")
//	public String deleteCar(@PathVariable int id) {
//		for (Cars c : cars) {
//			if (c == cars) {
//				cars.remove(id);
//			}
//		}
//		return "Deleted Car at Index: " + id;
//	}

	@DeleteMapping("/deleteCar/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable int id) {
		String body = this.service.deleteCar(id);
		return new ResponseEntity<String>(body, HttpStatus.NO_CONTENT);

	}

	@PutMapping("/replaceCar/{id}")
	public ResponseEntity<Cars> replaceCar(@RequestBody Cars newcar, @PathVariable int id) {
		Cars body = this.service.replaceCar(newcar, id);
		return new ResponseEntity<Cars>(body, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getByBrand/{name}")
	public ResponseEntity<List<Cars>> getByName(@PathVariable String name) {
		List<Cars> body = this.service.getByBrand(name);
		return new ResponseEntity<List<Cars>>(body, HttpStatus.ACCEPTED);
	}

}
