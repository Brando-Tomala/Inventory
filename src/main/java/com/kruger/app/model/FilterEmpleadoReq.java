package com.kruger.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kruger.app.enums.EstadoVacuna;
import com.kruger.app.enums.TipoVacuna;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@ApiModel(description = "Modelo de request para filtrar los empleados", value = "FilterEmpleadoReq")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterEmpleadoReq {

    private EstadoVacuna estadoVacuna;

    private TipoVacuna tipoVacuna;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Date fechaDesde;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Date fechaHasta;
}
