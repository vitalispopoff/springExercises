package spring.exercise.springdemo.mvc;

import javax.validation.constraints.*;

public class Customer {

	private String
		firstName;
	
	@NotNull(message="field required")
	@Size(min=1, message="field required")
	private String
		lastName;
		
	@NotNull(message="field required")
	@Min(value=0, message="must be a positive value")
	@Max(value=10, message="mustn't be greater than 10")
	private Integer 
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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	
	
}