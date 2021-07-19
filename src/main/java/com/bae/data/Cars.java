package com.bae.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Tells Spring class represents table
public class Cars {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	private int id;
	private String brand;
	private String model;
	private int age;

	public Cars(int id, String brand, String model, int age) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.age = age;
	}

	public Cars(String brand, String model, int age) {
		super();
		this.brand = brand;
		this.model = model;
		this.age = age;
	}

	public Cars() { // Required (Blank Constructor)

	}

	// Required
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cars [brand=" + brand + ", model=" + model + ", age=" + age + "]";
	}

}
