// Employee abstract superclass.
public abstract class Employee{

	// Create the class instance variables
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;

	// Three-Argument constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber){
		this.firstName            = firstName;
		this.lastName             = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	} // end of constructor

	// Access instance data via public method to keep data hidden from client-side
	public String getFirstName(){
		return this.firstName;
	} // end of getFirstName

	public String getLastName(){
		return this.lastName;
	} // end of getLastName

	public String getSocialSecurityNumber(){
		return this.socialSecurityNumber;
	} // end of getSocialSecurityNumber

	// Override toString which we inherited from Object superclass which inherited as default
	// in case you have inherit from other classes
	// return String representation of Employee object
	@Override
	public String toString(){
		return String.format("%s %s%nsocial security number: %s", 
			 getFirstName(), getLastName(), getSocialSecurityNumber());
	} // end of toString
	/*
	Why did we decide to declare earnings as an abstract method? 
	It simply does not make  sense  to  provide  a  specific  implementation  of  this  method  
	in  class  Employee. 
	We cannot calculate the earnings for a general Employee we first must know the specific type of 
	Employee to determine the appropriate earnings calculation.
	*/

	// abstract method must be overridden by concrete subclasses
	// Each subclass overrides earnings with an appropriate implementation.
	public abstract double earnings();

} // end of abstract Employee class