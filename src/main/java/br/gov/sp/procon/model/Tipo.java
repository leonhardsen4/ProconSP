package br.gov.sp.procon.model;

public enum Tipo {

    OFICIO("Ofício"),
    EXPEDIENTE("Expediente"),
    PROCESSO("Processo"),
    RELACAO_DE_REMESSA("Relação de Remessa"),
    MALOTE("Malote"),
    REQUISICAO("Requisição"),
    REQUERIMENTO("Requerimento"),
    CERTIDAO("Certidão"),
    ENVELOPE("Envelope"),
    PACOTE("Pacote"),
    NOTA_DE_FORNECIMENTO("Nota de Fornecimento");

    private final String tipo;

    Tipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
