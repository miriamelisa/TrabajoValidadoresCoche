package edu.cesur.fullstack.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstack.exceptions.CocheNotFoundException;
import edu.cesur.fullstack.model.Coche;
import edu.cesur.fullstack.services.CocheService;

@RestController
@RequestMapping("/coches")
public class CocheRestController {

	CocheService cocheService;

	public CocheRestController(CocheService cocheService) {
		this.cocheService = cocheService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCocheById( @PathVariable Integer id) {
		if (cocheService.getCoche(id) != null)
			return ResponseEntity.ok(cocheService.getCoche(id));

		throw new CocheNotFoundException("No existe un coche con ese id");
	}
	
	@PostMapping
	public ResponseEntity<?> saveCoche(@RequestBody @Validated Coche coche) {
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(coche.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(cocheService.createCoche(coche));
		
	}

}
