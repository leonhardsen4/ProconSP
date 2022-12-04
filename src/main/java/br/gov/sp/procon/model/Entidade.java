package br.gov.sp.procon.model;

import java.util.List;

public class Entidade {

    private int id;
    private String nome;
    private List<Endereco> listaEndereco;
    private List<Setor> listaSetores;

    public Entidade() {
    }

    public Entidade(int id, String nome, List<Endereco> listaEndereco, List<Setor> listaSetores) {
        this.id = id;
        this.nome = nome;
        this.listaEndereco = listaEndereco;
        this.listaSetores = listaSetores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome.toUpperCase();
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public List<Setor> getListaSetores() {
        return listaSetores;
    }

    public void setListaSetores(List<Setor> listaSetores) {
        this.listaSetores = listaSetores;
    }

    @Override
    public String toString() {
        return "Entidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", listaEndereco=" + listaEndereco +
                ", listaSetores=" + listaSetores +
                '}';
    }

}
