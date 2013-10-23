package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.psychopoker.MelhorMao;

public class Straight implements MelhorMao {

	private Monte monte;
	
	public Straight(Monte monte) {
		this.monte = monte;
	}
	
	@Override
	public boolean matches() {
		
		List<Carta> maoJogador = new ArrayList<Carta>(monte.getCartasJogador());
		
		Collections.sort(maoJogador, new Comparator<Carta>() {
			@Override
			public int compare(Carta carta1, Carta carta2) {
				return carta2.getValor().getPeso().compareTo(carta1.getValor().getPeso());
			}
			
		});
		
		if (isSequence(maoJogador)) return true;
		
		return false;
	}
	
	private static boolean isSequence(List<Carta> lista) {
		boolean isSequence = false;
		
		sair:
		for (int i = 0; i < lista.size(); i++) {
			for (int x = i+1; x < lista.size(); x++) {
				isSequence = (lista.get(i).getValor().getPeso() - lista.get(x).getValor().getPeso()) == 1;
				i++;
				if (!isSequence) break sair;
			}
		}
		
		return isSequence;
	}
	
}
