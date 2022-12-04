package br.gov.sp.procon.model;

import java.time.LocalDateTime;

public class Documento {

    private int id;
    private String referencia;
    private String assunto;
    private Entidade interessado;
    private Servidor solicitante;
    private Enum<Tipo> tipoDocumento;
    private String observacoes;
    private LocalDateTime dataCriacao;
    private LocalDateTime horaCriacao;
    private String status;

    public Documento() {
    }

    public Documento(int id, String referencia, String assunto, Entidade interessado, Servidor solicitante, Enum<Tipo> tipoDocumento, String observacoes, LocalDateTime dataCriacao, LocalDateTime horaCriacao, String status) {
        this.id = id;
        this.referencia = referencia;
        this.assunto = assunto;
        this.interessado = interessado;
        this.solicitante = solicitante;
        this.tipoDocumento = tipoDocumento;
        this.observacoes = observacoes;
        this.dataCriacao = dataCriacao;
        this.horaCriacao = horaCriacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Entidade getInteressado() {
        return interessado;
    }

    public void setInteressado(Entidade interessado) {
        this.interessado = interessado;
    }

    public Servidor getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Servidor solicitante) {
        this.solicitante = solicitante;
    }

    public Enum<Tipo> getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Enum<Tipo> tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getHoraCriacao() {
        return horaCriacao;
    }

    public void setHoraCriacao(LocalDateTime horaCriacao) {
        this.horaCriacao = horaCriacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "id=" + id +
                ", referencia='" + referencia + '\'' +
                ", assunto='" + assunto + '\'' +
                ", interessado=" + interessado +
                ", solicitante=" + solicitante +
                ", tipoDocumento=" + tipoDocumento +
                ", observacoes='" + observacoes + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", horaCriacao=" + horaCriacao +
                ", status='" + status + '\'' +
                '}';
    }


}
