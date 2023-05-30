public class Camera extends Device {
    private int mp; // The resolution of the camera in megapixels
    private int opticalzoom; // The optical zoom capability of the camera
    private int digitalzoom; // The digital zoom capability of the camera
    private String dim; // The dimensions of the camera

    // The constructor for the Camera class
    public Camera(String type, int mp, int opticalzoom, int digitalzoom, String dim, String code, String model, int manuyear, String manufacture, int price, int quantity) {
        // Call the superclass constructor with relevant parameters
        super("Camera", code, model, manuyear, manufacture, price, quantity, type, "Picture and Sound");
        // Set the specific attributes of the Camera class
        this.mp = mp;
        this.opticalzoom = opticalzoom;
        this.digitalzoom = digitalzoom;
        this.dim = dim;
        devlist.add(this); // Add the camera instance to a list of devices
    }

    // Getters and setters for the Camera class

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMp() {
        return mp;
    }

    public void setOpticalzoom(int opticalzoom) {
        this.opticalzoom = opticalzoom;
    }

    public int getOpticalzoom() {
        return opticalzoom;
    }

    public void setDigitalzoom(int digitalzoom) {
        this.digitalzoom = digitalzoom;
    }

    public int getDigitalzoom() {
        return digitalzoom;
    }

    public void setDim(String dim) {
        this.dim = dim;
    }

    public String getDim() {
        return dim;
    }

    @Override
    public String toString() {
        // Override the toString() method to provide a custom string representation of the Camera object
        return "Device's Code: " + getCode() + "\n" + "Device's Name: " + getModel() + "\n" + "Device's Manufacturer: "
                + getManufacture() + "\n" + "Device's Manufacture Year: " + getManuyear() + "\n" + "Device's Price: "
                + getPrice() + "\n" + "Device's Type: " + getType() + "\n" + "Device's Megapixels: " + getMp() + "\n"
                + "Device's Optical Zoom: " + getOpticalzoom() + "\n" + "Device's Digital Zoom: " + getDigitalzoom()
                + "\n" + "Device's Dimensions: " + getDim() + "\n" + "Available Quantity for Sale: " + getQuantity()
                + "\n" + "Device's Category: " + getCategory() + "\n";
    }
}