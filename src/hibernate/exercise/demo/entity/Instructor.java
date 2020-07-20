//	@formatter:off

package hibernate.exercise.demo.entity;

import java.util.*;

import javax.persistence.*;

	@Entity
	@Table(name="instructor")
public class Instructor {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	private int
		id;

		@Column(name = "first_name")	
	private String
		firstName;

		@Column(name="last_name")
	private String
		lastName;

		//	nice to have a proper format forced
		@Column(name="email")
	private String
		email;

		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="instructor_detail_id")		
	private InstructorDetail
		instructorDetail;
		
		@OneToMany(fetch=FetchType.LAZY, 
					mappedBy="instructor", 
					cascade= {CascadeType.PERSIST, 
								CascadeType.MERGE, 
								CascadeType.DETACH, 
								CascadeType.REFRESH})			// we don't want to cascade delete
	private List<Course> 
		courses;

//	constructors		

	public Instructor() {}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

//	getters & setters		

	public void setId(int id) {this.id = id;}
	public int getId() {return id;}
	
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public String getFirstName() {return firstName;}
	
	public void setLastName(String lastName) {this.lastName = lastName;}
	public String getLastName() {return lastName;}
	
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	
	public void setInstructorDetail(InstructorDetail instructorDetail) {this.instructorDetail = instructorDetail;}
	public InstructorDetail getInstructorDetail() {return instructorDetail;}
	
	public void setCourses(List<Course> courses) {this.courses= courses;}	
	public List<Course> getCourses() {return courses;}
																	//	convenience methods for bidirectional relationship
	public void add(Course tempCourse) {
		if (courses == null) courses = new ArrayList<>();
		
		courses.add(tempCourse);									// 	adding a course to the instructor's course list
		tempCourse.setInstructor(this);								//	adding an instructor to the listed course
	}																
	
//	overrides		

		@Override
	public String toString() {
		return "Instructor [id=" 
				+ id 
				+ ", firstName=" 
				+ firstName 
				+ ", lastName=" 
				+ lastName 
				+ ", email=" 
				+ email
				+ ", instructorDetail=" 
				+ (instructorDetail == null ? "null" : instructorDetail.getId())	// null causes NullPointerException - who would have thought?
				+ "]";
		}
}

//	@formatter:on	