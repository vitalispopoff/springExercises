//	@formatter:off

package code;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

	@Entity
	@Table(name = "employee")
public class Employee {

	private static String 
		configFile = "hibernate.cfg.xml"
	;
	private static SessionFactory 
		factory
	;
	private static Session 
		session
	;
	private static Configuration 
		config = new Configuration().configure(configFile)
	;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	private int 
		id
	;
		@Column(name = "first_name")
	private String 
		firstName
	;
		@Column(name = "last_name")
	private String 
		lastName
	;
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
	
	public static void resetConnection() {
		factory = null;
		session = null;
		config = null;
		config = new Configuration().configure(configFile);
	}

//	CRUD

	// create
	public void saveEmployee() {
		try {
			getSession().beginTransaction();
			session.save(this);
			session.getTransaction().commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
			factory.close();
		}
	}

	// read
	public static Employee retrieveEmployee(int id) {
		Employee 
			result;
		try {
			getSession().beginTransaction();
			result = session.get(Employee.class, id);
			session.getTransaction().commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
			 result = new Employee();
		} 
		finally {
			session.close();
			factory.close();
		}
		return result;
	}
	
	//	find
	public static List<Employee> findEmployee(String company) {
		List<Employee>
			result;
		String
			query = "from Employee s where company='".concat(company).concat("'");
		
		try {
			getSession().beginTransaction();
			result = session.createQuery(query).getResultList();			
		}
		catch(Exception e) {
			e.printStackTrace();
			result = new ArrayList<Employee>();
			}
		finally {
			session.close();
			factory.close();
		}
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
				getSession().beginTransaction();
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
				session.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				factory.close();
			}
		}
	}
	
	// delete
	public static void deleteEntity(int id) {
		Employee
			temporal;
		
		try {
			getSession().beginTransaction();
			temporal = session.get(Employee.class, id);
			
			session.delete(temporal);
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
		
//	getters & setters

	private static void setFactory() {
		factory = config.addAnnotatedClass(Employee.class).buildSessionFactory();
	}

	private static SessionFactory getFactory() {
		if (factory == null)
			setFactory();
		System.out.println("...factory class : " + factory.getClass());
		return factory;
	}

	private static void setSession() {
		session = getFactory().getCurrentSession();
		System.out.println("...session class : " + session.getClass());
	}

	private static Session getSession() {
		if (session == null)
			setSession();
		return session;
	}

	public int getId() {
		return id;
	}

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

//	@overrides	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ "]";
	}
}

//	@formatter:on