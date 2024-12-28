
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagementCompanyTestStudent {
	private ManagementCompany managementCompany;
    private Property property1, property2, property3;

    @BeforeEach
    public void setUp() {
        managementCompany = new ManagementCompany("Company B", "67890", 15.0);
        property1 = new Property("Property A", "City A", 1200.0, "Owner A", 2, 2, 3, 3);
        property2 = new Property("Property B", "City B", 2500.0, "Owner B", 6, 6, 2, 2);
        property3 = new Property("Property C", "City C", 1800.0, "Owner C", 8, 8, 1, 1);
    }

    @Test
    public void testAddProperty() {
        assertEquals(0, managementCompany.addProperty(property1));
        assertEquals(1, managementCompany.addProperty(property2));
        assertEquals(-4, managementCompany.addProperty(property3));
    }

    @Test
    public void testGetTotalRent() {
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);
        managementCompany.addProperty(property3);
        assertEquals(3700.0, managementCompany.getTotalRent(), 0.001);
    }

    @Test
    public void testRemoveLastProperty() {
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);
        managementCompany.removeLastProperty();
        assertEquals(1, managementCompany.getPropertiesCount());
        assertNull(managementCompany.getProperties()[1]);
    }

    @Test
    public void testIsPropertiesFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            managementCompany.addProperty(new Property("Property " + i, "City X", 800.0, "Owner X"));
        }
        assertFalse(managementCompany.isPropertiesFull());
    }

    @Test
    public void testGetPropertiesCount() {
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);
        assertEquals(2, managementCompany.getPropertiesCount());
    }

    @Test
    public void testIsManagementFeeValid() {
        assertTrue(managementCompany.isManagementFeeValid());
        managementCompany.setFeePercentage(105.0);
        assertFalse(managementCompany.isManagementFeeValid());
    }

    @Test
    public void testToString() {
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);
        String expected = "List of the properties for Company B, taxID: 67890\n"
                + "______________________________________________________\n"
                + "Property A,City A,Owner A,1200.0\n"
                + "Property B,City B,Owner B,2500.0\n"
                + "______________________________________________________\n"
                + "\n total management Fee: " + (managementCompany.getTotalRent() * managementCompany.getFeePercentage() / 100);
        assertEquals(expected, managementCompany.toString());
    }
}

