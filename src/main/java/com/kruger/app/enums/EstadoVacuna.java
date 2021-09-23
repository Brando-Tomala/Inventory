package com.kruger.app.enums;

public enum EstadoVacuna {
    VACUNADO("vacunado"),
    NO_VACUNADO("no_vacunado");

    private final String getEstadoName;

    EstadoVacuna(String estadoName) {
        getEstadoName = estadoName;
    }
    @Override
    public String toString() {
        return getEstadoName;
    }

}
