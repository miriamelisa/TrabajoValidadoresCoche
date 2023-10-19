package edu.cesur.fullstack.services;

import java.util.ArrayList;
import edu.cesur.fullstack.model.Persona;

public interface PersonaService {
	
	public ArrayList<Persona> getAllPersonas();
	
	public Persona savePersona(Persona persona);
	
	//
	
	

}
