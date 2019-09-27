package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
@RestController
public class VuelosController {
	List<Vuelo> vuelos;
	@PostConstruct
	public void init() {
		vuelos=new ArrayList<>();
		vuelos.add(new Vuelo(1,"iberia",120.4,11));
		vuelos.add(new Vuelo(2,"air france",90.8,7));
		vuelos.add(new Vuelo(3,"vueling",88.7,10));
		vuelos.add(new Vuelo(4,"air europa",110,3));
	}
	@GetMapping(value="vuelos/{plazas}")
	public List<Vuelo> vuelosDisponibles(@PathVariable("plazas") int plazas){
		List<Vuelo> disponibles=new ArrayList<>();
		for(Vuelo v:vuelos) {
			if(v.getPlazas()>=plazas) {
				disponibles.add(v);
			}
		}
		return disponibles;
	}
	@PutMapping(value="vuelos/{idVuelo}/{plazas}")
	public void actualizarPlazas(@PathVariable("idVuelo") int idVuelo,@PathVariable("plazas") int plazas) {
		for(Vuelo v:vuelos) {
			if(v.getIdVuelo()==idVuelo) {
				v.setPlazas(v.getPlazas()-plazas);
			}
		}
	}
}
