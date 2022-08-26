package com.springJdbc;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.common.TemplateAwareExpressionParser;
import org.springframework.jdbc.core.JdbcTemplate;

public interface StudentDao  {

	public  boolean insertDaio(Student st);
   
	public boolean updateDaio(Student st) ;
	
	public boolean DeleteDaio(Student st);
  
	 public Student GetStudent(int id);

	public List<Student> getAllStudents();
}
