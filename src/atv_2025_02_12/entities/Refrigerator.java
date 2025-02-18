package atv_2025_02_12.entities;

public class Refrigerator extends Product{
    private int size;

    public Refrigerator(String name, double price, int size) {
        super(name, price);
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Refrigerator:"+ getBrand()+" Size:"+ getSize() +" Price:"+getPrice();
    }
}
