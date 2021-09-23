package com.kruger.app.dao;

import com.kruger.app.dto.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IEmpleadoDAO extends JpaRepository<Empleado, Long> {

    @Modifying
    @Query(value = "update Empleado em set em.apellidos= ?1, em.nombres= ?2, em.direccion_domicilio=?3, " +
            "em.correo=?4, em.telefono=?5 where em.id=?6")
    void updateEmpleado(String apellidos, String nombres, String direccion_domicilio,
                        String correo, Long telefono, Long id);
}
