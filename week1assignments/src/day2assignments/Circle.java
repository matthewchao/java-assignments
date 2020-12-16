/**
 * 
 */
package day2assignments;

/**
 * @author matthew If constructed with a positive radius, represents a Circle
 *         with that radius.
 */
public class Circle implements Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("I'm a circle with radius " + radius + "!");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle(2);
		c.display();
		System.out.format("Area = %f\n", c.calculateArea());
	}

}
