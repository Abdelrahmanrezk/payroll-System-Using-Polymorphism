
/*
To test our Employee hierarchy, the application creates an object of each of the four concrete classes
SalariedEmployee, HourlyEmployee, CommissionEmployee and Base-PlusCommissionEmployee. 
The program manipulates these objects non-polymorphically, via variables of each object’s own type,
then polymorphically, using an array of Employee variables. 
While processing the objects polymorphically, the program increases the base salary of each
 BasePlusCommissionEmployee by 10%—this requires determining the object’s type at execution time.
 Finally, the program polymorphically determines and outputs the type of each object in the Employee array. 
 then create objects of each of the four concrete Employee subclasses. 
 output the String representation and earnings of each of these objects non-polymorphically. 
 Each object’s toString method is called implicitly by printf when the object is output as a String
 with the %s format specifier.
*/

// Employee hierarchy test program. 
public class PayrollSystemTest{
	public static void main(String[] args){
		// create subclass objects
		SalariedEmployee salariedEmployee = 
			new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee =  
			new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee = 
			new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = 
			new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);  

		System.out.println("Employees processed individually:(non-polymorphically)");
		
		// toString method are called implicity
		System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned", 
			basePlusCommissionEmployee.earnings());

		// create four-element Employee array
		Employee [] employees = new Employee[4];

		// assign subclass references to superclass variables (can not doing vise-vers)
		// Direct relationship
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		// Indirect relationship
		employees[3] = basePlusCommissionEmployee;

		System.out.printf("Employees processed polymorphically:%n%n");
		// generically process each element in array employees
		for(Employees currentEmployee: employees){
			System.out.println(currentEmployee); // invokes toString implicity
			// determine whether element is a BasePlusCommissionEmployee
			if(currentEmployee instanceof BasePlusCommissionEmployee){
				// downcast Employee reference to 
				// BasePlusCommissionEmployee reference
				 BasePlusCommissionEmployee employee = 
				 (BasePlusCommissionEmployee) currentEmployee;
				 employee.setBaseSalary(1.10 * employee.getBaseSalary());

			 	System.out.printf("new base salary with 10%% increase is: $%,.2f%n", 
			 		employee.getBaseSalary());
			}

			 System.out.printf(64"earned $%,.2f%n%n", currentEmployee.earnings());

		} // end of loop
		
		// get type name of each object in employees array
		for (int j = 0; j < employees.length; j++){
			System.out.printf("Employee %d is a %s%n", j, 
				employees[j].getClass().getName()); 
		} // end of loop

	} // end of main method	
} // end of PayrollSystemTest class