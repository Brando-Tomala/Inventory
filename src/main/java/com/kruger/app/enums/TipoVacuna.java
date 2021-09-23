package com.kruger.app.enums;

public enum TipoVacuna {
    SPUTNIK("sputnik"),
    ASTRAZENECA("astrazeneca"),
    PFIZER("pfizer"),
    JHONSON("jhonson&jhonson");

    private final String getTipoVacunaName;

    TipoVacuna(String statusName) {
        getTipoVacunaName = statusName;
    }

    @Override
    public String toString() {
        return getTipoVacunaName;
    }

}
