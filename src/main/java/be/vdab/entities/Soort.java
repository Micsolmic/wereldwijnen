package be.vdab.entities;

import javax.persistence.Version;

public class Soort {

	
	private int id;
	private String naam;
	private int landid;
	@Version
	private int versie;
	
	public Soort() {
		
	}
	
}
