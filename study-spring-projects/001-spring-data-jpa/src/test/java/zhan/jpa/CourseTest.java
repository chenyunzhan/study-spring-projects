package zhan.jpa;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhan.jpa.dao.CourseExtendsJpaSpecificationExecutor;
import zhan.jpa.pojo.Course;
import zhan.jpa.pojo.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CourseTest {
	
	@Autowired
	private CourseExtendsJpaSpecificationExecutor courseDao;
	
	@Test
	public void saveUser() {
		Course c1 = new Course();
		c1.setCourseName("c1");
		Course c2 = new Course();
		c2.setCourseName("c2");
		
		Student s1 = new Student();
		s1.setStudentName("s1");
		Student s2 = new Student();
		s2.setStudentName("s2");
		
		
		Set<Course> set1 = new HashSet<Course>();
		set1.add(c1);
		set1.add(c2);
		
		Set<Student> set2 = new HashSet<Student>();
		set2.add(s1);
		set2.add(s2);


		s1.setCourses(set1);
		c1.setStudents(set2);
		
		
		this.courseDao.save(c1);
	}
	
	
	@Test
	public void findCourse() {
		
		Course c = this.courseDao.findOne(3);
		System.out.println(c);
		System.out.println(c.getStudents());
		
		
	}
	

	
}
