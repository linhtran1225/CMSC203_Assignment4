
/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Write an application that lets the user create a management company and 
 * add the properties managed by the company to its list. Assume the maximum number of properties 
 * handled by the company is 5.  
 * Due: 04/03/2023
 * Platform/compiler: Window 10 Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Linh Tran
*/

public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rent;
	private Plot plot;
	public Property() {
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rent = 0.0;
		this.plot = new Plot();
	}
	public Property(String name, String city, String owner, double rent) {
		this.city = city;
		this.owner = owner;
		this.propertyName = name;
		this.rent = rent;
		this.plot = new Plot();
	}
	public Property(String name, String city, String owner, double rent, int x, int y, int w, int d) {
		this.city = city;
		this.owner = owner;
		this.propertyName = name;
		this.rent = rent;
		this.plot = new Plot(x, y, w, d);
	}
	public Property(Property otherProperty) {
		this.city = otherProperty.city;
		this.owner = otherProperty.owner;
		this.propertyName = otherProperty.propertyName;
		this.rent = otherProperty.rent;
		this.plot = new Plot(otherProperty.plot);
	}
	public void setPlot(Plot plot) {
		this.plot = new Plot(plot);
	}
	public void setPropertyName(String name) {
		this.propertyName = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setRentAmount(double rent) {
		this.rent = rent;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Plot getPlot() {
		return plot;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public String getCity() {
		return city;
	}
	public double getRentAmount() {
		return rent;
	}
	public String getOwner() {
		return owner;
	}
	public String toString() {
		String str = propertyName + "," + city + "," + owner + "," + rent + "\n";
		return str;
	}
}

