//	@formatter:off

package code;

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

//	CRUD

	// create
	public void saveEmployee() {
		try {
			getSession().beginTransaction();
			session.save(this);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

	// read
	public static Employee retrieveEmployee(int id) {
		Employee 
			result = null;

		try {

			getSession().beginTransaction();
			result = session.get(Employee.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		return result;
	}

//	@formatter:on

	// update

	public static void updateEmployee(int id, String firstName, String lastName, String company) {
		Employee result;

		try {
			getSession().beginTransaction();
			result = session.get(Employee.class, id);

			if (firstName != null) {
				result.setFirstName(firstName);
			}
			if (lastName != null) {
				result.setLastName(lastName);
			}
			if (company != null) {
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

	// delete
	public void deleteEntity() {
		try {
			getSession().beginTransaction();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		System.out.println("...factory class : "+factory.getClass());
		return factory;
	}

	private static void setSession() {
		session = getFactory().getCurrentSession();
		System.out.println("...session class : "+session.getClass());
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
