package code;

public class Main {
	
	static void addEmployee() {
		Employee
			emplo1 = new Employee("Paul", "Rubens", "Softporn Arts Ltd");
		emplo1.saveEmployee();		
	}
	
	static void updateEmployee(int i) {
		Employee
			temporal = Employee.retrieveEmployee(i);
		System.out.println(temporal);
	
		//	temporal.updateEmployee(null, null, null);
	}

	public static void main(String[] args) {
		
		Employee
			temp = Employee.retrieveEmployee(1);
		int
			index = temp.getId();
		
//		System.out.println(index);
		
//		Employee.updateEmployee(1, null, null, "");
		
//		addEmployee();
				
//		System.out.println(Employee.retrieveEmployee(1));
		

		
		
	
	}
}