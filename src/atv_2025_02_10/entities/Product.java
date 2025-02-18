package atv_2025_02_10.entities;

public class Product {
     private String brand;
     private double price;

    public Product(String brand, double price) {
       setBrand(brand);
        setPrice(price);
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
@Override
public String toString(){
    return ("Product: " + getBrand() + " Price: " + getPrice());
}
}
