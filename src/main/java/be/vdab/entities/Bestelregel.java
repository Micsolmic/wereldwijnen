package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Bestelregel implements Serializable{

	private static final long serialVersionUID = 1L;
	
 	
	private int aantal;
	private Wijn wijn;
		
	
	public Bestelregel(){}
	public Bestelregel(int aantal, Wijn wijn){		
		this.aantal = aantal;	
		this.wijn = wijn;
	}
	public int getAantal() {
		return aantal;
	}
	public Wijn getWijn() {
		return wijn;
	}
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
	public void setWijn(Wijn wijn) {
		this.wijn = wijn;
	}
	
	
	
	
	
	
	
}
