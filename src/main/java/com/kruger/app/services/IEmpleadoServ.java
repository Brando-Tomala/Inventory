package com.kruger.app.services;

import com.kruger.app.dto.Usuario;
import com.kruger.app.model.EditAdminEmpleadoReq;
import com.kruger.app.model.EmpleadoReq;
import com.kruger.app.model.Response;
import org.springframework.http.ResponseEntity;

public interface IEmpleadoServ {

    ResponseEntity<Response> guardarEmpleado(EmpleadoReq request);

    ResponseEntity<Response> listarEmpleados();

    ResponseEntity<Response> editarEmpleado(Long id, EditAdminEmpleadoReq request);

    ResponseEntity<Response> eliminarEmpleado(Long id);

    Usuario generaDatosAuth(String apellidos, String nombres, String dni);

}
