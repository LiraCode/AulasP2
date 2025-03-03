package atv_2025_02_26.application;

import atv_2025_02_26.models.entities.Account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise4 {
    public static int scanInt() {
        int value = -1;
        while (value < 0) {
            try {
                Scanner sc = new Scanner(System.in);
                value = sc.nextInt();
                if (value < 0) {
                    throw new NegativeException();
                }
            } catch (InputMismatchException | NegativeException e) {
                System.out.println(e.getMessage());
            }
        }
        return value;
    }

    public static double scanDouble() {
        double value = -1.0;
        while (value < 0) {
            try {
                Scanner sc = new Scanner(System.in);
                value = sc.nextDouble();
                if (value < 0.0) {
                    throw new NegativeException();
                }
            } catch (InputMismatchException | NegativeException e) {
                System.out.println("Error: Please enter only positive numbers and \",\"");
            }
        }
        return value;
    }

    public static String scanString() {
        String value = null;
        while (value == null ||  value.isEmpty()) {
            try {
                Scanner sc = new Scanner(System.in);
                value = sc.nextLine();
                if (value == null|| value.equals(" ") || value.isEmpty()) {
                    throw new EmptyString();
                }
            } catch (EmptyString e) {
                System.out.println(e.getMessage());

            }
        }
        return value;
    }
    public static void main(String[] args) {
        System.out.println("My OOP Bank - Account");
        System.out.println("Welcome to My OOP Bank Manager");
        System.out.println("Enter account Data");
        System.out.print("Number:");
        int account = scanInt();
        System.out.print("Holder:");
        String holder = scanString();
        System.out.print("Initial Balance:");
        double balance = scanDouble();
        System.out.print("Withdraw limit:");
        int withdrawLimit = scanInt();
        Account myAccount = new Account(account, holder, balance, withdrawLimit);

        int option = 0;
        while (option != 3) {
            System.out.println();
            System.out.println("Select Option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Exit");
            option = scanInt();
            switch (option) {
                case 1:
                    System.out.print("Enter amount for withdraw: ");
                    double valueWithDraw = scanDouble();
                    myAccount.withdraw(valueWithDraw);
                    break;

                case 2:
                    System.out.print("Enter amount for deposit: ");
                    double valueDeposit = scanDouble();
                    myAccount.deposit(valueDeposit);
                    System.out.println("New Balance: " + myAccount.getBalance());
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Invalid Option");
                    System.out.println();
                    System.out.println("Select Option:");
                    System.out.println("1. Withdraw");
                    System.out.println("2. Deposit");
                    System.out.println("3. Exit");
                    option = scanInt();


            }

        }
        System.out.println("Exiting Program...");
        System.exit(0);

    }

    static class EmptyString extends Exception {
        public EmptyString() {
            super("Error: this field is not be empty");
        }
    }
    static class NegativeException extends Exception {
        public NegativeException() {
            super("Error: please enter a positive integer");
        }
    }


}
