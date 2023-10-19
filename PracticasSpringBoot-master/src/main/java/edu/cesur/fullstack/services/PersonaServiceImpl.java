package edu.cesur.fullstack.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import edu.cesur.fullstack.model.Persona;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Primary
@Service("generales")
//@ConditionalOnProperty(prefix ="implementacion", value ="persona", havingValue = "generaless")
public class PersonaServiceImpl implements PersonaService {
	
	ArrayList<Persona> listaPersonas = new ArrayList<>(
			Arrays.asList(new Persona(1, "Juan", "Pérez", 25, "", ""), new Persona(2, "María", "Gómez", 30, "", ""),
					new Persona(3, "Pedro", "González", 28, "", ""), new Persona(4, "Anna", "Martínez", 28, "", "")));

	
	public PersonaServiceImpl() {
		log.info("Creado bean PersonaServiceImpl");
	}
	
	@Override
	public ArrayList<Persona> getAllPersonas() {
		return listaPersonas;
	}

	@Override
	public Persona savePersona(Persona persona) {
		this.listaPersonas.add(persona);
		return persona;
	}


}
