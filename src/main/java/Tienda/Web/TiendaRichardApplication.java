package Tienda.Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TiendaRichardApplication {

	public static void main(String[] args) {

		String rawPassword = "pedro789";
		String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
		System.out.println("Contraseña en texto plano: " + rawPassword);
		System.out.println("Contraseña encriptada (BCrypt): " + encodedPassword);
		SpringApplication.run(TiendaRichardApplication.class, args);

	}
}


/* 
UPDATE usuario
SET password = '$2a$10$r1L2SjjuVmrf.j3sqpxQDOCzrvH6L/EIT0a1SeutmCq0N54UjWe0O'
WHERE username = 'pedro';
*/