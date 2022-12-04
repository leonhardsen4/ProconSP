package br.gov.sp.procon.model;

public enum NivelAcesso {

    ADMINISTRADOR("Administrador"),
    USUÁRIO("Usuário"),
    CONSULTA("Consulta");

    private final String acesso;

    NivelAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getAcesso() {
        return acesso;
    }

    @Override
    public String toString() {
        return "NivelAcesso{" +
                "acesso='" + acesso + '\'' +
                '}';
    }
}

