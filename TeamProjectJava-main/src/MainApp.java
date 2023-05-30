// Authors: Group 83 - Giannoutsos Swkratis Vissarion 3220028, Dimitrakopoulos Athanasios Zois 3220039, Lampos Andreas 3220105

import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;

public class MainApp {
    private static String category; //The category of the wanted item
    private static String type; //The type of the wanted item
    private static String name; //The model of the wanted item
    private static int option;
    private static int DiscountPS=10; //The discount for the Sound and Picture items
    private static int DiscountG=15; //The discount for the Gaming items
    private static int DiscountHA=10; //The discount for the House Appliances items
    private static float cost; //The cost of the wanted item
    private static int salecode=1; //The code of the sale
    private static int ordercode=1; //The code of the order
    private static int order; //The order that the user wants to complete
    private static boolean pending=true; //The status of the order
    private static String custname; //The name of the customer
    private static String custsurname; //The surname of the customer
    private static int phonenumber; //The phone number of the customer
    
    
    private static final StorageManager storageManager = new StorageManager(); // Create an instance of the StorageManager class
    private static final ArrayList<Device> devlist = storageManager.getDeviceList(); // List of devices
    private static final ArrayList<Sale> salelist= storageManager.getSaleList(); // List of sales
    private static final ArrayList<Order> orderlist=storageManager.getOrderList(); // List of orders

    public static void DiscountShow(int DiscountItem, int i){
        System.out.println("The item has a discount of "+DiscountItem +"%!");
        float Discount = (float) (devlist.get(i).getPrice() * DiscountItem) / 100;
        System.out.println("The discount is: "+ Discount);
        cost = devlist.get(i).getPrice()- Discount;
        System.out.println("The cost is: "+ cost);
    } //The method that shows the discount and the cost of the wanted item

    public static void OrderDone(){
        LocalDate current = LocalDate.now();
        for (int i = 0; i < orderlist.size(); i++) {
            if (orderlist.get(i).getCode()==order){
                orderlist.get(i).setPending(false);
                salelist.add(new Sale(salecode,orderlist.get(i).getModel(),current,orderlist.get(i).getCost(),orderlist.get(i).getName(),orderlist.get(i).getSurname(),orderlist.get(i).getPhonenumber()));
                salecode++;
                orderlist.remove(i);
                System.out.println("The order has been completed!\n");
            }
        }
    } //The method that completes the order

    public static void CustomerInfo(){
        Scanner input = new Scanner(System.in);
        // Validate name
        System.out.print("Enter name: ");
        custname = input.nextLine();
        while (custname.isEmpty() || !custname.matches("[a-zA-Z]+")) {
            System.out.println("\nInvalid name!\nYou must enter a name\nEnter your name:\n");  
            custname = input.nextLine();
        }

        // Validate surname
        System.out.print("Enter surname: ");
        custsurname = input.nextLine();
        while (custsurname.isEmpty() || !custsurname.matches("[a-zA-Z]+")) {
            System.out.println("\nInvalid surname!\nYou must enter a surname\nEnter your surname:\n");
            custsurname = input.nextLine();
        }

        // Validate number
        System.out.print("Enter number: ");
        String numberInput = input.nextLine();
        while (numberInput.isEmpty() || !numberInput.matches("\\d+")) {
            System.out.println("\nInvalid number!\nYou must enter a number\nEnter your number:\n");
            numberInput = input.nextLine();
        }
        phonenumber = Integer.parseInt(numberInput);
    }//The method that takes the customer's information and validates the information
    
    

    public static void MainMenuUI(){
        Scanner input = new Scanner(System.in);
        System.out.println("---------Main Menu---------" + "\n" + "1. Overview of all available devices" + "\n"
                + "2. Overview of all orders" + "\n" + "3. Overview of all sales" + "\n" + "0. Exit");
        option = input.nextInt();
    }

