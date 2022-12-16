package br.gov.sp.procon.model;

import java.util.List;

public class Unidade {

    private int id;
    private int idEntidade;
    private int idEnderecoEntidade;
    private String unidade;
    private List<Servidor> listaServidores;

    public Unidade() {
    }

    public Unidade(int id, int idEntidade, int idEnderecoEntidade, String unidade, List<Servidor> listaServidores) {
        this.id = id;
        this.idEntidade = idEntidade;
        this.idEnderecoEntidade = idEnderecoEntidade;
        this.unidade = unidade;
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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public List<Servidor> getListaServidores() {
        return listaServidores;
    }

    public void setListaServidores(List<Servidor> listaServidores) {
        this.listaServidores = listaServidores;
    }

}
