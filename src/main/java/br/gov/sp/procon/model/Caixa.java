package br.gov.sp.procon.model;

import java.time.LocalDateTime;
import java.util.List;

public class Caixa {

    private int id;
    private int idArquivo;
    private String status;
    private LocalDateTime ano;
    private int qtdDocumentos;
    private List<Documento> listaDocumentos;
    private String observacoes;

    public Caixa() {
    }

    public Caixa(int id, int idArquivo, String status, LocalDateTime ano, int qtdDocumentos, List<Documento> listaDocumentos, String observacoes) {
        this.id = id;
        this.idArquivo = idArquivo;
        this.status = status;
        this.ano = ano;
        this.qtdDocumentos = qtdDocumentos;
        this.listaDocumentos = listaDocumentos;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getAno() {
        return ano;
    }

    public void setAno(LocalDateTime ano) {
        this.ano = ano;
    }

    public int getQtdDocumentos() {
        return qtdDocumentos;
    }

    public void setQtdDocumentos(int qtdDocumentos) {
        this.qtdDocumentos = qtdDocumentos;
    }

    public List<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "CaixaProcesso{" +
                "id=" + id +
                ", idArquivo=" + idArquivo +
                ", status='" + status + '\'' +
                ", ano=" + ano +
                ", qtdProcessos=" + qtdDocumentos +
                ", listaDocumentos=" + listaDocumentos +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
