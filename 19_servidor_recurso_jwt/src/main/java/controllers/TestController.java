package controllers;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@PreAuthorize("hasRole('TEST')")
	@GetMapping(value="test")
	public String prueba(Principal principal) {
		return  "Bienvenido a mi servicio "+principal.getName();
	}
	
	@GetMapping(value="prueba")
	public String probando(){
		return "prueba sin seguridad";
	}
}
