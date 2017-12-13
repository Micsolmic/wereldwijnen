package be.vdab.repositories;

import java.util.List;

import be.vdab.entities.Land;

public class LandenRepository extends AbstractRepository {

	public List<Land> getLandmetNaam(String naam){
		
		 return 
		 getEntityManager().createNamedQuery("Landen.metNaam", Land.class)
		.setParameter("landNaam", naam)
		.getResultList();
		
		
	}	
	
	public Land getLandmetId(int id){
		
		 System.out.println("TOT HIER ************************************************");
		 return 
		 getEntityManager().createNamedQuery("Landen.metId", Land.class)
		.setParameter("id", id)
		.getSingleResult();
		
		
	}	
	
	
}
