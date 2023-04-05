
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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.After;
import org.junit.Before;

class ManagementCompanyTestStudent {
	Property sampleProperty, p1, p2, p3, p4, p5, p6, p7, p8;
	ManagementCompany managementCo = new ManagementCompany("Railey", "555555555",6);
	ManagementCompany mCo = new ManagementCompany("Linh Tran", "987654321", 8);
	ManagementCompany maCo = new ManagementCompany("Teddy Bear", "123456", -9);
	@Before
	public void setUp() throws Exception {
		managementCo= new ManagementCompany("Railey", "555555555",6);
		mCo = new ManagementCompany("Linh Tran", "987654321", 8);
		maCo = new ManagementCompany("Teddy Bear", "123456", -9);
	}

	@After
	public void tearDown() throws Exception {
		p1 = p2 = p3 = p4 = p5 = p6 = p7 = p8 = null;
		managementCo=null;
		mCo = null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", "BillyBob Wilson", 2613,2,5,2,2);		 
		assertEquals(managementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
		p1 = new Property("Property 1", "College Park", "Sammuel Rick", 48567.00, 2, 1, 2, 2);
		assertEquals(managementCo.addProperty(p1),1,0); //property has been successfully added to index 1
		p6 = new Property("Property 6", "Gaithersburg", "Lindsey Boman", 2300.00, 2, 1, 2, 2);
		assertEquals(managementCo.addProperty(p6),-4,0); //property 6 overlaps property 1
		p2 = new Property("Property 2", "Silver Spring", "Anna Harrison", 1234, 4, 1, 2, 2);
		assertEquals(managementCo.addProperty(p2),2,0); //property has been successfully added to index 2
		assertEquals(managementCo.addProperty(p7),-2,0); //property is null
		p8 = new Property("Property 8", "Frederick", "Bobby Boyds", 6789, 4, 1, 11, 10);
		assertEquals(managementCo.addProperty(p8),-3,0); //property 8 encompasses property 2
		p3 = new Property("Property 3", "Clarksburg", "Bella Woods", 9870, 6, 1, 2, 2);
		assertEquals(managementCo.addProperty(p3),3,0); //property has been successfully added to index 3
		p4 = new Property ("CrystalBean", "Baltimore", "Cindy Ymir", 5327,4,5,2,2);		 
		assertEquals(managementCo.addProperty(p4),4,0);	//property has been successfully added to index 4
		p5 = new Property ("Anabelle", "Greenbelt", "Henry Johnson", 3241,3,7,4,3);		 
		assertEquals(managementCo.addProperty(p5),-1,0); //exceeds the size of properties array
	
	}
	
	@Test //true
	public void testIsPropertiesFull() {
		managementCo.addProperty("Property 1", "College Park", "Sammuel Rick", 48567.00, 2, 1, 2, 2);
		managementCo.addProperty("Property 2", "Silver Spring", "Anna Harrison", 1234, 4, 1, 2, 2);
		managementCo.addProperty("Property 3", "Clarksburg", "Bella Woods", 9870, 6, 1, 2, 2);	
		managementCo.addProperty("CrystalBean", "Baltimore", "Cindy Ymir", 5327,4,5,2,2);		
		managementCo.addProperty("Anabelle", "Greenbelt", "Henry Johnson", 3241,3,7,4,3);
		assertTrue(managementCo.isPropertiesFull());
	}
	
	@Test //false
	public void testIsPropertiesFull2() {
		managementCo.addProperty("Property 1", "College Park", "Sammuel Rick", 48567.00, 2, 1, 2, 2);
		managementCo.addProperty("Property 2", "Silver Spring", "Anna Harrison", 1234, 4, 1, 2, 2);
		managementCo.addProperty("Property 3", "Clarksburg", "Bella Woods", 9870, 6, 1, 2, 2);	
		managementCo.addProperty("CrystalBean", "Baltimore", "Cindy Ymir", 5327,4,5,2,2);			
		assertFalse(managementCo.isPropertiesFull());
	}
	
	@Test
	public void testRemoveLastProperty() {
		p1 = new Property("Property 1", "College Park", "Sammuel Rick", 48567.00, 2, 1, 2, 2);
		p2 = new Property("Property 2", "Silver Spring", "Anna Harrison", 1234, 4, 1, 2, 2);
		p3 = new Property("Property 3", "Clarksburg", "Bella Woods", 9870, 6, 1, 2, 2);	
		p4 = new Property("CrystalBean", "Baltimore", "Cindy Ymir", 5327,4,5,2,2);
		managementCo.addProperty(p1);
		managementCo.addProperty(p2);
		managementCo.addProperty(p3);
		managementCo.addProperty(p4);
		managementCo.removeLastProperty();
		assertEquals(managementCo.getPropertiesCount(),3);
	}
	
	@Test
	public void testGetTotalRent() {
		p1 = new Property("Property 1", "College Park", "Sammuel Rick", 48567.00, 2, 1, 2, 2);
		p2 = new Property("Property 2", "Silver Spring", "Anna Harrison", 1234, 4, 1, 2, 2);
		p3 = new Property("Property 3", "Clarksburg", "Bella Woods", 9870, 6, 1, 2, 2);	
		p4 = new Property("CrystalBean", "Baltimore", "Cindy Ymir", 5327,4,5,2,2);
		managementCo.addProperty(p1);
		managementCo.addProperty(p2);
		managementCo.addProperty(p3);
		managementCo.addProperty(p4);
		assertEquals(managementCo.getTotalRent(),64998);
	}
	
	@Test
	public void testGetHighestRentProperty() {
		p1 = new Property("Property 1", "College Park", "Sammuel Rick", 48567.00, 2, 1, 2, 2);
		p2 = new Property("Property 2", "Silver Spring", "Anna Harrison", 1234, 4, 1, 2, 2);
		p3 = new Property("Property 3", "Clarksburg", "Bella Woods", 9870, 6, 1, 2, 2);	
		p4 = new Property("CrystalBean", "Baltimore", "Cindy Ymir", 5327,4,5,2,2);
		managementCo.addProperty(p1);
		managementCo.addProperty(p2);
		managementCo.addProperty(p3);
		managementCo.addProperty(p4);
		assertEquals(managementCo.getHighestRentProperty().getPropertyName(),p1.getPropertyName());
	}
	
	@Test
	public void testIsManagementFeeValid() {
		assertTrue(managementCo.isManagementFeeValid());
		assertFalse(maCo.isManagementFeeValid());
	}
	
	@Test
	public void testGetPropertiesCount() {
		p1 = new Property("Property 1", "College Park", "Sammuel Rick", 48567.00, 2, 1, 2, 2);
		p2 = new Property("Property 2", "Silver Spring", "Anna Harrison", 1234, 4, 1, 2, 2);
		p3 = new Property("Property 3", "Clarksburg", "Bella Woods", 9870, 6, 1, 2, 2);	
		p4 = new Property("CrystalBean", "Baltimore", "Cindy Ymir", 5327,4,5,2,2);
		managementCo.addProperty(p1);
		managementCo.addProperty(p2);
		managementCo.addProperty(p3);
		managementCo.addProperty(p4);	
		assertEquals(managementCo.getPropertiesCount(), 4);
	}

	@Test
	public void testToString() {
		p1 = new Property("Property 1", "College Park", "Sammuel Rick", 48567.00, 2, 1, 2, 2);
		p2 = new Property("Property 2", "Silver Spring", "Anna Harrison", 1234, 4, 1, 2, 2);
		p3 = new Property("Property 3", "Clarksburg", "Bella Woods", 9870, 6, 1, 2, 2);	
		p4 = new Property("CrystalBean", "Baltimore", "Cindy Ymir", 5327,4,5,2,2);
		mCo.addProperty(p1);
		mCo.addProperty(p2);
		mCo.addProperty(p3);
		mCo.addProperty(p4);	
		assertEquals("List of the properties for Linh Tran, taxID: 987654321\n"
				+ "______________________________________________________\n"
				+ "Property 1,College Park,Sammuel Rick,48567.0\n"
				+ "Property 2,Silver Spring,Anna Harrison,1234.0\n"
				+ "Property 3,Clarksburg,Bella Woods,9870.0\n"
				+ "CrystalBean,Baltimore,Cindy Ymir,5327.0\n"
				+ "______________________________________________________\n"
				+ "\n"
				+ "total management Fee: 8.0", mCo.toString());
	}

}
