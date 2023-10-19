package edu.cesur.fullstack.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstack.model.Persona;
import edu.cesur.fullstack.services.PersonaService;
import edu.cesur.fullstack.services.PersonaServiceImpl;
import edu.cesur.fullstack.validators.OnCreate;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/personas")
public class PersonaRestController {

	ArrayList<Persona> listaPersonas = new ArrayList<>(
			Arrays.asList(new Persona(1, "Juan", "Pérez", 25, "", ""), new Persona(2, "María", "Gómez", 30, "", ""),
					new Persona(3, "Pedro", "González", 28, "", ""), new Persona(4, "Anna", "Martínez", 28, "", "")));

	// @Autowired DI - Caso 1. No recomendado ya que dificulta las pruebas unitarias
	PersonaService personaService;

	// DI - caso 2. Recomendado por las pruebas unitarias
	// Si uso la desambiguación por properties, debo quitar el qualifier
	public PersonaRestController(@Qualifier("generales") PersonaService personaService) {
		this.personaService = personaService;

	}

	// EndPoints
	@GetMapping
	public ResponseEntity<?> getPersonas() {
		ArrayList<Persona> listaPersonas = personaService.getAllPersonas();
		return ResponseEntity.ok(listaPersonas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPersona(@PathVariable int id) {

		if (id < 0) {
			return ResponseEntity.badRequest().build();
		}

		for (Persona p : listaPersonas) {
			if (p.getId() == id) {
				return ResponseEntity.ok(p);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> createPersona(@RequestBody @Validated(OnCreate.class) Persona persona) {
		//listaPersonas.add(persona);
		Persona newPerson = this.personaService.savePersona(persona);

		// recupera la ruta actual del endpoint y retorna la url del nuevo recurso.
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(persona.getId())
				.toUri();

		return ResponseEntity.created(location).build(); //opción sin devolver el recurso creado
		//return ResponseEntity.created(location).body(newPerson); //opción devolviendo tb el recurso creado.
		//return new ResponseEntity<>(persona, HttpStatus.CREATED); usando HttpStatus directamente (implementación más antigua)

	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletePersona(@PathVariable int id) {

		if (id < 0) {
			return ResponseEntity.badRequest().build();
		}

		for (Persona p : new ArrayList<>(listaPersonas)) {
			if (p.getId() == id) {
				listaPersonas.remove(p);
				return ResponseEntity.noContent().build();
			}

		}

		return ResponseEntity.notFound().build();

	}

	@PutMapping
	public ResponseEntity<?> updatePersona(@RequestBody @Validated Persona persona) {
		for (Persona p : listaPersonas) {
			if (p.getId() == persona.getId()) {
				p.setName(persona.getName());
				p.setLastName(persona.getLastName());
				p.setAge(persona.getAge());

				return ResponseEntity.ok(p);
			}
		}

		return ResponseEntity.notFound().build();
	}

}
