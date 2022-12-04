package br.gov.sp.procon.model;

public enum Cargo {

    DIRETOR_EXECUTIVO("Diretor Executivo"),
    CHEFE_DE_GABINETE("Chefe de Gabinete"),
    ASSESSOR_CHEFE("Assessor Chefe"),
    ASSESSOR_TECNICO("Assessor Técnico"),
    DIRETOR("Diretor"),
    COORDENADOR("Coordenador"),
    SUPERVISOR("Supervisor"),
    ESPECIALISTA_EM_PROTECAO_E_DEFESA_DO_CONSUMIDOR("Especialista em Proteção e Defesa do Consumidor"),
    TECNICO_EM_PROTECAO_E_DEFESA_DO_CONSUMIDOR("Técnico em Proteção e Defesa do Consumidor"),
    TECNICO_DE_INFORMATICA("Técnico de Informática"),
    ANALISTA_DE_TECNOLOGIA_DA_INFORMACAO_E_COMUNICACAO("Analista de Tecnologia da Informação e Comunicação"),
    ANALISTA_ADMINISTRATIVO("Analista Administrativo"),
    AUXILIAR_ADMINISTRATIVO("Auxiliar Administrativo"),
    AUXILIAR_DE_MANUTENCAO("Auxiliar de Manutenção"),
    TECNICO_DE_SUPORTE_ADMINISTRATIVO("Técnico de Suporte Administrativo III");

    private final String cargo;
    Cargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargo='" + cargo + '\'' +
                '}';
    }
}
