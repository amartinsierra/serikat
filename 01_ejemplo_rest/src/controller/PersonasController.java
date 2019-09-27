package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Persona;

@RestController
public class PersonasController {
	
	@GetMapping(value="lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> recuperarPersonas(){
		List<Persona> personas=new ArrayList<>();
		personas.add(new Persona("persona 1","uno@gmail.com",23));
		personas.add(new Persona("persona 2","dos@gmail.com",45));
		personas.add(new Persona("persona 3","tres@gmail.com",28));
		return personas;
	}
}
