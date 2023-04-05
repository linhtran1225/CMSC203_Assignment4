
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

public class Plot {

	private int x, y, width, depth;
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	public Plot(int x, int y, int w, int d) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.depth = d;
	}
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	public boolean overlaps(Plot plot) {
		boolean check = true;
		if (!((this.x < (plot.x + plot.width)) && ((this.x + this.width) > plot.x)
				&& (this.y < (plot.y + plot.depth)) && ((this.y+this.depth) > plot.y))) {
			check = false;
		}
		System.out.println(check);
		return check;
	}
	public boolean encompasses(Plot plot) {
		boolean check = true;
		if (!((plot.x >= this.x) && (plot.x <= this.x + this.width) 
				&& (plot.x + plot.width >= this.x) && (plot.x + plot.width <= this.x + this.width) 
				&& (plot.y >= this.y) && (plot.y <= this.y + this.depth) 
				&& (plot.y + plot.depth >= this.y) && (plot.y + plot.depth <= this.y + this.depth))) {
			check = false;
		}
		System.out.println(check);
		return check;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth(int w) {
		this.width = w;
	}
	public void setDepth(int d) {
		this.depth = d;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getDepth() {
		return depth;
	}
	public String toString() {
		String str = x + "," + y + "," + width + "," + depth;
		return str;
	}
}
