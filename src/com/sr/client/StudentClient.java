package com.sr.client;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.sr.model.Student;

public class StudentClient {
	
	public void student_get(){
		try {
			ClientResource client = new ClientResource("http://127.0.0.1:8888/SpringRestlet/student/1");
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void student_delete() {
		try {
			ClientResource client = new ClientResource("http://127.0.0.1:8888/SpringRestlet/student/1");
			Representation representation = client.delete();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void student_put(){
		try {
			ClientResource client = new ClientResource("http://127.0.0.1:8888/SpringRestlet/student/1");
			Student student = new Student("Test_Put", 1, 18);
			Representation representation = client.put(student, MediaType.APPLICATION_JAVA_OBJECT);
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void student_post(){
		try {
			ClientResource client = new ClientResource("http://127.0.0.1:8888/SpringRestlet/student");
			Student student = new Student("Test_Post", 1, 18);
			Representation representation = client.post(student, MediaType.APPLICATION_JAVA_OBJECT);
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void student_findAll(){
		try {
			ClientResource client = new ClientResource("http://127.0.0.1:8888/SpringRestlet/student");
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		StudentClient client =  new  StudentClient();
		client.student_get();	
	}
}
