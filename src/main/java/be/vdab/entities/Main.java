package be.vdab.entities;

import java.math.BigDecimal;

public class Main {

	
	
	public static void main(String[] args) {
		
		Wijn w = new Wijn(100, 50, 1, BigDecimal.TEN, 5);
		Bestelregel br = new Bestelregel(5, w);
		Mandje mandje = new Mandje();
		mandje.lijnToevoegen(br);
		System.out.println(mandje.berekenTotaal());
	}
}
