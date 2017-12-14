package be.vdab.valueobjects;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Bestelbonlijn {


	int wijnid;
	int aantal;
	BigDecimal prijs;
	
	public Bestelbonlijn() {}
	
	
	public Bestelbonlijn(int wijnid, int aantal, BigDecimal prijs) {
	
		this.wijnid = wijnid;
		this.aantal = aantal;
		this.prijs = prijs;		
	}


	

	public int getWijnid() {
		return wijnid;
	}


	public int getAantal() {
		return aantal;
	}


	public BigDecimal getPrijs() {
		return prijs;
	}

	
}



