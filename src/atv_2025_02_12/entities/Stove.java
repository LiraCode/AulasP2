package atv_2025_02_12.entities;

public class Stove extends Product {
    private int burnes;

    public Stove(String name, double price, int burnes) {
        super(name, price);
        this.burnes = burnes;
    }
    public int getBurnes() {
        return burnes;
    }

    @Override
    public String toString() {
        return "Stove: " + getBrand() + " - Price" + getPrice() + " Burnes" + getBurnes();
}
}

