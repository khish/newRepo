package org.cap.service;

import java.util.List;

import org.cap.model.Student;


public interface IStudentService {

	public List<Student> getStudents();
	public Student findStudent(Integer studentId);
	public void update(Student student);
	
}
