package br.gov.sp.procon.model;

import java.util.List;

public class Setor {

    private int id;
    private int idEntidade;
    private int idEnderecoEntidade;
    private String setor;
    private String sigla;
    private List<Servidor> listaServidores;

    public Setor() {
    }

    public Setor(int id, int idEntidade, int idEnderecoEntidade, String setor, String sigla, List<Servidor> listaServidores) {
        this.id = id;
        this.idEntidade = idEntidade;
        this.idEnderecoEntidade = idEnderecoEntidade;
        this.setor = setor;
        this.sigla = sigla;
        this.listaServidores = listaServidores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(int idEntidade) {
        this.idEntidade = idEntidade;
    }

    public int getIdEnderecoEntidade() {
        return idEnderecoEntidade;
    }

    public void setIdEnderecoEntidade(int idEnderecoEntidade) {
        this.idEnderecoEntidade = idEnderecoEntidade;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Servidor> getListaServidores() {
        return listaServidores;
    }

    public void setListaServidores(List<Servidor> listaServidores) {
        this.listaServidores = listaServidores;
    }

    @Override
    public String toString() {
        return "Setor{" +
                "id=" + id +
                ", idEntidade=" + idEntidade +
                ", idEnderecoEntidade=" + idEnderecoEntidade +
                ", setor='" + setor + '\'' +
                ", sigla='" + sigla + '\'' +
                ", listaServidores=" + listaServidores +
                '}';
    }
}
