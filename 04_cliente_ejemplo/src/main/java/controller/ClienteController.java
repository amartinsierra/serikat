package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Persona;
@RestController
public class ClienteController {
	@Autowired
	RestTemplate template; //para interaccionar con el servicio de personas
	@GetMapping(value="personas/{nombre}/{email}/{edad}",produces=MediaType.APPLICATION_JSON_VALUE)	
	public Persona[] procesar(@PathVariable("nombre") String nombre, 
								@PathVariable("email") String email, 
								@PathVariable("edad") int edad){
		String url="http://172.17.0.1:5000";
		Persona persona=new Persona(nombre,email,edad);
		template.postForLocation(url+"/lista", persona);
		Persona[] personas= template.getForObject(url+"/lista", Persona[].class);
		return personas;
	}
}
