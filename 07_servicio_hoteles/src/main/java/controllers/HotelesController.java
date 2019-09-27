package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
@RestController
public class HotelesController {
	List<Hotel> hoteles;
	@PostConstruct
	public void init() {
		hoteles=new ArrayList<>();
		hoteles.add(new Hotel(1,"real",4,100,true));
		hoteles.add(new Hotel(2,"plaza",4,89.5,true));
		hoteles.add(new Hotel(3,"insider",3,59,false));
		hoteles.add(new Hotel(4,"beds",3,80.4,true));
	}
	@GetMapping(value="/hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hotelesDisponibles(){
		List<Hotel> disponibles=new ArrayList<>();
		for(Hotel h:hoteles) {
			if(h.isDisponible()) {
				disponibles.add(h);
			}
		}
		return disponibles;
	}
}
