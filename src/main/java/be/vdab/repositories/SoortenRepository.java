package be.vdab.repositories;

import java.util.List;

import be.vdab.entities.Soort;

public class SoortenRepository extends AbstractRepository{

	
	public List<Soort> getSoortenPerLand(int landId){
		
		return
		getEntityManager().createNamedQuery("Soorten.inLand")
		.setParameter("land", landId)
		.getResultList();	
		
		
	}
	
	public Soort getSoortMetId(int id) {
		
		
		return
		getEntityManager().find(Soort.class, id);
		
	}
	
	
	
}
