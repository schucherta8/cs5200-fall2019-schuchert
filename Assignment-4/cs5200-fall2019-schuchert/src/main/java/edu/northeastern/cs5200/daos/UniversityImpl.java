package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.CourseRepository;
import edu.northeastern.cs5200.repositories.EnrollmentRepository;
import edu.northeastern.cs5200.repositories.FacultyRepository;
import edu.northeastern.cs5200.repositories.SectionRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;
import edu.northeastern.cs5200.repositories.UserRepository;

@Repository
public class UniversityImpl implements UniversityDao {
	
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Override
	public void truncateDatabase() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
		courseRepository.deleteAll();
		sectionRepository.deleteAll();
		enrollmentRepository.deleteAll();
	}

	@Override
	public Faculty createFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		return facultyRepository.save(faculty);
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public Section createSection(Section section) {
		// TODO Auto-generated method stub
		return sectionRepository.save(section);
	}

	@Override
	public Course addSectionToCourse(Section section, Course course) {
		//Not adding section to Section to Course in DB
		Course courseRes = courseRepository.findById(course.getId()).get();
		courseRes.addSection(section);
		return courseRepository.save(courseRes);
	}

	@Override
	public Course setAuthorForCourse(Faculty faculty, Course course) {
		// TODO Auto-generated method stub
		Course courseRes = courseRepository.findById(course.getId()).get();
		courseRes.setAuthor(faculty);
		return courseRepository.save(courseRes);
	}

	@Override
	public Boolean enrollStudentInSection(Student student, Section section) {
		// TODO Auto-generated method stub
		if(section.getSeats() > 0) {
			Enrollment enrollee = new Enrollment(student,section);
			enrollmentRepository.save(enrollee);
			int seatsUpdate = section.getSeats() - 1;
			section.setSeats(seatsUpdate);
			sectionRepository.save(section);
			return true;
		}
		return false;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public List<Faculty> findAllFaculty() {
		// TODO Auto-generated method stub
		return (List<Faculty>) facultyRepository.findAll();
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public List<Section> findAllSections() {
		// TODO Auto-generated method stub	
		return (List<Section>) sectionRepository.findAll();
	}

	@Override
	public List<Course> findCoursesForAuthor(Faculty faculty) {
		// TODO Auto-generated method stub
		List<Course> coursesByAuthor = new ArrayList<>();
		List<Course> courses = (List<Course>) courseRepository.findAll();
		for(Course course : courses) {
			if(course.getAuthor().getId() == faculty.getId()) {
				coursesByAuthor.add(course);
			}
		}
		return coursesByAuthor;
	}

	@Override
	public List<Section> findSectionForCourse(Course course) {
		// TODO Auto-generated method stub
		List<Section> sectionsByCourse = new ArrayList<>();
		List<Section> sections = (List<Section>) sectionRepository.findAll();
		for(Section section : sections) {
			if(section.getCourse().getId() == course.getId()) {
				sectionsByCourse.add(section);
			}
		}
		return sectionsByCourse;
	}

	@Override
	public List<Student> findStudentsInSection(Section section) {
		// TODO Auto-generated method stub
		List<Student> studentsInSection = new ArrayList<>();
		List<Enrollment> enrollees = (List<Enrollment>) enrollmentRepository.findAll();
		for(Enrollment enrollee : enrollees) {
			if(enrollee.getSection().getId() == section.getId()) {
				studentsInSection.add(enrollee.getStudent());
			}
		}
		return studentsInSection;
	}

	@Override
	public List<Section> findSectionForStudents(Student student) {
		// TODO Auto-generated method stub
		List<Section> sectionsForStudent = new ArrayList<>();
		List<Enrollment> enrollees = (List<Enrollment>) enrollmentRepository.findAll();
		for(Enrollment enrollee : enrollees) {
			if(enrollee.getStudent().getId() == student.getId()) {
				sectionsForStudent.add(enrollee.getSection());
			}
		}
		return sectionsForStudent;
	}

}
