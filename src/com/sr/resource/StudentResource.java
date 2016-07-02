package com.sr.resource;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sr.bo.StudentBO;
import com.sr.model.Student;

@Controller
@Scope("prototype")
public class StudentResource extends ServerResource{
	
	private Integer id;	
	
	@Autowired
	private StudentBO studentBO;
	
	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}

	@Override
	protected void doInit() throws ResourceException {
		id = Integer.valueOf((String) getRequestAttributes().get("studentId"));
	}
	
	@Get("json")
	public Student findStudentById(){
		Student s = this.studentBO.getStudent(id);
		return s;
	}
	
	@Delete("json")
	public Integer deleteStudentById() {
		return this.studentBO.removeStudent(id);
	}

	@Put("json")
	public Integer updateStudent(Student student) {
		student.setId(id);
		return this.studentBO.saveOrUpdateStudent(student);
	}
}
