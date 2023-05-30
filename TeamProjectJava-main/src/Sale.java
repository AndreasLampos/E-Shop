import java.time.LocalDate;

public class Sale extends Person {
    private int code;
    private String model;
    private LocalDate date;
    private float cost;

    public Sale(int code, String model, LocalDate date, float cost, String name, String surname, int phonenumber) {
        super(name, surname, phonenumber);
        this.code = code;
        this.model = model;
        this.date = date;
        this.cost = cost;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Sale's Code: " + getCode() + "\n" + "Sale's Model: " + getModel() + "\n" + "Sale's Date: " + getDate()
                + "\n" + "Sale's Cost: " + getCost() + "\n" + "Sale's Name: " + getName() + "\n" + "Sale's Surname: "
                + getSurname() + "\n" + "Sale's Phonenumber: " + getPhonenumber() + "\n";
    }
}
