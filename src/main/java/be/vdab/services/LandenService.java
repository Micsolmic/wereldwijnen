package be.vdab.services;

import java.util.List;

import be.vdab.entities.Land;
import be.vdab.repositories.LandenRepository;

public class LandenService extends AbstractService {

	
	private final LandenRepository repo = new LandenRepository();
	
	
	List<Land> getLandenMetId(int id){
		
		return repo.getLandmetId(id);
		
	}
	
}
