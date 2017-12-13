package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import be.vdab.entities.Wijn;

@Embeddable
public class Bestelbonlijn implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int bonid;
	private int wijnid;
	private int aantal;
	private BigDecimal prijs;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "wijnid", insertable=false, updatable=false)
	private Wijn wijn;
	
	
	
	public Bestelbonlijn(){}
	public Bestelbonlijn(int wijnid, int aantal){		
		
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
	public int getBonid() {
		return bonid;
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
	public Wijn getWijn() {
		System.out.println("tothier");
		return wijn;
	}
	public void setBonid(int bonid) {
		this.bonid = bonid;
	}
	public void setWijnid(int wijnid) {
		this.wijnid = wijnid;
	}
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	public void setWijn(Wijn wijn) {
		this.wijn = wijn;
	}
	
	
}
