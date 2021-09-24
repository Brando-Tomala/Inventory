package com.kruger.app;

import com.kruger.app.dao.IUsuarioDAO;
import com.kruger.app.dto.Usuario;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KrugerInventoryApplication {
	@Autowired
	IUsuarioDAO usuarioDAO;

	public static void main(String[] args) {
		SpringApplication.run(KrugerInventoryApplication.class, args);
	}

	@Bean
	InitializingBean insertAdmin(){
		return ()->{
			Usuario user= usuarioDAO.findByUsuario("kruger");
			if(user==null) {
				Usuario usuario = new Usuario("kruger", "admin", "ADMIN");
				usuarioDAO.save(usuario);
			}
		};
	}

}
