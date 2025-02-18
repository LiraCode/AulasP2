package atv_2025_02_10.application;
import atv_2025_02_10.entities.Product;
import atv_2025_02_10.entities.ShoppingCart;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise1 {
    public static void shoppingCartMenu(ShoppingCart myShoppingCart, ArrayList<Product> dbProducts) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 7) {
        option = getOption(sc);
            
        String brand;
            switch (option) {
                case 1:
                    System.out.println("Enter product brand:");
                    brand = sc.nextLine();
                    for (Product product : dbProducts) {
                        if (product.getBrand().equals(brand)) {
                            myShoppingCart.addProduct(product);
                            break;
                        }
                    }
                    System.out.println("Product not Found!");
                    break;
                case 2:
                    System.out.println("Enter product brand to remove:");
                    brand = sc.nextLine();
                    for (Product product : dbProducts) {
                        if (product.getBrand().equals(brand)) {
                            myShoppingCart.removeProduct(product);
                            break;
                        }
                    }
                    System.out.println("Product not Found!");
                    break;
                case 3:
                    System.out.println("Cart contents:");
                    myShoppingCart.getContents();
                    break;
                case 4:
                    System.out.println("Enter product brand to get count:");
                    brand = sc.nextLine();
                    for (Product product : dbProducts) {
                        if (product.getBrand().equals(brand)) {
                            System.out.println("Quantity of " + product.getBrand() + " is: " + myShoppingCart.getItemCount(product));
                            break;
                        }
                    }
                    System.out.println("Product not Found!");
                    break;
                case 5:
                    if (myShoppingCart.getTotalPrice() > 0) {
                        System.out.println("Total price: " + myShoppingCart.getTotalPrice());
                    } else {
                        System.out.println("Your shopping cart is empty!");
                    }
                    break;
                case 6:
                    System.out.println("Customer ID: " + myShoppingCart.getCustomerID());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public static int getOption(Scanner sc) {
        int option;
        System.out.println("Welcome to the shopping cart!.");
        System.out.println("1- Add Item to Cart");
        System.out.println("2- Remove Item from Cart");
        System.out.println("3- Display Cart content");
        System.out.println("4- Get Item count from Cart");
        System.out.println("5- Get Total Price from Cart");
        System.out.println("6- Display CustomerID");
        System.out.println("7- Exit");
        System.out.println("Please enter a number to select option:");
        option = sc.nextInt();
        sc.nextLine(); // consume newline
        return option;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Shopping Cart");
        System.out.println("To test, add products to the store");
        String addProduct = "Y";
        ArrayList<Product> products = new ArrayList<>();

        while (addProduct.equalsIgnoreCase("Y")) {
            System.out.println("Enter the product brand: ");
            String brand = sc.nextLine();
            System.out.println("Enter the product price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // consume newline
            Product p = new Product(brand, price);
            products.add(p);
            System.out.println("The product was successfully added!");
            System.out.println("Do you want to add a new product? (Y/N)");
            addProduct = sc.nextLine();
        }

        System.out.println("Do you want to initialize the shopping cart? (Y/N)");
        String initSC = sc.nextLine();
        if (initSC.equalsIgnoreCase("Y")) {
            System.out.println("Enter the CustomerID: ");
            int customerID = sc.nextInt();
            sc.nextLine(); // consume newline
            ShoppingCart myShoppingCart = new ShoppingCart(customerID, products);
            shoppingCartMenu(myShoppingCart, products);
        } else {
            System.out.println("Ending the program!");
            System.exit(0);
        }
    }
}