/**
 * 
 */
package day4assignments;

/**
 * @author matthew
 *
 */
public class Line {
	public int x0, y0, x1, y1;

	public Line(int x0, int y0, int x1, int y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}
	
	public double getSlope() {
		if (x0==x1) throw new ArithmeticException();
		
		return (y1-y0)/(double)(x1-x0);
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow(x0-x1,2)+Math.pow(y0-y1,2));
	}
	
	public boolean isParallelTo(Line l) {
		// cross product of vectors V should be zero;
		int[] thisV = new int[] {x1-x0,y1-y0};
		int[] lV = new int[] {l.x1-l.x0,l.y1-l.y0};
		
		return thisV[0]*lV[1]==thisV[1]*lV[0];
	}
}
