package edu.cesur.fullstack.services;

import org.springframework.stereotype.Service;

import edu.cesur.fullstack.model.Coche;

@Service
public class CocheServiceImpl implements CocheService {

	@Override
	public Coche getCoche(Integer id) {
		if (id > 0)
			return new Coche(id, "Audi", "Modelo1");
		
		return null;
	}

	@Override
	public Coche createCoche(Coche c) {
		
		return c;
	}

}
