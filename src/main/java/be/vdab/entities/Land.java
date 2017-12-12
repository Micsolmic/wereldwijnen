package be.vdab.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="landen")
public class Land {
	
	@Id
	int id;	
	String naam;
	@Version
	int versie;
	
	
	@OneToMany
	@JoinColumn(name = "landid")
	@OrderBy("naam")
	private Set<Soort> soorten;
	
	public Land() {}

	public Land(int id, String naam) {
		this.id = id;
		this.naam = naam;
		
		
	}

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public int getVersie() {
		return versie;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setVersie(int versie) {
		this.versie = versie;
	}
	
	
	
}
