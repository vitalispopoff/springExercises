//	@formatter:off

package hibernate.exercise.demo.entity;

import javax.persistence.*;

//annotate the class as entity and map to db table

	@Entity
	@Table(name = "instructor_detail")
public class InstructorDetail {

//	define fields annotated w/ db column names

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

//	create constructors

	public InstructorDetail() {
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
//	generate getters & setters

	public String getYoutubeChannel() {return youtubeChannel;}
	public String getHobby() {return hobby;}
	
	public void setYoutubeChannel(String youtubeChannel) {this.youtubeChannel = youtubeChannel;}
	public void setHobby(String hobby) {this.hobby = hobby;	}

//	generate toString method
	
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
}
	
//	@formatter:on