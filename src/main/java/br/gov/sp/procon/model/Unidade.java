package br.gov.sp.procon.model;

import javafx.collections.ObservableList;

import java.util.List;

public class Unidade {

    private int id;
    private int idEntidade;
    private int enderecoEntidade;
    private String unidade;
    private List<Servidor> listaServidores;

    public Unidade() {
    }

    public Unidade(int id, int idEntidade, int enderecoEntidade, String unidade, List<Servidor> listaServidores) {
        this.id = id;
        this.idEntidade = idEntidade;
        this.enderecoEntidade = enderecoEntidade;
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

    public int getEnderecoEntidade() {
        return enderecoEntidade;
    }

    public void setEnderecoEntidade(int enderecoEntidade) {
        this.enderecoEntidade = enderecoEntidade;
    }

    public String getUnidade() {
        return unidade.toUpperCase();
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade.toUpperCase();
    }

    public List<Servidor> getListaServidores() {
        return listaServidores;
    }

    public void setListaServidores(List<Servidor> listaServidores) {
        this.listaServidores = listaServidores;
    }


}
