package entities;

import java.util.ArrayList;

public class ShoppingCart {
    int CustomerID;
    ArrayList<Product> products;
    int[] productQuantity;

    public ShoppingCart(int CustomerID, ArrayList<Product> products, int[] productQuantity) {
        this.CustomerID = CustomerID;
        this.products = products;
        this.productQuantity = productQuantity;
    }
    public ShoppingCart(int CustomerID) {
        this.CustomerID = CustomerID;
        this.products = new ArrayList<>();
        this.productQuantity = new int[100];

    }

    public void addProduct(Product product) {
        int index = products.indexOf(product);
        if (index != -1) {
            productQuantity[index]++;
            System.out.println("More one " + product.getName() + " added to shopping cart");
        } else {
            products.add(product);
            productQuantity[products.indexOf(product)] = 1;
            System.out.println(product.getName() + " added to shopping cart");
        }
    }

    public void removeProduct(Product product) {
        int index = products.indexOf(product);
        if (index != -1) {
            if (productQuantity[index] > 1) {
                productQuantity[index]--;
                System.out.println("One " + product.getName() + " removed from shopping cart");
            } else {
                products.remove(index);
                System.out.println(product.getName() + " removed from shopping cart");
            }
        } else {
            System.out.println("Not have " + product.getName() + " in the shopping cart");
        }
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    public String getContents() {
        StringBuilder contents = new StringBuilder();
        for (Product product : products) {
            contents.append(productQuantity[products.indexOf(product)]).append(" - ")
                    .append(product.getName()).append(", ");
        }
        return contents.toString();
    }

    public int getItemCount(Product product) {
        int index = products.indexOf(product);
        if (index != -1) {
            return productQuantity[index];
        }
        return 0;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.getPrice() * productQuantity[products.indexOf(p)];
        }
        return totalPrice;
    }
}