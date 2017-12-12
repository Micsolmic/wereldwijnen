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
		this.bonid = bonid;
		this.wijnid = wijnid;
		this.aantal = aantal;		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bonid;
		result = prime * result + ((prijs == null) ? 0 : prijs.hashCode());
		result = prime * result + wijnid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Bestelbonlijn))
			return false;
		Bestelbonlijn other = (Bestelbonlijn) obj;
		if (bonid != other.bonid)
			return false;
		if (prijs == null) {
			if (other.prijs != null)
				return false;
		} else if (!prijs.equals(other.prijs))
			return false;
		if (wijnid != other.wijnid)
			return false;
		return true;
	}
	
	
}
