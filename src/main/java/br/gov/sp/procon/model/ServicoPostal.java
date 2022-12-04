package br.gov.sp.procon.model;

public enum ServicoPostal {

    CARTA_SIMPLES("Carta Simples"),
    CARTA_REGISTRADA("Carta Registrada"),
    CARTA_VIA_INTERNET("Carta Via Internet"),
    E_CARTA("E-Carta"),
    TELEGRAMA("Telegrama"),
    SEDEX("Sedex"),
    SEDEX_10("Sedex 10"),
    SEDEX_12("Sedex 12"),
    SEDEX_HOJE("Sedex Hoje"),
    PAC("PAC"),
    DOCUMENTO_PRIORITARIO("Documento Prioritário");

    private final String servicoPostal;

    ServicoPostal(String servicoPostal) {
        this.servicoPostal = servicoPostal;
    }

    public String getServicoPostal() {
        return servicoPostal;
    }

    @Override
    public String toString() {
        return "ServicoPostal{" +
                "servicoPostal='" + servicoPostal + '\'' +
                '}';
    }
}
