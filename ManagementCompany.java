
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

public class ManagementCompany {
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	private double feePercent;
	private String name;
	private String taxID;
	private Plot plot;
	private Property[] properties;
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.properties = new Property[MAX_PROPERTY];
		this.feePercent = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.properties = new Property[MAX_PROPERTY];
		this.feePercent = mgmFee;
		this.plot = new Plot(x, y, width, depth);
	}
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.properties = otherCompany.properties;
		this.feePercent = otherCompany.feePercent;
		this.plot = otherCompany.plot;
	}
	public int addProperty(Property property) {
		int index = 0;
		if (isPropertiesFull()) {
			index = -1;
		}
		else if (property == null) {
			index = -2;
		}
		else if (!(plot.encompasses(property.getPlot()))) {
			index = -3;
		}
		else {
			for (int i = 0; i < MAX_PROPERTY; i++) {
				if (!(properties[i] == null)) {
					if (properties[i].getPlot().overlaps(property.getPlot())) {
						return -4;
					}
				}
				else {
					properties[i] = new Property(property);
					index = i;
					break;
				}
			}
		}
		return index;
	}
	public int addProperty(String name, String city, String owner, double rent) {
		return addProperty(new Property(name, city, owner, rent));
	}
	public int addProperty(String name, String city, String owner, double rent, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, owner, rent, x, y, width, depth));
	}
	public void removeLastProperty() {
		for (int i = MAX_PROPERTY - 1; i >= 0; i--) {
			if (!(properties[i] == null)) {
				properties[i] = null;
				break;
			}
		}
	}
	public int getPropertiesCount() {
		int count = 0;
		for (int i = 0; i < properties.length; i++) {
			if (!(properties[i] == null)) {
				count++;
			}
		}
		return count;
	}
	public boolean isPropertiesFull() {
		boolean check = true;
		if (!(getPropertiesCount() == 5)) {
			check = false;
		}
		return check;
	}
	public double getTotalRent() {
		double total = 0.0;
		for (int i = 0; i < properties.length; i++) {
			if (!(properties[i] == null)) {
				total += properties[i].getRentAmount();
			}
		}
		return total;
	}
	/*public Property getHighestRentProperty() {
		Property highestRentProp = new Property();
		double highestRent = 0; 
		highestRent = properties[0].getRentAmount();
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getRentAmount() >= highestRent) {
				highestRent = properties[i].getRentAmount();
				highestRentProp = new Property(properties[i]);
			}
		}
		return highestRentProp;
	}*/
	
	/*public Property getHighestRentProperty() {
        Property highestRentProp = null;
        double highestRent = 0; 
        highestRent = properties[0].getRentAmount();
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getRentAmount() >= highestRent) {
                highestRent = properties[i].getRentAmount();
                highestRentProp = properties[i];
            }
        }
        return highestRentProp;
    }*/
	
	public Property getHighestRentProperty() {
        Property highestRentProp = properties[0];
        Property curr = null;
        int index = 0;
        for (int i = 1; i < properties.length; i++) {
            if (!(properties[i] == null)) {
                curr = properties[i];
                if (curr.getRentAmount() >= highestRentProp.getRentAmount()) {
                    highestRentProp = properties[i];
                    index = i;
                }
            }
        }
        return properties[index];
    }
	
	public boolean isManagementFeeValid() {
		boolean check = true;
		if ((this.feePercent < 0) || (this.feePercent > 100)) {
			check = false;
		}
		return check;
	}
	public String getName() {
		return name;
	}
	public String getTaxID() {
		return taxID;
	}
	public Property[] getProperties() {
		return properties;
	}
	public double getMgmFeePer() {
		return feePercent;
	}
	public Plot getPlot() {
		return plot;
	}
	public String toString() {
		String str1 = "List of the properties for " + getName() + ", taxID: " + getTaxID() + "\n";
		String str2 = "______________________________________________________\n";
		String str3 = "\ntotal management Fee: " + getMgmFeePer();
		String str4 = "";
		for (int i = 0; i < properties.length; i++) {
			if (!(properties[i] == null)) {
				str4 += properties[i].toString();
			}
		}
		String result = str1 + str2 + str4 + str2 + str3;
		System.out.println(result);
		return result;
	}
}

