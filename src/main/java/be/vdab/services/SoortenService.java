package be.vdab.services;

import java.util.List;

import be.vdab.entities.Soort;
import be.vdab.repositories.SoortenRepository;

public class SoortenService extends AbstractService{

	
	SoortenRepository repo = new SoortenRepository();
	
	public List<Soort> getSoortenPerLand(int landId){		
		
		return repo.getSoortenPerLand(landId);
		
	}
	
	public Soort getSoortMetId(int id) {
		
		return repo.getSoortMetId(id);
	}
	
	
}
