public class Property {
    private String propertyName;
    private String city;
    private String owner;
    private double rentAmount;
    private Plot plot;

    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.owner = owner;
        this.rentAmount = rentAmount;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property other) {
        this.propertyName = other.propertyName;
        this.city = other.city;
        this.owner = other.owner;
        this.rentAmount = other.rentAmount;
        this.plot = new Plot(other.plot);
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}


