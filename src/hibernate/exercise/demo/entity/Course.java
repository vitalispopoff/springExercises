//	@formatter:off

package hibernate.exercise.demo.entity;

import javax.persistence.*;

	@Entity
	@Table(name="course")
public class Course {
	
//	fields
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
	private int 
		id;
		
		@Column(name="title")
	private String
		title;
	
		@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})		// we don't want to have REMOVE
		@JoinColumn(name="instructor_id")
	private Instructor
		instructor;
	
//	constructors
	
	public Course() {}

	public Course(String title) {
		this.title = title;
	}
	
//	getters & setters

	public void setId(int id) {this.id = id;}
	public int getId() {return id;}
	

	public void setTitle(String title) {this.title = title;}	
	public String getTitle() {return title;}
	

	public void setInstructor(Instructor instructor) {this.instructor = instructor;}
	public Instructor getInstructor() {return instructor;}
	
//	overrides
	
	@Override
	public String toString() {		
		return new StringBuilder()
					.append("Course={")
					.append("id=")
					.append(id)
					.append(", title='")
					.append(title)
					.append("'")
					.append(", instructor=")
					.append(instructor.getId())
					.append("}")
					.toString();
				
//		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor.getId() + "]";
	}
}
	
//	@formatter:on