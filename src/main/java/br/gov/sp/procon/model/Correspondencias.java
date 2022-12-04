package br.gov.sp.procon.model;

public class Correspondencias extends Documento{

    private int idGuiaPostagem;
    private Enum<ServicoPostal> servico;
    private String registro;
    private int peso;
    private int qtd;
    private float preco;

    public Correspondencias() {
    }

    public Correspondencias(int idGuiaPostagem, Enum<ServicoPostal> servico, String registro, int peso, int qtd, float preco) {
        this.idGuiaPostagem = idGuiaPostagem;
        this.servico = servico;
        this.registro = registro;
        this.peso = peso;
        this.qtd = qtd;
        this.preco = preco;
    }

    public int getIdGuiaPostagem() {
        return idGuiaPostagem;
    }

    public void setIdGuiaPostagem(int idGuiaPostagem) {
        this.idGuiaPostagem = idGuiaPostagem;
    }

    public Enum<ServicoPostal> getServico() {
        return servico;
    }

    public void setServico(Enum<ServicoPostal> servico) {
        this.servico = servico;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Correspondencias{" +
                "idGuiaPostagem=" + idGuiaPostagem +
                ", servico=" + servico +
                ", registro='" + registro + '\'' +
                ", peso=" + peso +
                ", qtd=" + qtd +
                ", preco=" + preco +
                '}';
    }
}
