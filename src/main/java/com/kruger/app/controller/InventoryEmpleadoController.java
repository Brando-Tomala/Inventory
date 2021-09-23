package com.kruger.app.controller;

import com.kruger.app.model.InfoEmpleadoReq;
import com.kruger.app.model.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/empleado")
@Api(tags = "Interfaz para Empleado", produces = "application/json", consumes = "application/json")
public class InventoryEmpleadoController implements IInventoryEmpleadoController{

    @Override
    @ApiOperation("API para obtener la informacion del empleado")
    @GetMapping("/{user}")
    public ResponseEntity<Response> getInfo(@PathVariable String user) {
        return null;
    }

    @Override
    @ApiOperation("API para actualizar informacion del empleado")
    @PostMapping("/{user}")
    public ResponseEntity<Response> updateInfo(@PathVariable String user, @Valid @RequestBody InfoEmpleadoReq request) {
        return null;
    }
}
