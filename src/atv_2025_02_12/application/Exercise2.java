package atv_2025_02_12.application;

import atv_2025_02_12.entities.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2 {
    public static void shoppingCartMenu(ShoppingCart myShoppingCart, ArrayList<Product> dbProducts) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 7) {
            option = getOption(sc);
            String brand;
            boolean found;
            switch (option) {
                case 1:
                    System.out.println("Enter product brand:");
                    brand = sc.nextLine();
                    found = false;
                    for (Product p : dbProducts) {
                        if (p.getBrand().equals(brand)) {
                            myShoppingCart.addProduct(p);
                            System.out.println("Product added: " + p);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product not Found!");
                    }
                    break;
                case 2:
                    System.out.println("Enter product brand to remove:");
                    brand = sc.nextLine();
                    found = false;
                    for (Product product : dbProducts) {
                        if (product.getBrand().equals(brand)) {
                            myShoppingCart.removeProduct(product);
                            System.out.println("Product removed: " + product);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product not Found!");
                    }
                    break;
                case 3:
                    System.out.println("Cart contents:");
                    myShoppingCart.getContents();
                    break;
                case 4:
                    System.out.println("Enter product brand to get count:");
                    brand = sc.nextLine();
                    found = false;
                    for (Product product : dbProducts) {
                        if (product.getBrand().equals(brand)) {
                            System.out.println("Quantity of " + product.getBrand() + " is: " + myShoppingCart.getItemCount(product));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product not Found!");
                    }
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

    public static int getType(Scanner sc) {
        int type;
        System.out.println("Product Add, type selector");
        System.out.println("1- TV");
        System.out.println("2- Stove");
        System.out.println("3- Refrigerator");
        type = sc.nextInt();
        sc.nextLine(); // consume newline
        return type;
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
            int type = getType(sc);
            while (type < 1 || type > 3) {
                System.out.println(type);
                type = getType(sc);
            }
            switch (type) {
                case 1:
                    System.out.println("Enter the TV inches: ");
                    int inches = sc.nextInt();
                    sc.nextLine(); // consume newline
                    Product tv = new TV(brand, price, inches);
                    products.add(tv);
                    System.out.println("TV added to the store");
                    break;
                case 2:
                    System.out.println("Enter the Stove burners: ");
                    int burners = sc.nextInt();
                    sc.nextLine(); // consume newline
                    Product stove = new Stove(brand, price, burners);
                    products.add(stove);
                    System.out.println("Stove added to the store");
                    break;
                case 3:
                    System.out.println("Enter the Refrigerator size: ");
                    int size = sc.nextInt();
                    sc.nextLine(); // consume newline
                    Product refrigerator = new Refrigerator(brand, price, size);
                    products.add(refrigerator);
                    System.out.println("Refrigerator added to the store");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println("Do you want to add a new product? (Y/N)");
            addProduct = sc.next();
            sc.nextLine(); // consume newline
        }

        System.out.println("Do you want to initialize the shopping cart? (Y/N)");
        String initSC = sc.next();
        if (initSC.equalsIgnoreCase("Y")) {
            int customerID = 0;
            boolean wasError = false;
            do {
                try {
                    System.out.println("Enter the CustomerID: (numbers only).");
                    customerID = sc.nextInt();
                    sc.nextLine(); // consume newline
                    if (customerID == 0) {
                        wasError = true;
                        System.out.println("Customer ID is not valid. Please try again.");
                    } else if (customerID > 0) {
                        wasError = false;
                    }
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Invalid input. Numbers only, please try again.");
                    wasError = true;
                    sc.nextLine(); // consume newline
                }
            } while (wasError);

            ShoppingCart myShoppingCart = new ShoppingCart(customerID);
            shoppingCartMenu(myShoppingCart, products);
        } else {
            System.out.println("Ending the program!");
            System.exit(0);
        }
    }
}
