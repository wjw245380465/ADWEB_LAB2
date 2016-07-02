package com.sr.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sr.model.Student;

@Service
@Scope("prototype")
public class StudentBO {

	private static Map<Integer, Student> students = new HashMap<Integer, Student>();

	// 保存下一个学生的Id
	private static int nextId = 5;

	// 初始化部分学生数据
	static {
		students.put(1, new Student(1, "Michael", 1, 18));
		students.put(2, new Student(2, "Anthony", 1, 22));
		students.put(3, new Student(3, "Isabella", 0, 19));
		students.put(4, new Student(4, "Aiden", 1, 20));
	}

	public Student getStudent(Integer id) {
		return students.get(id);
	}

	public List<Student> getStudentAll() {
		return new ArrayList<Student>(students.values());
	}

	public Integer saveOrUpdateStudent(Student student) {

		if (student.getId() == null) {
			student.setId(nextId++);
		}
		students.put(student.getId(), student);
		return student.getId();
	}

	public Integer removeStudent(Integer id) {
		students.remove(id);
		return id;
	}
}
