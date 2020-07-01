//	@formatter:off

package hibernate.exercise.demo.entity;

import javax.persistence.*;

//	fields

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
		
//	constructors		

		public Instructor() {
		}

		public Instructor(String firstName, String lastName, String email/*, InstructorDetail instructorDetail*/) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			//	this.instructorDetail = instructorDetail; // this one will be linked manually
		}
		
//	getters & setters		
		
		public void setId(int id) {this.id = id;}
		public void setFirstName(String firstName) {this.firstName = firstName;}
		public void setLastName(String lastName) {this.lastName = lastName;}
		public void setEmail(String email) {this.email = email;}
		public void setInstructorDetail(InstructorDetail instructorDetail) {this.instructorDetail = instructorDetail;}
		
		public int getId() {return id;}
		public String getFirstName() {return firstName;}		
		public String getLastName() {return lastName;}
		public String getEmail() {return email;}
		public InstructorDetail getInstructorDetail() {return instructorDetail;}
		
//	overrides		

		@Override
		public String toString() {
			return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", instructorDetail=" + instructorDetail + "]";
		}
			
}

//	@formatter:on	