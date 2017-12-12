package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import be.vdab.valueobjects.Bestelbonlijn;



@Table(name = "wijnen")
@Entity
public class Wijn implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;	
	private int soortid;
	private int jaar;
	private int beoordeling;
	private BigDecimal prijs;
	private int inBestelling;
	@Version
	private int versie;
	
	/*
	@ElementCollection
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name="wijnid"))
	private Set<Bestelbonlijn> bestellijnen;
	*/
	public Wijn() {}	
	public Wijn(int soortid, int jaar, int beoordeling, BigDecimal prijs, int inBestelling) {
		
		this.soortid = soortid;
		this.jaar = jaar;
		this.beoordeling = beoordeling;
		this.prijs = prijs;
		this.inBestelling = inBestelling;
		
	}
	public int getId() {
		return id;
	}
	public int getSoortid() {
		return soortid;
	}
	public int getJaar() {
		return jaar;
	}
	public int getBeoordeling() {
		return beoordeling;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public int getInBestelling() {
		return inBestelling;
	}
	public Set<Bestelbonlijn> getBestellijnen() {
		return bestellijnen;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSoortid(int soortid) {
		this.soortid = soortid;
	}
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
	public void setBeoordeling(int beoordeling) {
		this.beoordeling = beoordeling;
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	public void setInBestelling(int inBestelling) {
		this.inBestelling = inBestelling;
	}
	public void setBestellijnen(Set<Bestelbonlijn> bestellijnen) {
		this.bestellijnen = bestellijnen;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jaar;
		result = prime * result + soortid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Wijn))
			return false;
		Wijn other = (Wijn) obj;
		if (jaar != other.jaar)
			return false;
		if (soortid != other.soortid)
			return false;
		return true;
	}
	
	
	
}
/*
 
@Embedded
private Adres adres;

@ElementCollection
@CollectionTable(name="campussentelefoonnrs", joinColumns = @JoinColumn(name="campusid"))
@OrderBy("fax")	
private Set<TelefoonNr> telefoonNrs;


@OneToMany
@JoinColumn(name =  "campusid")
@OrderBy("voornaam, familienaam")
private Set<Docent> docenten;

public Set<Docent> getDocenten() { return Collections.unmodifiableSet(docenten); } 
public void add(Docent docent) { docenten.add(docent); }
public void remove(Docent docent) { docenten.remove(docent); }


protected Campus() {}

*/