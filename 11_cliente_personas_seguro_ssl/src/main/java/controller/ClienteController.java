package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Curso;
import model.Persona;
@RestController
public class ClienteController {
	static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

                    public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                        return hostname.equals("localhost");
                    }
                });
    }
	@Autowired
	RestTemplate template; //para interaccionar con el servicio de personas
	@GetMapping(value="personas/{nombre}/{email}/{edad}",produces=MediaType.APPLICATION_JSON_VALUE)	
	public Persona[] procesar(@PathVariable("nombre") String nombre, 
								@PathVariable("email") String email, 
								@PathVariable("edad") int edad){
		String url="https://localhost:9000";
		Persona persona=new Persona(nombre,email,edad);
		template.postForLocation(url+"/lista", persona);
		Persona[] personas= template.getForObject(url+"/lista", Persona[].class);
		return personas;
		//return template.getForObject("https://localhost:9000/lista", Persona[].class);
	}
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso[] cursos() {
		return template.getForObject("https://localhost:9000/escuela/cursos", Curso[].class);
	}
}
