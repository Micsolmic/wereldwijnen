package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Bestelbonlijn implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int bonid;
	private int wijnid;
	private int aantal;
	private BigDecimal prijs;
	
	Bestelbonlijn(){}
	Bestelbonlijn(int bonid, int wijnid, int aantal){
		
		
		
		
	}
}
