public class Console extends Device {
    private String cpu; // The CPU of the console
    private String gpu; // The GPU of the console
    private String sound; // The sound system of the console
    private int storage; // The storage capacity of the console

    // The constructor for the Console class
    public Console(String maintype, String cpu, String gpu, String sound, int storage, String code, String model, int manuyear, String manufacture, int price, int quantity) {
        // Call the superclass constructor with relevant parameters
        super(maintype, code, model, manuyear, manufacture, price, quantity, "",  "Gaming");       
        // Set the specific attributes of the Console class
        this.cpu = cpu;
        this.gpu = gpu;
        this.sound = sound;
        this.storage = storage;
        devlist.add(this); // Add the console instance to a list of devices
    }

    // Getters and setters for the Console class

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        // Override the toString() method to provide a custom string representation of the Console object
        return "Device's Code: " + getCode() + "\n" + "Device's Name: " + getModel() + "\n" + "Device's Manufacturer: "
                + getManufacture() + "\n" + "Device's Manufacture Year: " + getManuyear() + "\n" + "Device's Price: "
                + getPrice() + "\n" + "Device's Type: " + getMaintype() + "\n" + "Device's CPU: " + getCpu() + "\n"
                + "Device's GPU: " + getGpu() + "\n" + "Device's Sound: " + getSound() + "\n" + "Device's Storage: "
                + getStorage() + "\n" + "Available Quantity for Sale: " + getQuantity() + "\n" + "Device's Category: "
                + getCategory() + "\n";
    }
}