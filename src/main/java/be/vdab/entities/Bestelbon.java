package be.vdab.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.Bestelbonlijn;

@Entity
@Table(name="bestelbonnen")
public class Bestelbon {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	LocalDateTime besteld;
	String naam;
	@Embedded
	Adres adres;
	int bestelwijze;
	@Version
	int versie;
	
	@ElementCollection
	@CollectionTable(name="bestelbonlijnen", joinColumns = @JoinColumn(name="bonid"))
	@OrderBy("aantal")
	List<Bestelbonlijn> bestelbonlijnen = new ArrayList<>();	
	
	
	public Bestelbon() {}
	
	public Bestelbon(String naam, Adres adres, int bestelwijze) {
		this.besteld = LocalDateTime.now();
		this.naam = naam;
		this.adres = adres;
		this.bestelwijze = bestelwijze;
		
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getBesteld() {
		return besteld;
	}

	public String getNaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public int getBestelwijze() {
		return bestelwijze;
	}

	public int getVersie() {
		return versie;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBesteld(LocalDateTime besteld) {
		this.besteld = besteld;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public void setBestelwijze(int bestelwijze) {
		this.bestelwijze = bestelwijze;
	}

	public void setVersie(int versie) {
		this.versie = versie;
	}
	
	public void addBestelbonlijn(Bestelbonlijn bebolijn) {
		bestelbonlijnen.add(bebolijn);		
	}
}
