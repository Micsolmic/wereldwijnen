package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Mandje implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<Bestelregel> lijnen = new ArrayList<>();
	
	
	
	public void lijnToevoegen(Bestelregel lijn) {
		
		lijnen.add(lijn);
				
	}
	
	public List<Bestelregel> getLijnen(){
		
		return lijnen;
		
	}
	
	public BigDecimal berekenTotaal() {
		
		BigDecimal totaalLocal = BigDecimal.ZERO;

		for(Bestelregel br: this.getLijnen()) {			
			BigDecimal tussensomRegel = br.getWijn().getPrijs().multiply(BigDecimal.valueOf(Long.valueOf(br.getAantal())));
			System.out.println(tussensomRegel);
			totaalLocal = totaalLocal.add(tussensomRegel);			
		}
		return totaalLocal;
	}
	
//	public BigDecimal getTotaal() {return totaal;}
	
}
