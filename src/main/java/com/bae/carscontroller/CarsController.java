package com.bae.carscontroller;

import java.util.List;

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
	public void createCar(@RequestBody Cars car1) { // less fancy
		// just Java
		System.out.println(car1);
		this.service.createCar(car1);
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
	@GetMapping("/getCar1")
	List<Cars> getCar1() {
		return this.service.getCar1();
	}

	@GetMapping("/getSpecificCar/{id}")
	public Cars getCar(@PathVariable int id) {
		return this.service.getCar(id);
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
	public String deleteCar(@PathVariable int id) {
		return this.service.deleteCar(id);

	}

	@PutMapping("/replaceCar/{id}")
	public Cars replaceCar(@RequestBody Cars newcar, @PathVariable int id) {
		return this.service.replaceCar(newcar, id);

	}

}
