/**
 * 
 */
package day2assignments;

/**
 * @author matthew
 *
 */
public class Triangle implements Shape {

	private double a, b, c, s;

	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.s = (a + b + c) / 2.0;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.format("I'm a triangle with sides %f, %f, and %f\n", a, b, c);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle t = new Triangle(3.0, 4.0, 5.0);
		t.display();
		System.out.format("Area = %f\n", t.calculateArea());
	}

}
