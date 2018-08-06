package org.cap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cap.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("studentDao")
@Transactional
public class StudentDao implements IStudentDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Student> getStudents() {
		List<Student> students = entityManager.createQuery("from Student").getResultList();
		return students;
	}

	@Override
	public Student findStudent(Integer studentId) {
		Student student = entityManager.find(Student.class, studentId);
		return student;
	}

	@Override
	public void update(Student student) {
		if(student.getStudId()!=0)
			entityManager.merge(student);
		else
			entityManager.persist(student);
		
	}


}
