package com.kruger.app.dao;

import com.kruger.app.dto.Empleado;
import com.kruger.app.dto.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@Repository
public interface IEmpleadoDAO extends JpaRepository<Empleado, Long> {

    @Modifying
    @Query(value = "UPDATE Empleado em SET em.apellidos= ?1, em.nombres= ?2, em.direccionDomicilio=?3, " +
            "em.correo=?4, em.telefono=?5, em.fechaNacimiento=?6 WHERE em.id=?6")
    void updateEmpleado(String apellidos, String nombres, String direccion_domicilio,
                        String correo, String telefono, Date fechaNacimiento, Long id);

    @Modifying
    @Query(value = "UPDATE Empleado em SET em.fechaNacimiento=?1, em.direccionDomicilio=?2, em.telefono=?3 " +
            "WHERE em.id=?4")
    void editEmpleado(Date fechaNacimiento, String direccionDomicilio, String telefono, Long id);

    Empleado findByUsuario(Usuario user);

}
