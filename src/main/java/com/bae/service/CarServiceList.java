package com.bae.service;

import java.util.ArrayList;
import java.util.List;

import com.bae.data.Cars;

//@Service
//@Primary // Tells Spring to make this one

public class CarServiceList implements CarService {

	public List<Cars> cars = new ArrayList<>();

	@Override
	public List<Cars> getByBrand(String name) {

		return null;
	}

	@Override
	public Cars createCar(Cars car1) {
		System.out.println(car1);
		this.cars.add(car1);
		return this.cars.get(this.cars.size() - 1);
	}

	@Override
	public List<Cars> getAllCars() {
		return this.cars;
	}

	@Override
	public Cars getCar(int id) {
		Cars found = this.cars.get(id);
		return found;
	}

	@Override

	public String deleteCar(int id) {
		this.cars.remove(id);

		return "Deleted Car at Index: " + id;
	}

	@Override
	public Cars replaceCar(Cars newcar, int id) {
		return this.cars.set(id, newcar);

	}

}
