package atv_2025_02_17.entities;

// Classe abstrata Pessoa
public abstract class Pessoa {
    private String nome;
    private double rendaAnual;

    abstract double calculaContribuicao();

    public Pessoa(String nome, double rendaAnual) {
        setNome(nome);
        setRenda(rendaAnual);
    }

    public String getNome() {
        return nome;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRenda(double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }
}