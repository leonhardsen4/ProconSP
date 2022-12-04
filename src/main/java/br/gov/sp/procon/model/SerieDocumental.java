package br.gov.sp.procon.model;

public class SerieDocumental {

    private int id;
    private String serieDocumental;
    private String funcao;
    private String subFuncao;
    private String atividade;
    private String documento;
    private int prazoGuardaUP;
    private int prazoGuardaUA;
    private String destinacao;
    private String observacoes;

    public SerieDocumental() {
    }

    public SerieDocumental(int id, String serieDocumental, String funcao, String subFuncao, String atividade, String documento, int prazoGuardaUP, int prazoGuardaUA, String destinacao, String observacoes) {
        this.id = id;
        this.serieDocumental = serieDocumental;
        this.funcao = funcao;
        this.subFuncao = subFuncao;
        this.atividade = atividade;
        this.documento = documento;
        this.prazoGuardaUP = prazoGuardaUP;
        this.prazoGuardaUA = prazoGuardaUA;
        this.destinacao = destinacao;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerieDocumental() {
        return serieDocumental;
    }

    public void setSerieDocumental(String serieDocumental) {
        this.serieDocumental = serieDocumental;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSubFuncao() {
        return subFuncao;
    }

    public void setSubFuncao(String subFuncao) {
        this.subFuncao = subFuncao;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getPrazoGuardaUP() {
        return prazoGuardaUP;
    }

    public void setPrazoGuardaUP(int prazoGuardaUP) {
        this.prazoGuardaUP = prazoGuardaUP;
    }

    public int getPrazoGuardaUA() {
        return prazoGuardaUA;
    }

    public void setPrazoGuardaUA(int prazoGuardaUA) {
        this.prazoGuardaUA = prazoGuardaUA;
    }

    public String getDestinacao() {
        return destinacao;
    }

    public void setDestinacao(String destinacao) {
        this.destinacao = destinacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Temporalidade{" +
                "id=" + id +
                ", serieDocumental='" + serieDocumental + '\'' +
                ", funcao='" + funcao + '\'' +
                ", subFuncao='" + subFuncao + '\'' +
                ", atividade='" + atividade + '\'' +
                ", documento='" + documento + '\'' +
                ", prazoGuardaUP=" + prazoGuardaUP +
                ", prazoGuardaUA=" + prazoGuardaUA +
                ", destinacao='" + destinacao + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
