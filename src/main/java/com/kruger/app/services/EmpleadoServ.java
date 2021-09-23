package com.kruger.app.services;

import com.kruger.app.dao.IEmpleadoDAO;
import com.kruger.app.dao.IUsuarioDAO;
import com.kruger.app.dto.Empleado;
import com.kruger.app.dto.Usuario;
import com.kruger.app.mapper.EmpleadoMapper;
import com.kruger.app.model.EditAdminEmpleadoReq;
import com.kruger.app.model.EmpleadoReq;
import com.kruger.app.model.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class EmpleadoServ implements IEmpleadoServ {
    @Autowired
    IEmpleadoDAO empleadoDAO;

    @Autowired
    EmpleadoMapper empleadoMapper;

    @Autowired
    IUsuarioDAO usuarioDAO;


    /**
     * Funcion para guardar los empleados
     *
     * @param request Objeto de tipo EmpleadoReq para registrar en la base
     * @return Status del servicio con la respuesta del formato Response.class
     */
    @Override
    public ResponseEntity<Response> guardarEmpleado(EmpleadoReq request) {

        Response resp = new Response();
        Usuario usuario= null;
        try {
            Long dniValid= Long.parseLong(request.getDni());

            Empleado empleado = empleadoMapper.empleadoReqToEmpleado(request);
            log.info(empleado);

            usuario = this.generaDatosAuth(request.getApellidos(), request.getNombres(), request.getDni());
            empleado.setUsuario(usuario);
            empleadoDAO.save(empleado);
            resp.setCode(200);
            resp.setMessage("OK");
            resp.setResponse(new Usuario(usuario.getUsuario(), request.getDni()));
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (Exception e) {
            if(usuario != null){
                usuarioDAO.delete(usuario);
            }
            log.error(e.getMessage());
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }

    /**
     * Funcion para obtener la lista de empleados
     *
     * @return Status del servicio con la respuesta del formato Response.class
     */
    @Override
    public ResponseEntity<Response> listarEmpleados() {
        Response resp = new Response();
        try {
            List<Empleado> listEmpleado = empleadoDAO.findAll();
            List<Empleado> emplList = listEmpleado.stream().map(empl -> {
                Usuario user = empl.getUsuario();
                if (user != null) {
                    user.setPassword(null);
                    empl.setUsuario(user);
                }
                return empl;
            }).collect(Collectors.toList());

            resp.setCode(200);
            resp.setMessage("OK");
            resp.setResponse(emplList);
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }

    /**
     * Funcion para actualizar el registro de empleados
     *
     * @param id      Identificador de Empleado
     * @param request Objeto con los datos actualizar
     * @return Status del servicio con la respuesta del formato Response.class
     */
    @Override
    public ResponseEntity<Response> editarEmpleado(Long id, EditAdminEmpleadoReq request) {
        Response resp = new Response();
        try {
            Optional<Empleado> empleado = empleadoDAO.findById(id);
            if (empleado.isPresent()) {
                Empleado empl = empleado.get();
                if (request.getApellidos() != null)
                    empl.setApellidos(request.getApellidos());
                if (request.getCorreo() != null)
                    empl.setCorreo(request.getCorreo());
                if (request.getNombres() != null)
                    empl.setNombres(request.getNombres());
                if (request.getTelefono() != null)
                    empl.setTelefono(request.getTelefono());
                if (request.getDireccion_domicilio() != null)
                    empl.setDireccion_domicilio(request.getDireccion_domicilio());

                empleadoDAO.updateEmpleado(empl.getApellidos(), empl.getNombres(), empl.getDireccion_domicilio(),
                        empl.getCorreo(), empl.getTelefono(), id);
                resp.setCode(200);
                resp.setMessage("OK");

            } else {
                resp.setCode(400);
                resp.setMessage("Empleado no encontrado");
            }

            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }

    /**
     * Funcion para eliminar el registro de empleado
     *
     * @param id Identificador de Empleado
     * @return Status del servicio con la respuesta del formato Response.class
     */
    @Override
    public ResponseEntity<Response> eliminarEmpleado(Long id) {
        Response resp = new Response();
        try {
            Optional<Empleado> empleado = empleadoDAO.findById(id);
            if (empleado.isPresent()) {
                Empleado empl = empleado.get();
                empleadoDAO.delete(empl);
                resp.setCode(200);
                resp.setMessage("OK");

            } else {
                resp.setCode(400);
                resp.setMessage("Empleado no encontrado");
            }
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }

    @Override
    public Usuario generaDatosAuth(String apellidos, String nombres, String dni) {
        String apellido = apellidos.split(" ")[0];
        String nombre = nombres.split(" ")[0];

        StringBuilder str = new StringBuilder();
        str.append(nombre.charAt(0)).append(apellido).append(1);
        String user = str.toString();
        log.info(str.toString());
        Usuario usuario = null;
        while (true) {
            usuario = usuarioDAO.findByUsuario(user);
            if (usuario != null) {
                char lastChar = usuario.getUsuario().charAt(usuario.getUsuario().length() - 1);
                int num = Character.getNumericValue(lastChar);
                num++;
                user = user.substring(0, user.length() - 1);
                user += num;
            }else {
                break;
            }
        }

        usuario = new Usuario(user, dni);
        usuario = usuarioDAO.save(usuario);

        return usuario;
    }
}
