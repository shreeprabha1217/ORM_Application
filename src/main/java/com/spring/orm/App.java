package com.spring.orm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//        Student student=new Student(1223,"Prabha","Puttur");
//        int r=studentDao.insert(student);
//        System.out.println("Done "+r);
         BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
         boolean f=true;
         while(f) {
         System.out.println("PRESS 1 for inserting values");
         System.out.println("PRESS 2 for displaying all the students");
         System.out.println("PRESS 3 for getting detail of a single student");
         System.out.println("PRESS 4 for deleting a student");
         System.out.println("PRESS 5 for updating student data");
         System.out.println("PRESS 6 to Exit");
         
         try {
        	 int choice=Integer.parseInt(bf.readLine());
        	 switch (choice) {
			case 1:
				System.out.println("Enter Student ID:");
                int id = Integer.parseInt(bf.readLine());
                System.out.println("Enter Student Name:");
                String name = bf.readLine();
                System.out.println("Enter Student City:");
                String city = bf.readLine();

                Student student = new Student(id, name, city);
                int r = studentDao.insert(student);
                System.out.println("Inserted student with ID: " + r);
                break;
			case 2:
				List<Student> students=studentDao.getAllStudents();
				for( Student s:students) {
					System.out.println(s);
				}
				break;
			case 3:
				System.out.println("Provide student Id");
				int c=Integer.parseInt(bf.readLine());
				Student s=studentDao.getStudent(c);
				System.out.println(s);
				break;
			case 4:
				System.out.println("Provide Student Id");
				int d=Integer.parseInt(bf.readLine());
				studentDao.deleteStudent(d);
				System.out.println("Deleted student with ID: " + d);
				break;
			case 5:
				System.out.println("Enter Student ID to update:");
                int updateId = Integer.parseInt(bf.readLine());
                System.out.println("Enter new Student Name:");
                String newName = bf.readLine();
                System.out.println("Enter new Student City:");
                String newCity = bf.readLine();

                Student updateStudent = new Student(updateId, newName, newCity);
                studentDao.updateStudent(updateStudent);
                System.out.println("Updated student with ID: " + updateId);
                break;
			case 6:
				f=false;
				break;
				
			}
        	 
         } catch (Exception e) {
        	 System.out.println("Invalid input try with another one!");
        	 System.out.println(e.getMessage());
         }
         }
         System.out.println("Thank You!!!");
        
    }
}
