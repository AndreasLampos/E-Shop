import java.util.ArrayList;

public class Device {
    private String code; // The code of the device
    private int manuyear; // The manufacturing year of the device
    private String manufacture; // The manufacturer of the device
    private int price; // The price of the device
    private String category; // The category of the device
    private String type; // The type of the device
    private String model; // The model of the device
    private int quantity; // The quantity of the device
    private String maintype; // The main type of the device
    StorageManager storageManager = new StorageManager();
    ArrayList<Device> devlist = storageManager.getDeviceList(); // List of devices
    ArrayList<Sale> salelist = storageManager.getSaleList(); // List of sales
    ArrayList<Order> orderlist = storageManager.getOrderList(); // List of orders

    // The constructor for the Device class
    public Device(String maintype, String code, String model, int manuyear, String manufacture, int price, int quantity, String type, String category) {
        this.maintype = maintype;
        this.code = code;
        this.model = model;
        this.manuyear = manuyear;
        this.manufacture = manufacture;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.category = category;
    }

    // Getters and setters for the Device class

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getModel() {
        return model;
    }

    public void setManuyear(int manuyear) {
        this.manuyear = manuyear;
    }

    public int getManuyear() {
        return manuyear;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public String getType() {
        return type;
    }

    public String getMaintype() {
        return maintype;
    }
}