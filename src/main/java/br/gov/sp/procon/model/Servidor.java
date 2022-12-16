package br.gov.sp.procon.model;

public class Servidor extends Pessoa {

    private int idUnidade;
    private Enum<Cargo> cargo;

    public Servidor() {
    }

    public Servidor(int id,
                    String nome,
                    String telefone,
                    String email,
                    int idUnidade,
                    Enum<Cargo> cargo) {
        super(id, nome, telefone, email);
        this.idUnidade = idUnidade;
        this.cargo = cargo;
    }

    public int getidUnidade() {
        return idUnidade;
    }

    public void setidUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Enum<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(Enum<Cargo> cargo) {
        this.cargo = cargo;
    }

}
