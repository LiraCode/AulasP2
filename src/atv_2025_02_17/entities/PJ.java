package atv_2025_02_17.entities;

public class PJ extends Pessoa {
    private int funcionarios;


    public PJ(String nome, double rendaAnual, int funcionarios) {
        super(nome, rendaAnual);
        setFuncionarios(funcionarios);
    }

    public int getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(int funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    double calculaContribuicao() {
        double valor = super.getRendaAnual();
        double aliquota = (getFuncionarios() > 10) ? 0.14 : 0.16;
        return (valor*aliquota);


    }
}
