package br.gov.sp.procon.model;

import java.time.LocalDateTime;
import java.util.List;

public class Arquivo {

    private int id;
    private String nome;
    private LocalDateTime ano;
    private int qtdCaixas;
    private int qtdDocumentos;
    private List<Caixa> listaCaixas;
    private String observacoes;

    public Arquivo() {
    }

    public Arquivo(int id, String nome, LocalDateTime ano, int qtdCaixas, int qtdDocumentos, List<Caixa> listaCaixas, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.qtdCaixas = qtdCaixas;
        this.qtdDocumentos = qtdDocumentos;
        this.listaCaixas = listaCaixas;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getAno() {
        return ano;
    }

    public void setAno(LocalDateTime ano) {
        this.ano = ano;
    }

    public int getQtdCaixas() {
        return qtdCaixas;
    }

    public void setQtdCaixas(int qtdCaixas) {
        this.qtdCaixas = qtdCaixas;
    }

    public int getQtdDocumentos() {
        return qtdDocumentos;
    }

    public void setQtdDocumentos(int qtdDocumentos) {
        this.qtdDocumentos = qtdDocumentos;
    }

    public List<Caixa> getListaCaixas() {
        return listaCaixas;
    }

    public void setListaCaixas(List<Caixa> listaCaixas) {
        this.listaCaixas = listaCaixas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Arquivo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                ", qtdCaixas=" + qtdCaixas +
                ", qtdPtocessos=" + qtdDocumentos +
                ", listaCaixas=" + listaCaixas +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
