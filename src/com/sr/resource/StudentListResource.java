package com.sr.resource;
import java.util.List;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.sr.bo.StudentBO;
import com.sr.model.Student;

@Controller
@Scope("prototype")
public class StudentListResource extends ServerResource {
	
	@Autowired
	private StudentBO studentBO;
	
	@Post
	public Integer saveStudent(Student student) {
		return studentBO.saveOrUpdateStudent(student);
	}
	
	@Get("json")
	public List<Student> findStudentAll() {
		return studentBO.getStudentAll();
	}
	
	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}

}
