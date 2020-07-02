//	@formatter:off

package hibernate.exercise.demo.entity;

import javax.persistence.*;

	@Entity
	@Table(name = "instructor_detail")
public class InstructorDetail {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	private int 
		id;

		@Column(name = "youtube_channel")
	private String 
		youtubeChannel;

		@Column(name = "hobby")
	private String 
		hobby;

		@OneToOne(cascade = CascadeType.ALL, mappedBy="instructorDetail")	// mappedBy refers to the object class (InstructorDetail this) as a property in the field class ((Instructor instructor.instructorDetail)
	private Instructor 
		instructor;

//	constructors

	public InstructorDetail() {
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

//	getters & setters

	public int getId() {return id;}
	public String getYoutubeChannel() {return youtubeChannel;}
	public String getHobby() {return hobby;}
	public Instructor getInstructor() {return instructor;}
	
	public void setId(int id) {this.id = id;}
	public void setYoutubeChannel(String youtubeChannel) {this.youtubeChannel = youtubeChannel;}
	public void setHobby(String hobby) {this.hobby = hobby;	}
	public void setInstructor(Instructor instructor) {this.instructor = instructor;}

//	generate toString method
	
	@Override
	public String toString() {
		return "InstructorDetail [id=" 
				+ id 
				+ ", youtubeChannel=" 
				+ youtubeChannel 
				+ ", hobby=" 
				+ hobby 
//				+ ", instructor=" + instructor // these ain't to be listed in the bidirectional connection - feedback loop
				+ "]";
	}	
}
	
//	@formatter:on