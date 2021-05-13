// HourlyEmployee concrete class extends Employee.
public class HourlyEmployee extends Employee{

	private double wage; // Hour price
	private double hours;
	// Five-Argument constructor 3 from superclass and 2 of this class
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,
		double wage, double hours){

		// Call superclass constructor
		super(firstName, lastName, socialSecurityNumber);

		 // validate wage
		if(wage < 0){
			throw new IllegalArgumentException( "Hourly wage must be >= 0.0");
		}

		 // validate hours
		if(hours < 0 || hours > 168){
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		// Once there is no errors assign constructor argument to instance variables
		this.wage  = wage;
		this.hours = hours;

	} // end of constructor

	public void setWage(double wage){
		 // validate wage argument
		if(wage < 0){
			throw new IllegalArgumentException( "Hourly wage must be >= 0.0");
		}

		this.wage = wage;
	} // end of setWage

	public double getWage(){
		return this.wage;
	} // end of getWage

	public void setHours(double hours){
		 // validate hours
		if(hours < 0 || hours > 168){
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		this.hours = hours;
	} // end of setHours

	public double getHours(){
		return this.hours;
	} // end of getHours

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings(){
		if (getHours() <= 40) { // there is no overtime that employeed work
			// number of hours that employeed worked * price per hour
			return getWage() * getHours();
		} else 
		{
			// if there is overtime
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
		}

	} // end of earnings

	// return String representation of HourlyEmployee object 
	@Override
	public String toString(){
		return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
			super.toString(), 
			"hourly wage", getWage(), 
			"hours worked", getHours());
	} // end of toString
	
} // end of HourlyEmployee class