    public static void ShowOrderList(){
        for (int i = 0; i < orderlist.size(); i++) {
            System.out.println("-------Order's Information-------");
            System.out.println(orderlist.get(i));
        }
    }
    public static void ShowSaleList(){
        for (int i = 0; i < salelist.size(); i++) {
            System.out.println("-------Sale's Information-------");
            System.out.println(salelist.get(i));
        }
    }
    public static void SearchList() {
        LocalDate currentDate = LocalDate.now();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < devlist.size(); i++) {
            if (devlist.get(i).getCategory().equalsIgnoreCase(category) && devlist.get(i).getMaintype().equalsIgnoreCase(type) && devlist.get(i).getModel().equalsIgnoreCase(name)) {
                System.out.println("-------Device's Information-------");
                System.out.println(devlist.get(i));
                if (devlist.get(i).getQuantity()>0){
                    System.out.println("The following item is available! Do you want to buy it?(1. Yes – 2. No).");
                    int ans=input.nextInt();
                    input.nextLine();
                    if (ans==1){
                        CustomerInfo();
                        if (devlist.get(i).getCategory().equalsIgnoreCase("Picture And Sound")){
                            DiscountShow(DiscountPS, i);
                        }else if (devlist.get(i).getCategory().equalsIgnoreCase("Gaming")){
                            DiscountShow(DiscountG, i);
                        }else if (devlist.get(i).getCategory().equalsIgnoreCase("Home Appliances")){
                            DiscountShow(DiscountHA, i);
                        }
                        salelist.add(new Sale(salecode,devlist.get(i).getModel(),currentDate,cost,custname,custsurname,phonenumber));
                        salecode++;
                        devlist.get(i).setQuantity(devlist.get(i).getQuantity()-1);
                        System.out.println("Your sale has been completed!\n");
                    }
                }else{
                    LocalDate estimatedDate = currentDate.plusDays(5);
                    if( estimatedDate.getDayOfWeek().getValue()==6 || estimatedDate.getDayOfWeek().getValue()==7){
                        estimatedDate=estimatedDate.plusDays(2);
                    }
                    System.out.println("The following item is not available!");
                    System.out.println("Do you want to order it?(1. Yes – 2. No).");
                    int ans=input.nextInt();
                    input.nextLine();
                    if (ans==1){
                        CustomerInfo();
                        if (devlist.get(i).getCategory().equalsIgnoreCase("Picture And Sound")){
                            DiscountShow(DiscountPS, i);
                        }else if (devlist.get(i).getCategory().equalsIgnoreCase("Gaming")){
                            DiscountShow(DiscountG, i);
                        }else if (devlist.get(i).getCategory().equalsIgnoreCase("Home Appliances")){
                            DiscountShow(DiscountHA, i);
                        }
                        System.out.println("Your order has been placed and it will be completed in 5 days!\n");
                        orderlist.add(new Order(ordercode,devlist.get(i).getModel(),currentDate,estimatedDate, cost, custname,custsurname,phonenumber,pending));
                        ordercode++;
                    }

                }
            }

        }
    }
    public static void SetDevices(){
        // Create and add instances of different devices to the devlist
        devlist.add(new Camera("DSLR", 24, 5, 2, "135mm x 90mm x 70mm", "CAM001", "Alpha-5000", 2019, "Sony", 899, 3));
        devlist.add(new Camera("Action", 24, 10, 2, "150mm x 120mm x 70mm", "CAM003", "Go Pro", 2021, "Go Pro", 1099, 2));
        devlist.add(new Camera("Compact", 36, 4, 3, "125mm x 85mm x 65mm", "CAM002", "Eos R6", 2022, "Canon", 2499, 4));
        devlist.add(new DVD("Blu-ray", 1080, "BD-R", "BR001", "The Avengers", 2012, " Marvel Studios", 109, 5));
        devlist.add(new DVD("Blu-ray", 1080, "BD-R", "BR002", "The Avengers: Age of Ultron", 2015, " Marvel Studios", 119, 2));
        devlist.add(new DVD("DVD", 720, "DVD-RW", "DVD001", "The Lord of the Rings", 2001, " New Line Cinema", 99, 3));
        devlist.add(new DVD("DVD", 720, "DVD-RW", "DVD002", "The Lord of the Rings: The Two Towers", 2002, " New Line Cinema", 99, 1));
        devlist.add(new Fridge("Single Door", "A++", 400, 200, "FR001", "Fridge 1", 2019, "Samsung", 999, 4));
        devlist.add(new Fridge("French Door", "A++", 300, 100, "FR002", "Fridge 2", 2020, "LG", 899, 13));
        devlist.add(new Fridge("Double Door", "A++", 500, 300, "FR003", "Fridge 3", 2021, "Bosch", 1099, 0));
        devlist.add(new TV("LCD", 32, 1080, "HDMI", "TV001", "LCD TV 1", 2018, "Samsung", 299, 7));
        devlist.add(new TV("PLASMA", 70, 2160, "HDMI", "TV002", "PLASMA TV 1", 2020, "LG", 899, 1));
        devlist.add(new TV("LED", 50, 2160, "HDMI", "TV003", "LED TV 1", 2021, "Sony", 999, 0));
        devlist.add(new Console("Console", "AMD Ryzen 5 3600", "AMD Radeon RX 5700 XT", "Dolby Digital", 1000, "CON001",
                "Playstation 5", 2020, "Sony", 499, 17));
        devlist.add(new Console("Console", "AMD Ryzen 5 3600", "AMD Radeon RX 5700 XT", "Dolby Digital", 1000,
                "CON002", "Xbox Series X", 2020, "Microsoft", 499, 21));
        devlist.add(new Console("Console", "AMD Ryzen 5 3600", "AMD Radeon RX 5700 XT", "Dolby Digital",1500, "CON003", "Playstation 4", 2013, "Sony", 399, 3));
        devlist.add(new Console("Remote Console", "	ARM 4 Cortex-A57", "	NVIDIA Custom Tegra processor", "Dolby Digital", 1000, "RECON001", "Nintendo Switch", 2017, "Nintendo", 299, 0));
        devlist.add(new Console("Remote Console","Qualcomm Snapdragon 720G", "Adreno 618 GPU", "Dolby Digital", 1000, "RECON002", "Logitech G Cloud", 2018, "Logitech", 59, 3));
        devlist.add(new WashingMachine( "A+++", 8, 1400, "WM001", "Front Load", 2019, "Samsung", 499, 2));
        devlist.add(new WashingMachine( "A+++", 10, 1200, "WM002", "Top Load", 2020, "LG", 399, 0));
    }
    public static void main(String[] args) {
        SetDevices();
        Scanner input = new Scanner(System.in);
        MainMenuUI();
        while (option != 0) {
            boolean f1=false;
            boolean f2=false;
            if (option == 1) {
                System.out.println("Give the category of the device you want to search for."+"\n"+"\n"+"Categories: Picture And Sound, Gaming, Household Appliances\n");
                category = input.nextLine();
                if(category.equalsIgnoreCase("Picture And Sound")|| category.equalsIgnoreCase("Gaming")|| category.equalsIgnoreCase("Household Appliances")){
                    System.out.println("The types for this category are\n");
                    if(category.equalsIgnoreCase("Picture And Sound")){
                        System.out.println("- Camera\n- DVD / Blu-Ray\n- TV");
                    } else if (category.equalsIgnoreCase("Gaming")) {
                        System.out.println("- Console / Remote Console");
                    } else if (category.equalsIgnoreCase("Household Appliances")){
                        System.out.println("- Fridge\n- Washing Machine");
                    }
                    System.out.println();
                    System.out.println("Give the type of the device you want to search for");
                    type = input.nextLine();
                    for (int i = 0; i < devlist.size(); i++) {
                        if (devlist.get(i).getMaintype().equalsIgnoreCase(type)){
                            f1=true;
                            break;
                        }
                    }
                    if (f1){
                        System.out.println("The models for this type are\n");
                        for (int i = 0; i < devlist.size(); i++) {
                            if (devlist.get(i).getCategory().equalsIgnoreCase(category) && devlist.get(i).getMaintype().equalsIgnoreCase((type))){
                                System.out.println("- "+devlist.get(i).getModel());
                            }
                        }
                        System.out.println();
                        System.out.println("Give the model of the device you want to search for");
                        name = input.nextLine();
                        for (int i = 0; i < devlist.size(); i++) {
                            if (devlist.get(i).getModel().equalsIgnoreCase(name)){
                                f2=true;
                                break;
                            }
                        }
                        if (!f2){
                            System.out.println("Wrong model\n");
                            MainMenuUI();
                            
                        }else {
                            SearchList();
                            MainMenuUI();
                        }
                    }else {
                        System.out.println("Wrong type\n");
                        MainMenuUI();
                    }
                }else {
                    System.out.println("Wrong category\n");
                    MainMenuUI();
                }
            } else if (option == 2) {
                ShowOrderList();
                if(orderlist.size()>0){
                System.out.println("Do you want to complete an order?(1. Yes – 2. No).\n");
                int ans=input.nextInt();
                input.nextLine();
                
                if (ans==1){
                    System.out.println("Choose the order you want to complete:\n");
                    order=input.nextInt();
                    OrderDone();
                }
                }else{
                    System.out.println("There are no orders to complete!\n");
                }
                MainMenuUI();
            } else if (option == 3) {
                ShowSaleList();               if (salelist.size()==0){
                    System.out.println("There are no sales!\n");
                }
                MainMenuUI();
            }
        }
        System.out.println("Exiting...");
        input.close();
    }
}