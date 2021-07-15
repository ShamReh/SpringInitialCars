package com.bae.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bae.data.CarRepo;
import com.bae.data.Cars;

@Service
@Primary

public class CarServiceDB implements CarService {

	private CarRepo repo;

	public CarServiceDB(CarRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Cars createCar(Cars car1) {
		return this.repo.save(car1);
	}

	@Override
	public List<Cars> getCar1() {
		return this.repo.findAll();
	}

	@Override
	public Cars getCar(int id) {
		return this.repo.getById(id);
	}

	@Override
	public String deleteCar(int id) {
		this.repo.deleteById(id);

		return "Deleted: " + id;
	}

	@Override
	public Cars replaceCar(Cars newcar, int id) {

//Pull out existing record
		Cars found = this.repo.findById(id).get();

		// Modify Record
		found.setAge(newcar.getAge());
		found.setBrand(newcar.getBrand());
		found.setModel(newcar.getModel());

		// Save it back to overwrite it
		Cars updated = this.repo.save(found);

		return updated;
	}

	@Override
	public List<Cars> getByBrand(String name) {
		return this.repo.findByBrandIgnoreCase(name);
	}

}
