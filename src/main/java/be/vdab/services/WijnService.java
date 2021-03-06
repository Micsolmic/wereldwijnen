package be.vdab.services;

import be.vdab.entities.Wijn;
import be.vdab.repositories.WijnRepository;

public class WijnService extends AbstractService {

	private final WijnRepository repo = new WijnRepository();
	
	public Wijn getWijnMetId(int id) {
		
		return repo.getWijnMetId(id);
		
	}
}
