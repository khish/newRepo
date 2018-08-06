package org.cap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int studId;
	private String studName;
	private String studLocation;
	
	public Student() {
		
	}
	public Student(int studId, String studName, String studLocation) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studLocation = studLocation;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudLocation() {
		return studLocation;
	}
	public void setStudLocation(String studLocation) {
		this.studLocation = studLocation;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studLocation=" + studLocation + "]";
	}	
}
