
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

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlotTestStudent {

	Plot plot1 = new Plot(2, 2, 6, 6);
	Plot plot2 = new Plot(0, 0, 0, 0);
	Plot plot3 = new Plot(6, 4, 2, 2);
	Plot plot4 = new Plot(5, 4, 3, 3);
	Plot plot5 = new Plot(3, 4, 4, 3);
	Plot plot6 = new Plot(12, 12, 6, 6);
	Plot plot7 = new Plot(11, 11, 3, 2);
	Plot plot8 = new Plot(9, 4, 3, 3);
	
	@Test
	void testOverlaps() {
		//Case1
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
		//Case2
		assertFalse(plot1.overlaps(plot2)); 
		//Case3
		assertTrue(plot7.overlaps(plot6)); // plot7 overlaps left bottom corner of plot6
		//Case4
		assertFalse(plot8.overlaps(plot2)); // plot8 does not overlap plot2
	}

	@Test
	void testEncompasses() {
		//Case1
		assertTrue(plot1.encompasses(plot5)); //plot5 is contained in plot1
		//Case2
		assertFalse(plot1.encompasses(plot2)); //plot1 is outside of plot2
		//Case3
		assertFalse(plot4.encompasses(plot5)); //plot4 is outside on the right of plot5
		//Case4
		assertTrue(plot4.encompasses(plot3)); //plot3 is inside plot4
	}

	@Test
	void testSetX() {
		plot2.setX(5);
		assertEquals(plot2.getX(),5);
		plot3.setX(7);
		assertEquals(plot3.getX(),7);
		plot7.setX(-2);
		assertEquals(plot7.getX(),-2);
		plot6.setX(8);
		assertEquals(plot6.getX(),8);
	}

	@Test
	void testSetY() {
		plot2.setY(4);
		assertEquals(plot2.getY(),4);
		plot3.setY(19);
		assertEquals(plot3.getY(),19);
	}

	@Test
	void testSetWidth() {
		plot2.setWidth(6);
		assertEquals(plot2.getWidth(),6);
		plot7.setWidth(-2);
		assertEquals(plot7.getWidth(),-2);
	}

	@Test
	void testSetDepth() {
		plot2.setDepth(3);
		assertEquals(plot2.getDepth(),3);
		plot6.setDepth(999);
		assertEquals(plot6.getDepth(),999);
	}

	@Test
	void testGetX() {
		assertEquals(plot1.getX(),2);
		assertEquals(plot2.getX(),0);
		assertEquals(plot3.getX(),6);
		assertEquals(plot4.getX(),5);
		assertEquals(plot5.getX(),3);
		assertEquals(plot6.getX(),12);
		assertEquals(plot7.getX(),11);
		assertEquals(plot8.getX(),9);
	}

	@Test
	void testGetY() {
		assertEquals(plot1.getY(),2);
		assertEquals(plot2.getY(),0);
		assertEquals(plot3.getY(),4);
		assertEquals(plot4.getY(),4);
		assertEquals(plot5.getY(),4);
		assertEquals(plot6.getY(),12);
		assertEquals(plot7.getY(),11);
		assertEquals(plot8.getY(),4);
	}

	@Test
	void testGetWidth() {
		assertEquals(plot1.getWidth(),6);
		assertEquals(plot2.getWidth(),0);
		assertEquals(plot3.getWidth(),2);
		assertEquals(plot4.getWidth(),3);
		assertEquals(plot5.getWidth(),4);
		assertEquals(plot6.getWidth(),6);
		assertEquals(plot7.getWidth(),3);
		assertEquals(plot8.getWidth(),3);
	}

	@Test
	void testGetDepth() {
		assertEquals(plot1.getDepth(),6);
		assertEquals(plot2.getDepth(),0);
		assertEquals(plot3.getDepth(),2);
		assertEquals(plot4.getDepth(),3);
		assertEquals(plot5.getDepth(),3);
		assertEquals(plot6.getDepth(),6);
		assertEquals(plot7.getDepth(),2);
		assertEquals(plot8.getDepth(),3);
	}

	@Test
	void testToString() {
		assertEquals("2,2,6,6",plot1.toString());
		assertEquals("0,0,0,0",plot2.toString());
		assertEquals("6,4,2,2",plot3.toString());
		assertEquals("5,4,3,3",plot4.toString());
		assertEquals("3,4,4,3",plot5.toString());
		assertEquals("12,12,6,6",plot6.toString());
		assertEquals("11,11,3,2",plot7.toString());
		assertEquals("9,4,3,3",plot8.toString());
	}

}
