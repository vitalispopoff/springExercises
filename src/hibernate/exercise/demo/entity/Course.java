//	@formatter:off

package hibernate.exercise.demo.entity;

import java.util.*;

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
		
		
		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name="course_id")
	private List<Review>
		reviews;
	
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

	
	public List<Review> getReviews() {return reviews;}
	public void setReviews(List<Review> reviews) {this.reviews = reviews;}
	
	public void addReview(Review review) {
		if(reviews == null) reviews = new ArrayList<>();
		reviews.add(review);
	}
	
//	overrides

	@Override
	public String toString() {
		
		String instructorInfo = instructor == null ? "none" : Integer.toString(instructor.getId()); 
			
		return new StringBuilder()
					.append("Course={")
					.append("id=")
					.append(id)
					.append(", title='")
					.append(title)
					.append("'")
					.append(", instructor=")
					.append(instructorInfo)
					.append("}")
					.toString();
				
//		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor.getId() + "]";
	}	 	
}
	
//	@formatter:on