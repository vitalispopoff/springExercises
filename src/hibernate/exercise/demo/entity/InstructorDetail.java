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

		@OneToOne(mappedBy="instructorDetail", 
					cascade = {
								CascadeType.DETACH,
								CascadeType.MERGE,
								CascadeType.PERSIST,
								CascadeType.REFRESH
							})	// no problem in adding more options, problem in reading them later
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
				+ ", instructor=" + instructor // these ain't to be listed in the bidirectional connection - feedback loop
				+ "]";
	}	
}
	
//	@formatter:on