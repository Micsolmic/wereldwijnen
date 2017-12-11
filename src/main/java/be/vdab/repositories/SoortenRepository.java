package be.vdab.repositories;

import java.util.Set;

import be.vdab.entities.Wijn;

public class SoortenRepository extends AbstractRepository{

	
	Set<Wijn> getSoortenPerLand(int landId){
		
		getEntityManager().createNamedQuery("Soorten.inEenLand");
		
		
		
	}
	
	
	
}
