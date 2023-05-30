public class Fridge extends Device {
    private String energyclass; // The energy class of the fridge
    private int mainstorage; // The main storage capacity of the fridge
    private int freezerstorage; // The freezer storage capacity of the fridge

    // The constructor for the Fridge class
    public Fridge(String type, String energyclass, int mainstorage, int freezerstorage, String code, String model, int manuyear, String manufacture, int price, int quantity) {
        // Call the superclass constructor with relevant parameters
        super("Fridge", code, model, manuyear, manufacture, price, quantity, type, "Household Appliances");
        // Set the specific attributes of the Fridge class
        this.energyclass = energyclass;
        this.mainstorage = mainstorage;
        this.freezerstorage = freezerstorage;
        devlist.add(this); // Add the Fridge instance to a list of devices
    }

    // Getters and setters for the Fridge class

    public void setEnergyclass(String energyclass) {
        this.energyclass = energyclass;
    }

    public String getEnergyclass() {
        return energyclass;
    }

    public void setMainstorage(int mainstorage) {
        this.mainstorage = mainstorage;
    }

    public int getMainstorage() {
        return mainstorage;
    }

    public void setFreezerstorage(int freezerstorage) {
        this.freezerstorage = freezerstorage;
    }

    public int getFreezerstorage() {
        return freezerstorage;
    }

    @Override
    public String toString() {
        // Override the toString() method to provide a custom string representation of the Fridge object
        return "Device's Code: " + getCode() + "\n" + "Device's Name: " + getModel() + "\n" + "Device's Manufacturer: "
                + getManufacture() + "\n" + "Device's Manufacture Year: " + getManuyear() + "\n" + "Device's Price: "
                + getPrice() + "\n" + "Device's Type: " + getType() + "\n" + "Device's Energy Class: "
                + getEnergyclass() + "\n" + "Device's Main Storage: " + getMainstorage() + "\n"
                + "Device's Freezer Storage: " + getFreezerstorage() + "\n" + "Available Quantity for Sale: "
                + getQuantity() + "\n" + "Device's Category: " + getCategory() + "\n";
    }
}