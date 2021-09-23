package com.kruger.app.controller;

import com.kruger.app.model.EditAdminEmpleadoReq;
import com.kruger.app.model.EmpleadoReq;
import com.kruger.app.model.Response;
import com.kruger.app.services.IEmpleadoServ;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/empleado")
@Api(tags = "Interfaz para Administrador", produces = "application/json", consumes = "application/json")
public class InventoryAdminController implements IInventoryAdminController {

    @Autowired
    IEmpleadoServ empleadoServ;

    @Override
    @ApiOperation("API para registrar los empleados")
    @PostMapping
    public ResponseEntity<Response> registrarEmpleado(@Valid @RequestBody EmpleadoReq request) {

        return empleadoServ.guardarEmpleado(request);
    }

    @Override
    @ApiOperation("API para editar empleados")
    @PutMapping("/{id}")
    public ResponseEntity<Response> editarEmpleado(@PathVariable("id") Long id, @RequestBody EditAdminEmpleadoReq request) {
        return empleadoServ.editarEmpleado(id, request);
    }

    @Override
    @ApiOperation("API para obetener los empleados")
    @GetMapping
    public ResponseEntity<Response> listarEmpleado() {

        return empleadoServ.listarEmpleados();
    }

    @Override
    @ApiOperation("API para eliminar empleado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> eliminarEmpleado(@PathVariable("id") Long id) {

        return empleadoServ.eliminarEmpleado(id);
    }
}
