package com.bae.service;

import java.util.List;

import com.bae.data.Cars;

public interface CarService {

	public void createCar(Cars car1);

	List<Cars> getCar1();

	public Cars getCar(int id);

	public String deleteCar(int id);

	public Cars replaceCar(Cars newcar, int id);

}
