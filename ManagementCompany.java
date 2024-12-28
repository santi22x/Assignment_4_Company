/*
 * Class: CMSC203 
 * Instructor: Kjit
 * Description: (Manages multiple Companies)
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Santiago Ardila
*/

public class ManagementCompany {
    private String managementCompanyName;
    private String taxID;
    private double feePercentage;
    static final int MAX_PROPERTY = 5;
    private static final int MGMT_WIDTH = 10;
    private static final int MGMT_DEPTH = 10;
    private Plot plot;
    private Property[] properties;
    private int numberOfProperties;

    public ManagementCompany() {
        this.managementCompanyName = "";
        this.taxID = "";
        this.feePercentage = 0.0;
        this.numberOfProperties = 0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.managementCompanyName = name;
        this.taxID = taxID;
        this.feePercentage = mgmFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.managementCompanyName = name;
        this.taxID = taxID;
        this.feePercentage = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this.managementCompanyName = otherCompany.managementCompanyName;
        this.taxID = otherCompany.taxID;
        this.feePercentage = otherCompany.feePercentage;
        this.plot = new Plot(otherCompany.plot);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = otherCompany.numberOfProperties;
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
    }

    public String getName() {
        return managementCompanyName;
    }

    public void setManagementCompanyName(String managementCompanyName) {
        this.managementCompanyName = managementCompanyName;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public double getFeePercentage() {
        return feePercentage;
    }

    public void setFeePercentage(double feePercentage) {
        this.feePercentage = feePercentage;
    }

    public Plot getPlot() {
        return plot;
    }

    public Property[] getProperties() {
        return properties;
    }

    public int getNumberOfProperties() {
        return numberOfProperties;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        Property property = new Property(name, city, rent, owner);
        return addProperty(property);
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public int addProperty(Property property) {
        if (isPropertiesFull()) {
            return -1;
        }
        if (property == null) {
            return -2;
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        properties[numberOfProperties] = new Property(property);
        return numberOfProperties++;
    }

    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    public Property getHighestRentPropperty() {
        if (numberOfProperties == 0) return null;
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[--numberOfProperties] = null;
        }
    }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public boolean isManagementFeeValid() {
        return feePercentage >= 0 && feePercentage <= 100;
    }

    @Override
    public String toString() {
        String propertyList = "";
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                break;
            }
            propertyList += properties[i].toString() + "\n";
        }

        return "List of the properties for " + managementCompanyName + ", taxID: " + taxID
            + "\n______________________________________________________\n"
            + propertyList
            + "______________________________________________________\n"
            + "\n" + " total management Fee: " + (getTotalRent() * feePercentage / 100);
    }

    public double getMgmFeePer() {
        return feePercentage;
    }
}

