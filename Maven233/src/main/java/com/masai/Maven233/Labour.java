package com.masai.Maven233;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Labour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String Address;
	private LocalDate joindate;
private double salary;
private long adharno;
public Labour() {
	super();
	// TODO Auto-generated constructor stub
}
public Labour(String name, String address, LocalDate joindate, double salary, long adharno) {
	super();

	this.name = name;
	Address = address;
	this.joindate = joindate;
	this.salary = salary;
	this.adharno = adharno;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public LocalDate getJoindate() {
	return joindate;
}
public void setJoindate(LocalDate joindate) {
	this.joindate = joindate;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public long getAdharno() {
	return adharno;
}
public void setAdharno(long adharno) {
	this.adharno = adharno;
}
@Override
public String toString() {
	return "Labour [id=" + id + ", name=" + name + ", Address=" + Address + ", joindate=" + joindate + ", salary="
			+ salary + ", adharno=" + adharno + "]";
}






}
