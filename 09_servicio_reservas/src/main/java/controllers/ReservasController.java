package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Reserva;
@RestController
public class ReservasController {
	List<Reserva> reservas;
	@Autowired
	RestTemplate template;
	@PostConstruct
	public void init() {
		reservas=new ArrayList<>();
		/*reservas.add(new Reserva(1,"cliente 1","23244A",1,3));
		reservas.add(new Reserva(2,"paco","288745S",2,4));
		reservas.add(new Reserva(3,"ana","6735Y",3,1));
		reservas.add(new Reserva(4,"jose","9965R",2,2));
		reservas.add(new Reserva(5,"mar","8866w",4,2));*/
	}
	@PostMapping(value="reservar/{plazas}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void reservar(@RequestBody Reserva reserva, @PathVariable("plazas") int plazas) {
		reservas.add(reserva);
		template.put("http://servicio-vuelos/vuelos/"+reserva.getVuelo()+"/"+plazas,null);
		
	}
	
	@GetMapping(value="reservas",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> reservas(){
		return reservas;
	}
}
