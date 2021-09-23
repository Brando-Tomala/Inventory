package com.kruger.app.mapper;

import com.kruger.app.dto.Empleado;
import com.kruger.app.model.EditAdminEmpleadoReq;
import com.kruger.app.model.EmpleadoReq;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    Empleado empleadoReqToEmpleado(EmpleadoReq empleadoReq);

    Empleado empleadoEditReqToEmpleado(EditAdminEmpleadoReq empleadoEditReq);
}
