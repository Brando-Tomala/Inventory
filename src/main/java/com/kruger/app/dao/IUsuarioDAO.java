package com.kruger.app.dao;

import com.kruger.app.dto.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
    public Usuario findByUsuario(String user);
}