package atv_2025_02_17.entities;
import java.text.DecimalFormat;

import java.util.ArrayList;

public class Leao {
    private final ArrayList<Pessoa> contribuintes;

    public Leao() {
        this.contribuintes = new ArrayList<>();
    }


    public void addPayer(Pessoa p) {
        this.contribuintes.add(p);
    }

    public void calcularContribuicoes(){
        double total = 0;
        System.out.println("TAXES PAID:");
        for (Pessoa p : this.contribuintes) {
            double tax = p.calculaContribuicao();
            total += tax;
            System.out.println(p.getNome()+": $ "+new DecimalFormat("#,##0.00").format(tax));
        }
            System.out.println();
        System.out.println("TOTAL TAXES: $ "+new DecimalFormat("#,##0.00").format(total));
    }
}
