package spring.exercise.springdemo.mvc;

import javax.validation.constraints.*;

public class Customer {

	private String
		firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String
		lastName;
		
	@Min(value=0, message="must be a positive value")
	@Max(value=10, message="mustn't be greater than 10")
	private int 
		freePasses;
	

	@Pattern(regexp="^[0-9]{5}", message="exactly 5 digits")
	private String 
		postalCode;
	

	
	public Customer() {}
	
	
		
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

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	
	
}