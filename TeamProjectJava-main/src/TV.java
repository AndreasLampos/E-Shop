public class TV extends Device {
    private int dimension;
    private int resolution;
    private String port;

    // Constructor for the TV class
    public TV(String type, int dimension, int resolution, String port, String code, String model, int manuyear, String manufacture, int price, int quantity) {
        // Call the superclass constructor with relevant parameters
        super("TV", code, model, manuyear, manufacture, price, quantity, type, "Picture and Sound");

        // Set the specific attributes of the TV class
        this.dimension = dimension;
        this.resolution = resolution;
        this.port = port;

        // Add the TV object to the device list
        devlist.add(this);
    }

    // Getters and setters for the TV class
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public int getResolution() {
        return resolution;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    @Override
    public String toString() {
        // Override the toString() method to provide a custom string representation of the TV object
        return "Device's Code: " + getCode() + "\n"
                + "Device's Name: " + getModel() + "\n"
                + "Device's Manufacturer: " + getManufacture() + "\n"
                + "Device's Manufacture Year: " + getManuyear() + "\n"
                + "Device's Price: " + getPrice() + "\n"
                + "Device's Type: " + getType() + "\n"
                + "Device's Dimension: " + getDimension() + "\n"
                + "Device's Resolution: " + getResolution() + "\n"
                + "Device's Port: " + getPort() + "\n"
                + "Available Quantity for Sale: " + getQuantity() + "\n"
                + "Device's Category: " + getCategory() + "\n";
    }
}