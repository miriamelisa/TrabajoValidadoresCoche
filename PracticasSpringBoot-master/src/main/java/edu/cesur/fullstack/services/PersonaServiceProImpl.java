package edu.cesur.fullstack.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import edu.cesur.fullstack.model.Persona;
import lombok.extern.slf4j.Slf4j;

//@Primary
@Slf4j
@Lazy
@Service("pro")
//@ConditionalOnProperty(prefix ="implementacion", value ="persona", havingValue = "pro")
public class PersonaServiceProImpl implements PersonaService {
	
	ArrayList<Persona> listaPersonasPro = new ArrayList<>(
			Arrays.asList(new Persona(1, "Juan", "Pérez", 25, "", ""), new Persona(2, "María", "Gómez", 30, "", ""),
					new Persona(3, "Pedro", "González", 28, "", ""), new Persona(4, "Anna", "Martínez", 28, "", "")));
	
	public PersonaServiceProImpl() {
		log.info("");
	}

	@Override
	public ArrayList<Persona> getAllPersonas() {
		return listaPersonasPro;
	}

	@Override
	public Persona savePersona(Persona persona) {
		this.listaPersonasPro.add(persona);
		return persona;
	}


}
