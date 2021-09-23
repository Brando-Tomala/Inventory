package com.kruger.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoReq {

    @NotNull(message = "Parametro dni no debe ser null")
    @Size(min = 10, max = 10, message = "Parametro dni debe tener 10 digitos")
    private String dni;

    @NotNull(message = "Parametro nombre no debe ser null")
    private String nombres;

    @NotNull(message = "Parametro apellidos no debe ser null")
    private String apellidos;

    @NotNull
    @Email(regexp = "^(.+)@(.+)$", message = "Correo invalido")
    private String correo;

}
