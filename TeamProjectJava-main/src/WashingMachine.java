public class WashingMachine extends Device {
    private String energyclass;
    private int storage;
    private int rpm;

    // Constructor for the WashingMachine class
    public WashingMachine(String energyclass, int storage, int rpm, String code, String model, int manuyear, String manufacture, int price, int quantity) {
        // Call the superclass constructor with relevant parameters
        super("Washing Machine", code, model, manuyear, manufacture, price, quantity, "Washing Machine", "Household Appliances");

        // Set the specific attributes of the WashingMachine class
        this.energyclass = energyclass;
        this.storage = storage;
        this.rpm = rpm;

        // Add the WashingMachine object to the device list
        devlist.add(this);
    }

    // Getters and setters for the WashingMachine class
    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getStorage() {
        return storage;
    }

    public void setEnergyclass(String energyclass) {
        this.energyclass = energyclass;
    }

    public String getEnergyclass() {
        return energyclass;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }

    @Override
    public String toString() {
        // Override the toString() method to provide a custom string representation of the WashingMachine object
        return "Device's Code: " + getCode() + "\n"
                + "Device's Name: " + getModel() + "\n"
                + "Device's Manufacturer: " + getManufacture() + "\n"
                + "Device's Manufacture Year: " + getManuyear() + "\n"
                + "Device's Price: " + getPrice() + "\n"
                + "Device's Type: " + getType() + "\n"
                + "Device's Energy Class: " + getEnergyclass() + "\n"
                + "Device's Storage: " + getStorage() + "\n"
                + "Device's RPM: " + getRpm() + "\n"
                + "Available Quantity for Sale: " + getQuantity() + "\n"
                + "Device's Category: " + getCategory() + "\n";
    }
}