import java.util.ArrayList;
public class StorageManager {
    private ArrayList<Device> deviceList;
    private ArrayList<Order> orderList;
    private ArrayList<Sale> saleList;

    public StorageManager() {
        deviceList = new ArrayList<>();
        orderList = new ArrayList<>();
        saleList = new ArrayList<>();
    }

    public void addDevice(Device device) {
        deviceList.add(device);
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void addSale(Sale sale) {
        saleList.add(sale);
    }

    public ArrayList<Device> getDeviceList() {
        return deviceList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public ArrayList<Sale> getSaleList() {
        return saleList;
    }

    public void setDeviceList(ArrayList<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public void setSaleList(ArrayList<Sale> saleList) {
        this.saleList = saleList;
    }
}