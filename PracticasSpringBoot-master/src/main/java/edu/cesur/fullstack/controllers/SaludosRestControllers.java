package edu.cesur.fullstack.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.cesur.fullstack.model.Persona;
import jakarta.websocket.server.PathParam;

@RestController
public class SaludosRestControllers {
	
	
	@GetMapping("/saludo")
	public String saluda() {
		return "Hello Spring";
	}
	
	
	@GetMapping("/saludo/{nombre}/{apellido}")
	public String saludaPorNombre(@PathVariable String nombre, @PathVariable String apellido) {
		return "Hola, " + nombre +  " " + apellido;
	}
	


}
