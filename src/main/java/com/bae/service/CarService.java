package com.bae.service;

import java.util.List;

import com.bae.data.Cars;

public interface CarService {

	public Cars createCar(Cars car1);

	List<Cars> getAllCars();

	public Cars getCar(int id);

	public String deleteCar(int id);

	public Cars replaceCar(Cars newcar, int id);

	List<Cars> getByBrand(String name);

}
