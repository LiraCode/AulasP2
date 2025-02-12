package entities;

public class Product {
     private String name;
     private double price;
     int quantity;

    public Product(String name, double price, int quantity) {
       setName(name);
        setPrice(price);
        this.quantity = quantity;
    }
    public Product(String name, double price) {
        this(name, price, 0);

    }
    public double totalValueInStock() {
        return this.quantity * this.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
