package Dto;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer s_roll;
	private String s_name;
	private String s_course;
	private Integer s_age;
	private String s_gender;
	public int getS_roll() {
		return s_roll;
	}
	public void setS_roll(Integer s_roll) {
		this.s_roll = s_roll;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_course() {
		return s_course;
	}
	public void setS_course(String s_course) {
		this.s_course = s_course;
	}
	public int getS_age() {
		return s_age;
	}
	public void setS_age(Integer s_age) {
		this.s_age = s_age;
	}
	public String getS_gender() {
		return s_gender;
	}
	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student::[s_roll="+s_roll+" ,s_name="+s_name+" ,s_course="+s_course+" ,s_age="+s_age+" ,s_gender="+s_gender+"]";
	}
	
	
	

}
