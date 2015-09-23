package com.demo.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Person
{
  @NotEmpty 	
  private String fname;
  @Range(min=18,max=60)
  private int age; 

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

@Override
public String toString() {
	return "Person [fname=" + fname + ", age=" + age + "]";
}

}
