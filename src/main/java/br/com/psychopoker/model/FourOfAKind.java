package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.psychopoker.MelhorMao;
import br.com.psychopoker.util.CollectionUtil;

public class FourOfAKind implements MelhorMao {

	private static final int FOUR = 4;
	
	private Monte monte;
	
	public FourOfAKind(Monte monte) {
		this.monte = monte;
	}
	
	@Override
	public boolean matches() {
		
		List<Carta> maoJogador = new ArrayList<Carta>(monte.getCartasJogador());
		List<Carta> cartasMonte = new ArrayList<Carta>(monte.getCartasMonte());
		List<Carta> trocas = new ArrayList<Carta>(monte.getCartasJogador());
		
		if (isFourOfAKind(maoJogador)) return true;
		
		List<Carta> cartasASeremTrocadas = new ArrayList<Carta>();
		for (int a = 0; a < cartasMonte.size(); a++) {
			cartasASeremTrocadas.add(cartasMonte.get(a));
			
			for (int b = 0; b < (maoJogador.size() - a); b++) {
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				adicionaCartas(b, maoJogador, cartasASeremTrocadas, cartasASeremTrocadas.size());
				if (isFourOfAKind(maoJogador)) return true;
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				voltaListaNormal(b, maoJogador, trocas, cartasASeremTrocadas.size());
			}
			
		}
		
		return false;
	}
	
	private boolean isFourOfAKind(List<Carta> maoJogador) {
		for (int i = 0; i < maoJogador.size(); i++) {
			if (Collections.frequency(maoJogador, maoJogador.get(i)) == FOUR) return true;
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

	@Override
	public String toString() {
		return "Mão: ".concat(CollectionUtil.join(monte.getCartasJogador(), " ")) .concat(" Monte: ").concat(CollectionUtil.join(monte.getCartasMonte(), " "))
				.concat(" Melhor Jogo: four-of-a-kind (quadra)");
	}
	
}
