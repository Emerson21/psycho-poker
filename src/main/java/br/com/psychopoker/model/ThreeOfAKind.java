package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.psychopoker.MelhorMao;

public class ThreeOfAKind implements MelhorMao{

	private Monte monte;
	
	public ThreeOfAKind(Monte monte) {
		this.monte = monte;
	}
	
	@Override
	public boolean matches() {

		List<Carta> maoJogador = new ArrayList<Carta>(monte.getCartasJogador());
		List<Carta> cartasMonte = new ArrayList<Carta>(monte.getCartasMonte());
		List<Carta> trocas = new ArrayList<Carta>(monte.getCartasJogador());
		
		ordenaLista(trocas);
		ordenaLista(maoJogador);
		
		if (isThreeOfAKind(maoJogador)) return true;
		
		List<Carta> cartasASeremTrocadas = new ArrayList<Carta>();
		for (int a = 0; a < cartasMonte.size(); a++) {
			cartasASeremTrocadas.add(cartasMonte.get(a));
			
			for (int b = 0; b < (maoJogador.size() - a); b++) {
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				adicionaCartas(b, maoJogador, cartasASeremTrocadas, cartasASeremTrocadas.size());
				if (isThreeOfAKind(maoJogador)) return true;
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				voltaListaNormal(b, maoJogador, trocas, cartasASeremTrocadas.size());
			}
			
		}
		
		return false;
	}
	
	private boolean isThreeOfAKind(List<Carta> maoJogador) {
		for (int i = 0; i < maoJogador.size(); i++) {
			if (Collections.frequency(maoJogador, maoJogador.get(i)) == 3) return true;
		}
		return false;
	}

	private void adicionaCartas(int index, List<Carta> collection, List<Carta> troca, int loops) {
		int count = 0;
		while (count < loops) {
			collection.add(index, troca.get(count));
			++index;
			++count;
		}
		
	}

	private void voltaListaNormal(int index, List<Carta> collection, List<Carta> troca, int loops) {
		int count = 0;
		while (count < loops) {
			collection.add(index, troca.get(index));
			++index;
			++count;
		}
		
	}
	
	private void removeCartas(int index, List<Carta> maoJogador, int loops) {	
		int count = 0;
		while (count < loops) {
			maoJogador.remove(index);
			++count;
		}
		
	}

	private static void ordenaLista(List<Carta> maoJogador) {
		Collections.sort(maoJogador, new Comparator<Carta>() {
			@Override
			public int compare(Carta carta1, Carta carta2) {
				return carta2.getValor().getPeso().compareTo(carta1.getValor().getPeso());
			}
		});
	}
	
}
