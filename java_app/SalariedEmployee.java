// SalariedEmployee concrete class extends abstract class Employee.
public class SalariedEmployee extends Employee{

	private double weeklySalary;

	// Four-Argument constructor 3 from superclass and 1 of this class
	public SalariedEmployee(String firstName, String lastName, 
		String socialSecurityNumber, double weeklySalary){

		// Call superclass constructor
		super(firstName, lastName, socialSecurityNumber);

		if(weeklySalary < 0){
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}

		this.weeklySalary = weeklySalary;
	} // end of constructor

	public void setWeeklySalary(double weeklySalary){
		if(weeklySalary < 0){
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}

		this.weeklySalary = weeklySalary;
	} // end of setWeeklySalary

	public double getWeeklySalary(){
 		return this.weeklySalary;
	} // end of getWeeklySalary

	// calculate earnings; override abstract method earnings in Employee abstract class
	@Override
	public double earnings(){
		return getWeeklySalary();
	} // end of earnings

	@Override
	public String toString(){
		return String.format("salaried employee: %s%n%s: $%,.2f",
			super.toString(),
			 "weekly salary", getWeeklySalary());
	} // end of toString

} // end of SalariedEmployee class