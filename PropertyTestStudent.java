import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	Property property1, property2, property3;

    @BeforeEach
    void setUp() throws Exception {
        property1 = new Property("Property One", "Bethesda", 3000.00, "John Doe");
        property2 = new Property("Property Two", "Silver Spring", 1800.00, "Jane Smith");
        property3 = new Property("Property Three", "Gaithersburg", 2500.00, "Mary Johnson", 2, 3, 4, 5);
    }

    @AfterEach
    void tearDown() throws Exception {
        property1 = null;
        property2 = null;
        property3 = null;
    }

    @Test
    void testGetPropertyName() {
        assertEquals("Property One", property1.getPropertyName());
        assertEquals("Property Two", property2.getPropertyName());
        assertEquals("Property Three", property3.getPropertyName());
    }

    @Test
    void testGetCity() {
        assertEquals("Bethesda", property1.getCity());
        assertEquals("Silver Spring", property2.getCity());
        assertEquals("Gaithersburg", property3.getCity());
    }

    @Test
    void testGetOwner() {
        assertEquals("John Doe", property1.getOwner());
        assertEquals("Jane Smith", property2.getOwner());
        assertEquals("Mary Johnson", property3.getOwner());
    }

    @Test
    void testGetRentAmount() {
        assertEquals(3000.00, property1.getRentAmount());
        assertEquals(1800.00, property2.getRentAmount());
        assertEquals(2500.00, property3.getRentAmount());
    }

    @Test
    void testGetPlot() {
        // Default plot
        assertEquals(0, property1.getPlot().getX());
        assertEquals(0, property1.getPlot().getY());
        assertEquals(1, property1.getPlot().getWidth());
        assertEquals(1, property1.getPlot().getDepth());

        // Custom plot
        assertEquals(2, property3.getPlot().getX());
        assertEquals(3, property3.getPlot().getY());
        assertEquals(4, property3.getPlot().getWidth());
        assertEquals(5, property3.getPlot().getDepth());
    }

    @Test
    void testSetPropertyName() {
        property1.setPropertyName("Updated Property One");
        assertEquals("Updated Property One", property1.getPropertyName());
    }

    @Test
    void testSetCity() {
        property1.setCity("New Bethesda");
        assertEquals("New Bethesda", property1.getCity());
    }

    @Test
    void testSetOwner() {
        property1.setOwner("Updated Owner");
        assertEquals("Updated Owner", property1.getOwner());
    }

    @Test
    void testSetRentAmount() {
        property1.setRentAmount(3500.00);
        assertEquals(3500.00, property1.getRentAmount());
    }

    @Test
    void testSetPlot() {
        property1.setPlot(new Plot(5, 5, 6, 6));
        assertEquals(5, property1.getPlot().getX());
        assertEquals(5, property1.getPlot().getY());
        assertEquals(6, property1.getPlot().getWidth());
        assertEquals(6, property1.getPlot().getDepth());
    }

    @Test
    void testToString() {
        assertEquals("Property One,Bethesda,John Doe,3000.0", property1.toString());
        assertEquals("Property Two,Silver Spring,Jane Smith,1800.0", property2.toString());
        assertEquals("Property Three,Gaithersburg,Mary Johnson,2500.0", property3.toString());
    }
}
