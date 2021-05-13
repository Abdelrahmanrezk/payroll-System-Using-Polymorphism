// CommissionEmployee class extends Employee.
public class CommissionEmployee extends Employee{
	private double grossSales; // gross weekly sales
	private double commissionRate;// commission percentage

	// Five-Argument constructor 3 from superclass and 2 of this class

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
		double grossSales, double commissionRate){

		// Call superclass constructor
		super(firstName, lastName, socialSecurityNumber);

		// if grossSales is invalid throw exception
		if(grossSales < 0){
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		// if commissionRate is invalid throw exception
		if(commissionRate <= 0 || commissionRate >= 1){
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		this.grossSales           = grossSales;
		this.commissionRate       = commissionRate;
	} // end constructor

	public void setGrossSales(double grossSales){
		if(grossSales < 0){
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		this.grossSales = grossSales;
	} // end of setGrossSales

	public double getGrossSales(){
		return this.grossSales;
	} // end of getGrossSales

	public void setCommissionRate(double commissionRate){
		if(commissionRate <= 0 || commissionRate >= 1){
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		this.commissionRate = commissionRate;
	} // end of setCommissionRate

	public double getCommissionRate(){
		return this.commissionRate;
	} // end of getCommissionRate

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings(){
		return getCommissionRate() * getGrossSales();
	} // end of earnings

	public String toString(){
		return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",  
			"commission employee", super.toString(),
			"gross sales", getGrossSales(),
			"commission rate", getCommissionRate());
	} // end of toString
} // end of CommissionEmployee class