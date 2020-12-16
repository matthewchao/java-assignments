/**
 * 
 */
package day2assignments;

/**
 * @author matthew
 *
 */
public class Rectangle implements Shape {

	private double length;
	private double width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;

	}

	@Override
	public double calculateArea() {
		return length * width;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("I'm a rectangle with length " + length + " and width " + width + "!");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r = new Rectangle(2.0, 1.5);
		r.display();
		System.out.format("Area = %f\n", r.calculateArea());
	}

}
