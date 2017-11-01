package com.ihtc.service;

import java.util.List;

import com.ihtc.bean.Student;

public interface StudentService {

	boolean myInsert(Student student);
	List<Student> selectAll();
	void update(Student student);
	Student findById(Integer sid);
	void myDelete(Student student);
	
}
