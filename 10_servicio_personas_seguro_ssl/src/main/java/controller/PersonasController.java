package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Persona;

@RestController
public class PersonasController {
	List<Persona> personas;
	@PostConstruct
	public void init() {
		personas=new ArrayList<>();
		personas.add(new Persona("persona 1","uno@gmail.com",23));
		personas.add(new Persona("persona 2","dos@gmail.com",45));
		personas.add(new Persona("persona 3","tres@gmail.com",28));
	}
	@GetMapping(value="lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> recuperarPersonas(){		
		return personas;
	}
	@GetMapping(value="lista/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona buscarPersona(@PathVariable("email") String email) {
		for(Persona p:personas) {
			if(p.getEmail().equals(email)) {
				return p;
			}
		}
		return null;
	}
	@PostMapping(value="lista",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void agregarPersona(@RequestBody Persona p) {
		personas.add(p);
	}
	
	@DeleteMapping(value="lista/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> eliminarPersona(@PathVariable("email") String email){
		for(int i=0;i<personas.size();i++) {
			if(personas.get(i).getEmail().equals(email)) {
				personas.remove(i);
			}
		}
		return personas;
	}
}
