package be.vdab.repositories;

import be.vdab.entities.Wijn;

public class WijnRepository extends AbstractRepository{

	
	public Wijn getWijnMetId(int id) {
		
		return getEntityManager().find(Wijn.class, id);
		
	}
	
	
}
