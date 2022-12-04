package br.gov.sp.procon.model;

public class Tarifa {

    private int id;
    private Enum<ServicoPostal> servico;
    private Enum<FaixaPeso> faixaPeso;
    private float valor;

    public Tarifa() {
    }

    public Tarifa(int id, Enum<ServicoPostal> servico, Enum<FaixaPeso> faixaPeso, float valor) {
        this.id = id;
        this.servico = servico;
        this.faixaPeso = faixaPeso;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enum<ServicoPostal> getServico() {
        return servico;
    }

    public void setServico(Enum<ServicoPostal> servico) {
        this.servico = servico;
    }

    public Enum<FaixaPeso> getFaixaPeso() {
        return faixaPeso;
    }

    public void setFaixaPeso(Enum<FaixaPeso> faixaPeso) {
        this.faixaPeso = faixaPeso;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "id=" + id +
                ", servico=" + servico +
                ", faixaPeso=" + faixaPeso +
                ", valor=" + valor +
                '}';
    }
}
