package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.List;

import br.com.psychopoker.model.Carta.Naipe;

public class Baralho {

	private static List<Carta> baralho = new ArrayList<Carta>();
	
	static {
		for (Valor valor : Valor.values()) {
			for (Naipe naipe : Naipe.values()) {
				baralho.add(new Carta(valor, naipe));
			}
		}
	}
	
	public static List<Carta> getBaralho() {
		return baralho;
	}
	
}
