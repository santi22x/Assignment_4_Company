import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestastudent {
	@Test
	public void testDefaultConstructor() {
	    Plot plot = new Plot();
	    assertEquals(0, plot.getX());
	    assertEquals(0, plot.getY());
	    assertEquals(1, plot.getWidth());
	    assertEquals(1, plot.getDepth());
	}

	@Test
	public void testParameterizedConstructor() {
	    Plot plot = new Plot(1, 2, 3, 4);
	    assertEquals(1, plot.getX());
	    assertEquals(2, plot.getY());
	    assertEquals(3, plot.getWidth());
	    assertEquals(4, plot.getDepth());
	}

	@Test
	public void testCopyConstructor() {
	    Plot original = new Plot(1, 2, 3, 4);
	    Plot copy = new Plot(original);
	    assertEquals(1, copy.getX());
	    assertEquals(2, copy.getY());
	    assertEquals(3, copy.getWidth());
	    assertEquals(4, copy.getDepth());
	}

	@Test
	public void testSettersAndGetters() {
	    Plot plot = new Plot();
	    plot.setX(5);
	    plot.setY(6);
	    plot.setWidth(7);
	    plot.setDepth(8);
	    assertEquals(5, plot.getX());
	    assertEquals(6, plot.getY());
	    assertEquals(7, plot.getWidth());
	    assertEquals(8, plot.getDepth());
	}

	@Test
	public void testOverlaps() {
	    Plot plot1 = new Plot(1, 1, 3, 3);
	    Plot plot2 = new Plot(2, 2, 3, 3);
	    assertTrue(plot1.overlaps(plot2));
	    Plot plot3 = new Plot(5, 5, 3, 3);
	    assertFalse(plot1.overlaps(plot3));
	}

	@Test
	public void testEncompasses() {
	    Plot plot1 = new Plot(0, 0, 10, 10);
	    Plot plot2 = new Plot(2, 2, 3, 3);
	    assertTrue(plot1.encompasses(plot2));
	    Plot plot3 = new Plot(-1, -1, 12, 12);
	    assertFalse(plot1.encompasses(plot3));
	}

	@Test
	public void testToString() {
	    Plot plot = new Plot(1, 2, 3, 4);
	    assertEquals("1,2,3,4", plot.toString());
	}


}
