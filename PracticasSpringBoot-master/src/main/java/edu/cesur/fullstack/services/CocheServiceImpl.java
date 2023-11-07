package edu.cesur.fullstack.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import edu.cesur.fullstack.model.Coche;
import edu.cesur.fullstack.persistence.entities.CocheEntity;
import edu.cesur.fullstack.persistence.repositories.CocheRepository;

@Service
public class CocheServiceImpl implements CocheService {

	CocheRepository cocheRepository;
	public CocheServiceImpl(CocheRepository cocheRepository){
		this.cocheRepository=cocheRepository;
	}
	
	
	@Override
	public Coche getCoche(Integer id) {
		/*if (id > 0)
			return new Coche(id, "Audi", "Modelo1");*/
		Optional<CocheEntity> optional=cocheRepository.findById(id);
		if(optional.isPresent()) {
			CocheEntity cocheE=optional.get();
			
			Coche c= new Coche();
			c.setId(cocheE.getId());
			c.setName(cocheE.getName());
			
			return c;
		}
		
		
		return null;
	}

	@Override
	public Coche createCoche(Coche c) {
		
		return c;
	}

}
