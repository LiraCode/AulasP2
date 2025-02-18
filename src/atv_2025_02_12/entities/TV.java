package atv_2025_02_12.entities;

public class TV extends Product {
    private int inches;

    public TV(String brand, double price, int inches) {
        super(brand, price);
        this.inches = inches;
    }
    public int getInches() {
        return inches;
    }

    @Override
    public String toString() {

        return "TV: " + getBrand() + " inches" + getInches() + " - Price" + getPrice();
    }
}
