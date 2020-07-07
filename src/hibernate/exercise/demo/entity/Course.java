package hibernate.exercise.demo.entity;

import javax.persistence.*;

	@Entity
	@Table(name="course")
public class Course {
	
//	fields
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column
	private int 
		id;
	
	private String
		title;
	
	private int
		instructor_id;
	
//	constructors
	
	
	
//	getters & setters
	
}