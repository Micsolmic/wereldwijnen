package be.vdab.entities;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.vdab.valueobjects.Adres;

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
	
	public Bestelbon() {}
	
	public Bestelbon(String naam, Adres adres) {
		this.besteld = LocalDateTime.now();
		this.naam = naam;
		this.adres = adres;
		
	}
}
