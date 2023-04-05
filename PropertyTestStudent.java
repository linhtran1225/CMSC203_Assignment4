
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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class PropertyTestStudent {
	Property propertyOne;
	Property propertyTwo;
	Property propertyThree;
	Property propertyFour;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Property ABC", "Rockville", "Wells Fargo Bank", 2450.00); //constructor 2
		propertyTwo = new Property("Property BP", "Germantown", "Linh Tran", 3500.0, 3, 5, 4, 6); //constructor 3
		propertyThree = new Property(propertyTwo); //constructor 4
		propertyFour = new Property("Assignment4", "32293", "CMSC203", 1200.00, 10, 12, 2, 4); //constructor 3
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
		propertyTwo = null;
		propertyThree = null;
		propertyFour = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property ABC", propertyOne.getPropertyName());
		assertEquals("Property BP", propertyTwo.getPropertyName());
		assertEquals("Property BP", propertyThree.getPropertyName());
		assertEquals("Assignment4", propertyFour.getPropertyName());
	}
	
	@Test
	void testGetCity() {
		assertEquals("Rockville", propertyOne.getCity());
		assertEquals("Germantown", propertyTwo.getCity());
		assertEquals("Germantown", propertyThree.getCity());
		assertEquals("32293", propertyFour.getCity());
	}
	
	@Test
	void testGetOwner() {
		assertEquals("Wells Fargo Bank", propertyOne.getOwner());
		assertEquals("Linh Tran", propertyTwo.getOwner());
		assertEquals("Linh Tran", propertyThree.getOwner());
		assertEquals("CMSC203", propertyFour.getOwner());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, propertyOne.getRentAmount());
		assertEquals(3500.0, propertyTwo.getRentAmount());
		assertEquals(3500.0, propertyThree.getRentAmount());
		assertEquals(1200.00, propertyFour.getRentAmount());
	}

	@Test
	void testGetPlot() {
		//property one
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
		//property two
		assertEquals(3, propertyTwo.getPlot().getX());
		assertEquals(5, propertyTwo.getPlot().getY());
		assertEquals(4, propertyTwo.getPlot().getWidth());
		assertEquals(6, propertyTwo.getPlot().getDepth());
		//property three
		assertEquals(3, propertyThree.getPlot().getX());
		assertEquals(5, propertyThree.getPlot().getY());
		assertEquals(4, propertyThree.getPlot().getWidth());
		assertEquals(6, propertyThree.getPlot().getDepth());
		//property four
		assertEquals(10, propertyFour.getPlot().getX());
		assertEquals(12, propertyFour.getPlot().getY());
		assertEquals(2, propertyFour.getPlot().getWidth());
		assertEquals(4, propertyFour.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0",propertyOne.toString());	
		assertEquals("Property BP,Germantown,Linh Tran,3500.0",propertyTwo.toString());
		assertEquals("Property BP,Germantown,Linh Tran,3500.0",propertyThree.toString());
		assertEquals("Assignment4,32293,CMSC203,1200.0",propertyFour.toString());
	}

}
