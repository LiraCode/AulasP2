package atv_2025_02_17;


import atv_2025_02_17.entities.Leao;
import atv_2025_02_17.entities.PF;
import atv_2025_02_17.entities.PJ;
import atv_2025_02_17.entities.Pessoa;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Leao myTaxes = new Leao();
       int qtdContribuintes;
        System.out.print("Enter the number of tax payers:");
        Scanner sc = new Scanner(System.in);
        qtdContribuintes = sc.nextInt();
        String name;
        String type;
        double anualIncome;
        int count=1;
       while (qtdContribuintes >= count) {
           System.out.println("Tax payer #" + count +" data:");
           System.out.print("Individual or Company (i/c): ");
           type = sc.next();

           if (type.equalsIgnoreCase("i") || type.equalsIgnoreCase("c")){
               System.out.print("Name: ");
               name = sc.next();
               System.out.print("Anual Income: ");
               anualIncome = sc.nextDouble();
               count++;

               switch (type){
                   case "i":
                       System.out.print("Health expenditures: ");
                       double healthExpenditures = sc.nextDouble();
                       Pessoa person = new PF(name, anualIncome, healthExpenditures);
                       myTaxes.addPayer(person);
                       break;

                   case "c":
                       System.out.print("Number of employees: ");
                       int employees = sc.nextInt();
                       Pessoa company = new PJ(name,anualIncome, employees);
                       myTaxes.addPayer(company);
                       break;

               }
           }else {
               System.out.println("Invalid Input - Please try again");
           }



       }
        System.out.println();
           myTaxes.calcularContribuicoes();

    }
}
