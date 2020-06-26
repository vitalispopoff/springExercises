package spring.exercise.springdemo.mvc;

import javax.validation.constraints.*;

public class Customer {

	private String firstName;

	@NotNull(message = "Field required")
	@Size(min = 1, message = "Field required")
	private String lastName;
	
	@Pattern(regexp = "^[0-9]{5}", message = "exactly 5 digits")
	private String postalCode;

	@NotNull(message = "Field required")
	@Min(value = 0, message = "Write a positive value")
	@Max(value = 10, message = "Write a value not greater than 10")
	private Integer freePasses;

	//	@formatter:off
	
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}	
	public String getPostalCode() {return postalCode;}	
	public Integer getFreePasses() {return freePasses;}	
	
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setFreePasses(Integer freePasses) {this.freePasses = freePasses;}
	public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

	//	@formatter:on		
}