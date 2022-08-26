package com.springJdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class App {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");


		StudentDao dao = new StudentImpl();
		
		while (true) 
		{
			System.out.println("===========================");
			System.out.println("1.insert");
			System.out.println("2.update");
			System.out.println("3.delete");
			System.out.println("4.display Single data");
			System.out.println("5.display All");
			System.out.println("6.exit");
			System.out.print("plz enter somthing  :>");

			int c = Integer.parseInt(bf.readLine());
			if (c == 1) {
				System.out.println("Enter the student id:");
				int id = Integer.parseInt(bf.readLine());
				System.out.println("Enter the student name :");
				String name = bf.readLine();
				System.out.println("enter the student city name:");
				String city = bf.readLine();
				Student st = new Student(id,name,city);
                    System.out.println(st);
				boolean ans = dao.insertDaio(st);
				

				if (ans == true) {
					System.out.println("data is inserted scccsessfully" + st);
				} else {

					System.out.println("data is not inserted");
				}

			} else if (c == 2) {
				System.out.println("enter the id which to update:");
				int id = Integer.parseInt(bf.readLine());
			
				Student st=new Student(id);
				boolean a=dao.updateDaio(st);

				if(a==true) {
					System.out.println("data is updated successfully");
				}
				else {
					System.out.println("somthing is wrong data is not updated");
				}

			} else if (c == 3) {
				
				System.out.println("enter your id which data to delete you:");
				
				int id = Integer.parseInt(bf.readLine());
				Student st=new Student(id);
				boolean a=dao.DeleteDaio(st);

				if(a==true) {
					System.out.println("data is deleted successfully");
				}
				else {
					System.out.println("somthing is wrong data is not deleted");
				}
				

			} else if (c == 4) {
				
				System.out.println("enter id to which data to diplay:");
				int id = Integer.parseInt(bf.readLine());
				  dao.GetStudent( id);
				System.out.println("data is:");

			}else if(c==5) {
				// display all
				List<Student> allStudents = dao.getAllStudents();
				for(Student s:allStudents) {
					System.out.println(s);
				}
				
			}
			
			else if (c == 6) {
                     System.out.println("your are exited succsesfully");
                     System.exit(1);
			}

		}

	}
}
