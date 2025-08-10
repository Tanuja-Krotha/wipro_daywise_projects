package com.wipro.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.model.College;
import com.wipro.model.Department;
import com.wipro.model.Mobile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
    	Department dept=  ctx.getBean(Department.class);
     	dept.setDepartmentName("Finance");
     	dept.setDeptCode("Fin");
     	System.out.println(dept);
     	
     	
     	ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
     	College college= ctx.getBean(College.class);	
		System.out.println(college);*/
    	AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(App.class);
		//ctx.refresh();
		ctx.scan("com.wipro.model.Mobile");		
//		Room room=ctx.getBean(Room.class);
//		System.out.println(room);
		Mobile mob= ctx.getBean(Mobile.class);
		System.out.println(mob.display);
		
		
    }
}
