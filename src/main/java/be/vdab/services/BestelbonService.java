package be.vdab.services;

import java.math.BigDecimal;

import javax.persistence.OptimisticLockException;
import javax.persistence.RollbackException;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Bestelregel;
import be.vdab.entities.Mandje;
import be.vdab.filters.JPAFilter;
import be.vdab.repositories.BestelbonRepository;
import be.vdab.valueobjects.Bestelbonlijn;

public class BestelbonService extends AbstractService{

	
	private final BestelbonRepository repo = new BestelbonRepository();
	
	public void createBestelbon(Bestelbon bb) {		
		beginTransaction();
		try {
			repo.createBestelbon(bb);
			commit();
		}catch(RollbackException ex) {
			if (ex.getCause() instanceof OptimisticLockException) {
				throw ex;
				}			
		}catch(RuntimeException ex) {
			rollback();
			throw ex;
		}
		
	}
	
	
	public void voegBestelbonlijnenAanDB(Mandje mandje, Bestelbon bb) {
		
		
		
		beginTransaction();
		
		try {
			
			for(Bestelregel bregel: mandje.getLijnen()) {
				System.out.println("creating nieuwe bestelbonlijn");
				Bestelbonlijn bebolijn = new Bestelbonlijn(bregel.getWijn().getId(), bregel.getAantal(), bregel.getWijn().getPrijs().multiply(BigDecimal.valueOf(Long.valueOf(bregel.getAantal()))));
				bb.addBestelbonlijn(bebolijn);
			}				
		commit();		
		}catch(OptimisticLockException ex){
			rollback();
			throw ex;
		}catch(RuntimeException ex) {
			rollback();
			throw ex;
		}
	
}

}
