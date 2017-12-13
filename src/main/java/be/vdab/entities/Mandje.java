package be.vdab.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.vdab.valueobjects.Bestelbonlijn;

public class Mandje implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<Bestelbonlijn> lijnen = new ArrayList<>();
	
	
	
	public void lijnToevoegen(Bestelbonlijn lijn) {
		
		lijnen.add(lijn);
				
	}
	
	public List<Bestelbonlijn> getLijnen(){
		
		return lijnen;
		
	}
	
}
