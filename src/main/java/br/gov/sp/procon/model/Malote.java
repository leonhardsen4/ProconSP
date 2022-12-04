package br.gov.sp.procon.model;

import java.time.LocalDateTime;
import java.util.List;

public class Malote {

    private int id;
    private int idRemessa;
    private int numero;
    private String percurso;
    private String observacoes;
    private List<Documento> listaDocumentos;
    private float peso;
    private float valor;

    public Malote() {
    }

    public Malote(int id, int numero, String percurso, String observacoes, List<Documento> listaDocumentos, LocalDateTime dataMovimento, String movimento, int idRemessa, float peso, float valor) {
        this.id = id;
        this.numero = numero;
        this.percurso = percurso;
        this.observacoes = observacoes;
        this.listaDocumentos = listaDocumentos;
        this.idRemessa = idRemessa;
        this.peso = peso;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPercurso() {
        return percurso;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public int getIdRemessa() {
        return idRemessa;
    }

    public void setIdRemessa(int idRemessa) {
        this.idRemessa = idRemessa;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Malote{" +
                "id=" + id +
                ", idRemessa=" + idRemessa +
                ", numero=" + numero +
                ", percurso='" + percurso + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", listaDocumentos=" + listaDocumentos +
                ", peso=" + peso +
                ", valor=" + valor +
                '}';
    }
}
