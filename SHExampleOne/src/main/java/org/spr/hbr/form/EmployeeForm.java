package org.spr.hbr.form;

import java.io.Serializable;
import java.math.BigDecimal;

public class EmployeeForm implements Serializable{

	private static final long serialVersionUID = 1409702995523107695L;
	
	private int id;
	private String name;
	private BigDecimal salary;
	
	public EmployeeForm(){}
	
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
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
