package atv_2025_02_12.entities;

import java.util.ArrayList;

public class ShoppingCart {
    int CustomerID;
    ArrayList<Product> products;

    public ShoppingCart(int CustomerID, ArrayList<Product> products) {
        this.CustomerID = CustomerID;
        this.products = products;
    }
    public ShoppingCart(int CustomerID) {
        this.CustomerID = CustomerID;
        this.products = new ArrayList<>();

    }

    public void addProduct(Product product) {
      products.add(product);
    }

    public void removeProduct(Product product) {
       products.remove(product);

    }

    public int getCustomerID() {
        return CustomerID;
    }


    public void getContents() {
        System.out.println(this.products);
    }


    public int getItemCount(Product product) {
        int count = 0;
        for (Product products : products){
            if (products.equals(product)){
                count++;
             }
        }
        return count;
        }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product products : products){
            totalPrice += products.getPrice();
        }
        return totalPrice;
    }

}
