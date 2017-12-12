package be.vdab.entities;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="soorten")
public class Soort {

	@Id
	@GeneratedValue	
	private int id;
	private String naam;
	private int landid;
	@Version
	private int versie;
	
	@OneToMany
	@JoinColumn(name = "soortid")
	@OrderBy("jaar")
	private Set<Wijn> wijnen;
	
	
	
	
	public Soort() {		
	}
	
	public Soort(String naam, int landid) {
		
	
		this.naam = naam;
		this.landid = landid;
		this.wijnen = new LinkedHashSet<>();
	}

	public String getNaam() {
		return naam;
	}

	public int getLandid() {
		return landid;
	}

	public int getVersie() {
		return versie;
	}

	public Set<Wijn> getWijnen() {
		return wijnen;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setLandid(int landid) {
		this.landid = landid;
	}

	public void setVersie(int versie) {
		this.versie = versie;
	}

	public void setWijnen(Set<Wijn> wijnen) {
		this.wijnen = wijnen;
	}
	
	
	
}
