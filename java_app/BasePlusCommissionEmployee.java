// Indirect relation with Employee and dierct with CommissionEmployee
// Concrete Subclass BasePlusCommissionEmployee
// BasePlusCommissionEmployee class extends CommissionEmployee.
public class BasePlusCommissionEmployee extends CommissionEmployee{

	private double baseSalary; // base salary per week

	// six-Argument constructor 5 from superclass and 1 of this class 
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
		double grossSales, double commissionRate, double baseSalary){

		// Call superclass constructor
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

		// if baseSalary is invalid throw exception
		if(baseSalary < 0){
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
	} // end of constructor

	public void setBaseSalary(double baseSalary){
		if(baseSalary < 0){
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
	
	} // end of setBaseSalary

	public double getBaseSalary(){
		return this.baseSalary;
	} // end of getBaseSalary

	// calculate earnings; override method earnings in CommissionEmployee
	@Override
	public double earnings(){
		return super.earnings() + getBaseSalary();
	} // end of earnings

	@Override
	public String toString(){
		return String.format("%s %s; %s: $%,.2f",
			"base-salaried", super.toString(), 
			"base salary", getBaseSalary());
	} // end of toString
	
} // end of BasePlusCommissionEmployee class