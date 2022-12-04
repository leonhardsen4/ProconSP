package br.gov.sp.procon.model;

public enum FaixaPeso {

    ATE_20("Até 20 gramas"),
    DE_21_ATE_50("De 21 até 50 gramas"),
    DE_51_ATE_100("De 51 até 100 gramas"),
    DE_101_ATE_150("De 101 até 150 gramas"),
    DE_151_ATE_200("De 151 até 200 gramas"),
    DE_201_ATE_250("De 201 até 250 gramas"),
    DE_251_ATE_300("De 251 até 300 gramas"),
    DE_301_ATE_350("De 301 até 350 gramas"),
    DE_351_ATE_400("De 351 até 400 gramas"),
    DE_401_ATE_450("De 401 até 450 gramas"),
    DE_451_ATE_500("De 451 até 500 gramas"),
    ACIMA_DE_500("Acima de 500 gramas");

    private final String faixaPeso;

    FaixaPeso(String faixaPeso) {
        this.faixaPeso = faixaPeso;
    }

    public String getFaixaPeso() {
        return faixaPeso;
    }

    @Override
    public String toString() {
        return "FaixaPeso{" +
                "faixaPeso='" + faixaPeso + '\'' +
                '}';
    }
}
