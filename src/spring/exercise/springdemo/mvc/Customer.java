package spring.exercise.springdemo.mvc;

import javax.validation.constraints.*;

public class Customer {

	private String
		firstName;
	
	@NotNull(message="is required")
	@Size(min=1)
	private String
		lastName;

	
		
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}