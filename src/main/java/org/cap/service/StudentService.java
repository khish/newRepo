package org.cap.service;

import java.util.List;

import org.cap.dao.IStudentDao;
import org.cap.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("studentService")
public class StudentService implements IStudentService{

	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentDao.getStudents();
	}

	@Override
	public Student findStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return studentDao.findStudent(studentId);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
		
	}

	
	
}
