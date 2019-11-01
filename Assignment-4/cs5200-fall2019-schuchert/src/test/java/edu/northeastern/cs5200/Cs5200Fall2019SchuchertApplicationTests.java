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
			universityDao.enrollStudentInSection(alice, sec4321);
			universityDao.enrollStudentInSection(alice, sec5432);
			universityDao.enrollStudentInSection(bob, sec5432);
			universityDao.enrollStudentInSection(charlie, sec6543);
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
	@Test
	public void testFindCoursesForAuthorAlan() {
		List<Course> alanCourses = universityDao.findCoursesForAuthor(alan);
		int res = alanCourses.size();
		assertEquals(2,res);
	}
	
	@Test
	public void testFindCoursesForAuthorAda() {
		List<Course> adaCourses = universityDao.findCoursesForAuthor(ada);
		int res = adaCourses.size();
		assertEquals(2,res);
	}
	
	@Test
	public void testFindSectionsForCourseCS1234() {
		List<Section> cs1234Sections = universityDao.findSectionForCourse(cs1234);
		int res = cs1234Sections.size();
		assertEquals(2,res);
	}
	
	@Test
	public void testFindSectionsForCourseCS2345() {
		List<Section> cs2345Sections = universityDao.findSectionForCourse(cs2345);
		int res = cs2345Sections.size();
		assertEquals(1,res);
	}
	
	@Test
	public void testFindSectionsForCourseCS3456() {
		List<Section> cs3456Sections = universityDao.findSectionForCourse(cs3456);
		int res = cs3456Sections.size();
		assertEquals(1,res);
	}
	
	@Test
	public void testFindSectionsForCourseCS4567() {
		List<Section> cs4567Sections = universityDao.findSectionForCourse(cs4567);
		int res = cs4567Sections.size();
		assertEquals(0,res);
	}
	
	@Test
	public void testNumberOfStudentsInSection4321() {
		List<Student> studentsInSec4321 = universityDao.findStudentsInSection(sec4321);
		int res = studentsInSec4321.size();
		assertEquals(1,res);
	}
	@Test
	public void testNumberOfStudentsInSection5432() {
		List<Student> studentsInSec5432 = universityDao.findStudentsInSection(sec5432);
		int res = studentsInSec5432.size();
		assertEquals(2,res);
	}
	@Test
	public void testNumberOfStudentsInSection6543() {
		List<Student> studentsInSec6543 = universityDao.findStudentsInSection(sec6543);
		int res = studentsInSec6543.size();
		assertEquals(1,res);
	}
	@Test
	public void testNumberOfStudentsInSection7654() {
		List<Student> studentsInSec7654 = universityDao.findStudentsInSection(sec7654);
		int res = studentsInSec7654.size();
		assertEquals(0,res);
	}
	@Test
	public void testNumberOfSectionsForStudentAlice() {
		List<Section> sectionsForAlice = universityDao.findSectionForStudents(alice);
		int res = sectionsForAlice.size();
		assertEquals(2,res);
	}
	@Test
	public void testNumberOfSectionsForStudentBob() {
		List<Section> sectionsForBob = universityDao.findSectionForStudents(bob);
		int res = sectionsForBob.size();
		assertEquals(1,res);
	}
	@Test
	public void testNumberOfSectionsForStudentCharlie() {
		List<Section> sectionsForCharlie = universityDao.findSectionForStudents(charlie);
		int res = sectionsForCharlie.size();
		assertEquals(1,res);
	}
	@Test
	public void testNumberOfSectionsForStudentDan() {
		List<Section> sectionsForDan = universityDao.findSectionForStudents(dan);
		int res = sectionsForDan.size();
		assertEquals(0,res);
	}
	@Test
	public void testNumberOfSectionsForStudentEdward() {
		List<Section> sectionsForEdward = universityDao.findSectionForStudents(edward);
		int res = sectionsForEdward.size();
		assertEquals(0,res);
	}
	@Test
	public void testNumberOfSectionsForStudentFrank() {
		List<Section> sectionsForFrank = universityDao.findSectionForStudents(frank);
		int res = sectionsForFrank.size();
		assertEquals(0,res);
	}
	@Test
	public void testNumberOfSectionsForStudentGregory() {
		List<Section> sectionsForGregory = universityDao.findSectionForStudents(gregory);
		int res = sectionsForGregory.size();
		assertEquals(0,res);
	}
	@Test
	public void testNumberOfSeatsInSection4321() {
		int res = sec4321.getSeats();
		assertEquals(49,res);
	}
	@Test
	public void testNumberOfSeatsInSection5432() {
		int res = sec5432.getSeats();
		assertEquals(48,res);
	}
	@Test
	public void testNumberOfSeatsInSection6543() {
		int res = sec6543.getSeats();
		assertEquals(49,res);
	}
	@Test
	public void testNumberOfSeatsInSection7654() {
		int res = sec7654.getSeats();
		assertEquals(50,res);
	}
}

