import java.time.LocalDate;

public class Order extends Person  {
    private int code;
    private String model;
    private LocalDate orderdate;
    private LocalDate dateofarrival;
    private boolean pending;
    private float cost;

    public Order(int code,String model,LocalDate orderdate,LocalDate dateofarrival,float cost, String name,String surname,int phonenumber,boolean pending){
        super(name,surname,phonenumber);
        this.code=code;
        this.model=model;
        this.orderdate=orderdate;
        this.dateofarrival=dateofarrival;
        this.pending=pending;
        this.cost=cost;
    }
    public void setCode(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }
    public void setModel(String model){
        this.model=model;
    }
    public String getModel(){
        return model;
    }
    public void setOrderdate(LocalDate orderdate){
        this.orderdate=orderdate;
    }
    public LocalDate getOrderdate(){
        return orderdate;
    }
    public void setDateofarrival(LocalDate dateofarrival){
        this.dateofarrival=dateofarrival;
    }
    public LocalDate getDateofarrival(){
        return dateofarrival;
    }
    public void setPending(boolean pending){
        this.pending=pending;
    }
    public boolean getPending(){
        return pending;
    }
    public void setCost(float cost){
        this.cost=cost;
    }
    public float getCost(){
        return cost;
    }
    @Override
    public String toString() {
        // Override the toString() method to provide a custom string representation of the Order object
        return "Order's Code: " + getCode() + "\n" + "Order's Name: " + getModel() + "\n" + "Order's Date: "
                + getOrderdate() + "\n" + "Order's Date of Arrival: " + getDateofarrival() + "\n" + "Order's Cost: "
                + getCost() + "\n" + "Order's Name: " + getName() + "\n"
                + "Order's Surname: " + getSurname() + "\n" + "Order's Phone Number: " + getPhonenumber() + "\n";
    
        
    }
}
