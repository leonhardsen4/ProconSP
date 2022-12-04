package br.gov.sp.procon.model;

public class Servidor extends Pessoa {

    private int idSetor;
    private Enum<Cargo> cargo;

    public Servidor() {
    }

    public Servidor(int id,
                    String nome,
                    String telefone,
                    String email,
                    int idSetor,
                    Enum<Cargo> cargo) {
        super(id, nome, telefone, email);
        this.idSetor = idSetor;
        this.cargo = cargo;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public Enum<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(Enum<Cargo> cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Servidor{" +
                "idSetor=" + idSetor +
                ", cargo=" + cargo +
                '}';
    }
}
