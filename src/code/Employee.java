//	@formatter:off

package code;

import static code.ConnectionProcedure.*;

import java.util.*;

import javax.persistence.*;



	@Entity
	@Table(name = "employee")
public class Employee {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	private int 
		id;
		
		@Column(name = "first_name")
	private String 
		firstName;
		
		@Column(name = "last_name")
	private String 
		lastName;
		
		@Column(name = "company")
	private String 
		company;

//	constructors		

	public Employee() {
	}
		
	public Employee(String firstName, String lastName, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		
	}
	
//	methods

//	CRUD

	// create
	public void saveEmployee() {
		try {
			initializing();
			
			session.save(this);

			finalizing();
		} 
		catch (Exception e) {e.printStackTrace();} 
		finally {terminating();}
	}

	// read
	public static Employee retrieveEmployee(int id) {
		Employee 
			result;
		
		try {
			initializing();

			result = session.get(Employee.class, id);

			finalizing();
		} 
		catch (Exception e) {
			e.printStackTrace();
			 result = null;
		} 
		finally {terminating();}
		return result;
	}
	
	//	find
	
	public static List<Employee> findEmployee(String company) {
		List<Employee>
			result;
		String
			query = "from Employee s where company='".concat(company).concat("'");
		
		try {
			initializing();
			
			result = session.createQuery(query).getResultList();
			
			finalizing();
		}
		catch(Exception e) {
			e.printStackTrace();
			result = null;
		}
		finally {terminating();}
		return result;
	}

	// update

	public static void updateEmployee(int id, String firstName, String lastName, String company) {
		Employee 
			result;
		boolean 
			firstNameNotNull = firstName != null, 
			lastNameNotNull = lastName != null,
			companyNotNull = company != null;

		if (firstNameNotNull && lastNameNotNull && companyNotNull && id > 0) {
			try {
				initializing();

				result = session.get(Employee.class, id);

				if (firstNameNotNull) {
					result.setFirstName(firstName);
				}
				if (lastNameNotNull) {
					result.setLastName(lastName);
				}
				if (companyNotNull) {
					result.setCompany(company);
				}
					
				finalizing();

			} catch (Exception e) {	e.printStackTrace(); }
			finally {terminating();}
		}
	}
	
	// delete
	
	public static void deleteEntity(int id) {
		Employee
			temporal;
		
		try {
			initializing();
			
			temporal = session.get(Employee.class, id);
			
			session.delete(temporal);
			
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
	}
		
//	getters & setters

	public int getId() {return id;}
	
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}

	
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}

	
	public String getCompany() {return company;}
	public void setCompany(String company) {this.company = company;}

//	@overrides	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ "]";
	}
}

//	@formatter:on	