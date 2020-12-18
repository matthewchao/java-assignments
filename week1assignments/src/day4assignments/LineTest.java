/**
 * 
 */
package day4assignments;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * @author matthew
 *
 */
public class LineTest {
//	private int x0, y0, x1, y1;
	Line horizontalLine = new Line(0,0,10,0);
	Line verticalLine = new Line(1,0,1,10);
	Line diagonalLine = new Line(0,0,1,1);


//	public Line(int x0, int y0, int x1, int y1) {
//		this.x0 = x0;
//		this.y0 = y0;
//		this.x1 = x1;
//		this.y1 = y1;
//	}
	
	@Test
	public void getSlopeTest() {
		assertThrows(ArithmeticException.class,()->{
			verticalLine.getSlope();
		});
		assertEquals(diagonalLine.getSlope(),1.0,0.000001);
		assertEquals(horizontalLine.getSlope(),0.0,0.000001);
	}
	
	@Test
	public void getLengthTest() {
		assertEquals(horizontalLine.getLength(),10.0);
		assertEquals(verticalLine.getLength(),10.0);
		assertEquals(diagonalLine.getLength(),Math.sqrt(2),0.000001);
	}
	
	@Test
	public void isParallelToTest() {
		Line horizontalLine2 = new Line(0,1,10,1);
		Line verticalLine2 = new Line(0,0,0,10);
		Line diagonalLine2 = new Line(0,1,-1,0);
		assert(horizontalLine.isParallelTo(horizontalLine));
		assert(verticalLine.isParallelTo(verticalLine));
		assert(diagonalLine.isParallelTo(diagonalLine));
		assertFalse(horizontalLine.isParallelTo(verticalLine));
		assert(horizontalLine.isParallelTo(horizontalLine2));
		assert(verticalLine.isParallelTo(verticalLine2));
		assert(diagonalLine.isParallelTo(diagonalLine2));
	}
}
