//	@formatter:off

package spring.exercise.demo.entity;

import javax.persistence.*;

	@Entity
	@Table(name="student")
public class Student {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
	private int
		id;
	
		@Column(name="first_name")
	private String
		firstName;
	
		@Column(name="last_name")
	private String
		lastName;
	
		@Column(name="email")
	private String
		email;
		
//	constructors 

	public Student() {}

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
//	getters & setters

	public int getId() {return id;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getEmail() {return email;}

	public void setId(int id) {this.id = id;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setEmail(String email) {this.email = email;}

//	overrides	
	
		@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
	
//	@formatter:on	