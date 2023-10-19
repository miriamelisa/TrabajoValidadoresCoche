package edu.cesur.fullstack.services;

import edu.cesur.fullstack.model.Coche;

public interface CocheService {
	
	Coche getCoche(Integer id);
	
	Coche createCoche(Coche c);

}
