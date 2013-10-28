package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.psychopoker.MelhorMao;
import br.com.psychopoker.util.CollectionUtil;

public class FullHouse implements MelhorMao {
	
	private static final int TRES = 3;
	private static final int DOIS = 2;
	
	private Monte monte;
	
	public FullHouse(Monte monte) {
		this.monte = monte;
	}
	
	@Override
	public boolean matches() {

		List<Carta> maoJogador = new ArrayList<Carta>(monte.getCartasJogador());
		List<Carta> cartasMonte = new ArrayList<Carta>(monte.getCartasMonte());
		List<Carta> trocas = new ArrayList<Carta>(monte.getCartasJogador());
		
		ordenaLista(trocas);
		ordenaLista(maoJogador);
		
		if (isFullHouse(maoJogador)) return true;
		
		List<Carta> cartasASeremTrocadas = new ArrayList<Carta>();
		for (int a = 0; a < cartasMonte.size(); a++) {
			cartasASeremTrocadas.add(cartasMonte.get(a));
			
			for (int b = 0; b < (maoJogador.size() - a); b++) {
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				adicionaCartas(b, maoJogador, cartasASeremTrocadas, cartasASeremTrocadas.size());
				if (isFullHouse(maoJogador)) return true;
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				voltaListaNormal(b, maoJogador, trocas, cartasASeremTrocadas.size());
			}
			
		}
		
		return false;
	}
	
	public boolean isFullHouse(List<Carta> maoJogador) {
		boolean trinca = false;
		boolean pair = false;
		for (int i = 0; i < maoJogador.size(); i++) {
			if (Collections.frequency(maoJogador, maoJogador.get(i)) == TRES){
				trinca = true;
			}

			if (Collections.frequency(maoJogador, maoJogador.get(i)) == DOIS) {
				pair = true;
			}
		}
		
		return trinca && pair;
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
	
	@Override
	public String toString() {
		return "Mão: ".concat(CollectionUtil.join(monte.getCartasJogador(), " ")) .concat(" Monte: ").concat(CollectionUtil.join(monte.getCartasMonte(), " "))
				.concat(" Melhor Jogo: full-house (trinca + par) ");
	}
	
}
