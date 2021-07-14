package com.bae.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bae.data.Cars;

@Service
@Primary // Tells Spring to make this one

public class CarServiceList implements CarService {

	public List<Cars> cars = new ArrayList<>();

	@Override
	public void createCar(Cars car1) {
		System.out.println(car1);
		this.cars.add(car1);
	}

	@Override
	public List<Cars> getCar1() {
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
