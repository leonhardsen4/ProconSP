package br.gov.sp.procon.model;

import java.time.LocalDateTime;

public class Processo extends Documento {

    private String serieDocumental;
    private LocalDateTime dataArquivamento;
    private LocalDateTime dataEliminacao;
    private int idCaixa;

    public Processo() {
    }

    public Processo(int id, String referencia, String assunto, Entidade interessado, Servidor solicitante, Enum<Tipo> tipoDocumento, String observacoes, LocalDateTime dataCriacao, LocalDateTime horaCriacao, String status, String serieDocumental, LocalDateTime dataArquivamento, LocalDateTime dataEliminacao, int idCaixa) {
        super(id, referencia, assunto, interessado, solicitante, tipoDocumento, observacoes, dataCriacao, horaCriacao, status);
        this.serieDocumental = serieDocumental;
        this.dataArquivamento = dataArquivamento;
        this.dataEliminacao = dataEliminacao;
        this.idCaixa = idCaixa;
    }

    public String getSerieDocumental() {
        return serieDocumental;
    }

    public void setSerieDocumental(String serieDocumental) {
        this.serieDocumental = serieDocumental;
    }

    public LocalDateTime getDataArquivamento() {
        return dataArquivamento;
    }

    public void setDataArquivamento(LocalDateTime dataArquivamento) {
        this.dataArquivamento = dataArquivamento;
    }

    public LocalDateTime getDataEliminacao() {
        return dataEliminacao;
    }

    public void setDataEliminacao(LocalDateTime dataEliminacao) {
        this.dataEliminacao = dataEliminacao;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "serieDocumental='" + serieDocumental + '\'' +
                ", dataArquivamento=" + dataArquivamento +
                ", dataEliminacao=" + dataEliminacao +
                ", idCaixa=" + idCaixa +
                '}';
    }
}
