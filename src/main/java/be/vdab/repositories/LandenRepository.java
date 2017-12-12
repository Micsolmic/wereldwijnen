package be.vdab.repositories;

import java.util.List;

import be.vdab.entities.Land;

public class LandenRepository extends AbstractRepository {

	public List<Land> getLandmetNaam(String naam){
		
		 return 
		 getEntityManager().createNamedQuery("Landen.metNaam")
		.setParameter("landNaam", naam)
		.getResultList();
		
		
	}	
	
	public List<Land> getLandmetId(int id){
		
		 return 
		 getEntityManager().createNamedQuery("Landen.metId")
		.setParameter("id", id)
		.getResultList();
		
		
	}	
	
	
}
