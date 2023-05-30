
public class DVD extends Device {

    private int res; // The resolution of the DVD
    private String format; // The format of the DVD

    // The constructor for the DVD class
    public DVD(String maintype, int res, String format, String code, String model, int manuyear, String manufacture, int price, int quantity) {
        // Call the superclass constructor with relevant parameters
        super(maintype, code, model, manuyear, manufacture, price, quantity, "",  "Picture and Sound");
        // Set the specific attributes of the DVD class
        this.res = res;
        this.format = format;
        devlist.add(this); // Add the DVD instance to a list of devices
    }

    // Getters and setters for the DVD class

    public void setRes(int res) {
        this.res = res;
    }

    public int getRes() {
        return res;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
    

    @Override
    public String toString() {
        // Override the toString() method to provide a custom string representation of the DVD object
        return "Device's Code: " + getCode() + "\n" + "Device's Name: " + getModel() + "\n" + "Device's Manufacturer: "
                + getManufacture() + "\n" + "Device's Manufacture Year: " + getManuyear() + "\n" + "Device's Price: "
                + getPrice() + "\n" + "Device's Type: " + getMaintype() + "\n" + "Device's Resolution: " + getRes() + "\n"
                + "Device's Format: " + getFormat() + "\n" + "Available Quantity for Sale: " + getQuantity() + "\n"
                + "Device's Category: " + getCategory() + "\n";
    }
}