package atv_2025_02_17.entities;

public class PF  extends Pessoa  {
    private double gastoSaude;

    public PF(String nome, double rendaAnual, double gastoSaude) {
        super(nome, rendaAnual);
        setGastoSaude(gastoSaude);
    }

    @Override
    double calculaContribuicao() {
        double valor = super.getRendaAnual();
        double saude = (getGastoSaude()/2);
        double aliquota = (valor>20000.00)? 0.25 : 0.15;
        return ((valor*aliquota)-saude);


    }

    public double getGastoSaude() {
        return gastoSaude;
    }
    public void setGastoSaude(double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }


}

