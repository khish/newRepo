package org.cap.controller;

import java.util.ArrayList;
import java.util.List;
import org.cap.model.Student;
import org.cap.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@Autowired
	private IStudentService studentService;
	private Student student;
	
	@RequestMapping("/")
	public String getStudentPage(ModelMap map) {
		List<Student> students= studentService.getStudents();
		List<String> locations=new ArrayList<>();
		locations.add("Pune");
		locations.add("Chennai");
		locations.add("Bangalore");
		locations.add("Hyderabad");
		locations.add("Mumbai");
		
		map.put("studs",students);
		map.put("locations", locations);
		
		if(student!=null)
			map.put("student", student);
		else
			map.put("student", new Student());
		return "studentPage";
	}
	
	@RequestMapping("/update/{studId}")
	public String updateStudent(@PathVariable("studId") 
			Integer studentId) {
		student=studentService.findStudent(studentId);
		return "redirect:/";
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("stud") Student student1) {
		if(student1!=null) {
		studentService.update(student1);
		student=null;
		}
		return "redirect:/";
	}
	
}
