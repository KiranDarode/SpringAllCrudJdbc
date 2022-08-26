package com.springJdbc;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.*;

public class StudentImpl implements StudentDao {

	static ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
	static JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
Scanner sc=new Scanner(System.in);

	public boolean insertDaio(Student st) {
		boolean flag=false;
		int id=st.getId();
		String name=st.getName();
		String city=st.getCity();
		
		String s="insert into student(id,name,city) values(?,?,?)";
		
		template.update(s,id,name,city);
		flag=true;
		
		return flag;
		
		
	}


	public boolean updateDaio(Student st) {
		boolean flag = false;
		System.out.println("Enter your name:");
		String name=sc.nextLine();
		System.out.println("Enter your city:");
		String city=sc.nextLine();
		 String q1 = "update student set name=?, city=? where id=?";
		 template.update(q1,name,city,st.getId() );
		 
		flag = true;
		return flag;
		
	}


	public boolean DeleteDaio(Student st) {
		boolean flag=false;
		int id=st.getId();
		String q= "delete from student where id=?";
		template.update(q,id);
		
		flag= true;
		
		return flag;
		
	}


	public Student GetStudent(int id) {
		// single studetn.
		System.out.println(id);
		
		String 	q="select * from student where id=?";
		 RowMapper<Student> rowMapper =new rowMapperImple();
	   
		Student student= template.queryForObject(q, rowMapper, id);
		System.out.println(student);
		return student;
	}


	public List<Student> getAllStudents() {
		String q="select * from student";
		List<Student> student=template.query(q,new rowMapperImple());
		
		return student;
	}
		

	

}
