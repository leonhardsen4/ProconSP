package br.gov.sp.procon.model;

public class Portador extends Pessoa {
    private String cnh;
    private String modeloMoto;
    private String placaMoto;

    public Portador() {
    }

    public Portador(int id, String nome, String telefone, String email, String cnh, String modeloMoto, String placaMoto) {
        super(id, nome, telefone, email);
        this.cnh = cnh;
        this.modeloMoto = modeloMoto;
        this.placaMoto = placaMoto;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getModeloMoto() {
        return modeloMoto;
    }

    public void setModeloMoto(String modeloMoto) {
        this.modeloMoto = modeloMoto;
    }

    public String getPlacaMoto() {
        return placaMoto;
    }

    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
    }

    @Override
    public String toString() {
        return "Portador{" +
                "cnh='" + cnh + '\'' +
                ", modeloMoto='" + modeloMoto + '\'' +
                ", placaMoto='" + placaMoto + '\'' +
                '}';
    }
}
