package be.vdab.repositories;

import be.vdab.entities.Bestelbon;

public class BestelbonRepository extends AbstractRepository{

	public void createBestelbon(Bestelbon bb) {
		
		getEntityManager().persist(bb);
		
	}
	
	
	
}
