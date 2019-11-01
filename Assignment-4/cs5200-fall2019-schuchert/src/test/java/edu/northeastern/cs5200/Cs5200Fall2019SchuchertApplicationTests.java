package edu.northeastern.cs5200;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.daos.UniversityImpl;
import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.models.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cs5200Fall2019SchuchertApplicationTests {

	private static boolean setUpComplete = false;
	
	static Faculty alan = new Faculty("Alan","Turin","alan","password","123A",true);
	static Faculty ada = new Faculty("Ada","Lovelace","ada","password","123B",true);
	static Student alice = new Student("Alice","Wonderland","alice","password",2020,12000L);
	static Student bob = new Student("Bob","Hope","bob","password",2021,23000L);
	static Student charlie = new Student("Charlie","Brown","charlie","password",2019,21000L);
	static Student dan = new Student("Dan","Craig","dan","password",2019,0L);
	static Student edward = new Student("Edward","Scissorhands","edward","password",2022,11000L);
	static Student frank = new Student("Frank","Herbert","frank","password",2018,0L);
	static Student gregory = new Student("Gregory","Peck","gregory","password",2023,10000L);
	static Course cs1234 = new Course("CS1234");
	static Course cs2345 = new Course("CS2345");
	static Course cs3456 = new Course("CS3456");
	static Course cs4567 = new Course("CS4567");
	static Section sec4321 = new Section("SEC4321",50);
	static Section sec5432 = new Section("SEC5432",50);
	static Section sec6543 = new Section("SEC6543",50);
	static Section sec7654 = new Section("SEC7654",50);
	
	@Autowired
	UniversityImpl universityDao;
	
	//Only run database setup once
	@Before
	public void setUp() {
		if(!setUpComplete) {
			universityDao.truncateDatabase();
			universityDao.createFaculty(alan);
			universityDao.createFaculty(ada);
			universityDao.createStudent(alice);
			universityDao.createStudent(bob);
			universityDao.createStudent(charlie);
			universityDao.createStudent(dan);
			universityDao.createStudent(edward);
			universityDao.createStudent(frank);
			universityDao.createStudent(gregory);
			universityDao.createCourse(cs1234);
			universityDao.createCourse(cs2345);
			universityDao.createCourse(cs3456);
			universityDao.createCourse(cs4567);
			universityDao.createSection(sec4321);
			universityDao.createSection(sec5432);
			universityDao.createSection(sec6543);
			universityDao.createSection(sec7654);
			universityDao.setAuthorForCourse(alan, cs1234);
			universityDao.setAuthorForCourse(alan, cs2345);
			universityDao.setAuthorForCourse(ada, cs3456);
			universityDao.setAuthorForCourse(ada, cs4567);
			universityDao.addSectionToCourse(sec4321, cs1234);
			universityDao.addSectionToCourse(sec5432, cs1234);
			universityDao.addSectionToCourse(sec6543, cs2345);
			universityDao.addSectionToCourse(sec7654, cs3456);
			setUpComplete = true;
		}
	}
	@Test
	public void testNumberOfUsers() {
		List<User> users = universityDao.findAllUsers();
		int res = users.size();
		assertEquals(9,res);
	}
	
	@Test
	public void testNumberOfFaculties() {
		List<Faculty> faculties = universityDao.findAllFaculty();
		int res = faculties.size();
		assertEquals(2,res);
	}
	
	@Test
	public void testNumberOfStudents() {
		List<Student> students = universityDao.findAllStudents();
		int res = students.size();
		assertEquals(7,res);
	}
	
	@Test
	public void testNumberOfCourses() {
		List<Course> courses = universityDao.findAllCourses();
		int res = courses.size();
		assertEquals(4,res);
	}
	
	@Test
	public void testNumberOfSections() {
		List<Section> sections = universityDao.findAllSections();
		int res = sections.size();
		assertEquals(4,res);
	}
	@Test//Do this for all authors
	public void testFindCoursesForAuthor() {
		List<Course> alanCourses = universityDao.findCoursesForAuthor(alan);
		int res = alanCourses.size();
		assertEquals(2,res);
	}
	
	@Test//Do this for all courses
	public void testFindSectionsForCourse() {
		List<Section> cs1234Sections = universityDao.findSectionForCourse(cs1234);
		int res = cs1234Sections.size();
		assertEquals(2,res);
	}
	
}

