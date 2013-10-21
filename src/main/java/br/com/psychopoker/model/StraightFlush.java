package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.psychopoker.MelhorMao;
import br.com.psychopoker.model.Carta.Naipe;


public class StraightFlush extends MelhorMao {
	
	public boolean matches(Monte monte) {
		List<Carta> maoJogador = monte.getCartasJogador();
		List<Carta> cartasMonte = monte.getCartasMonte();
		
		Collections.sort(monte.getCartasJogador(), new Comparator<Carta>() {
			@Override
			public int compare(Carta carta1, Carta carta2) {
				return carta2.getValor().getPeso().compareTo(carta1.getValor().getPeso());
			}
		});

		
		if (isSequence(maoJogador) && isSameNaipe(maoJogador)) return Boolean.TRUE;
		if (isSequence(cartasMonte) && isSameNaipe(cartasMonte)) return Boolean.TRUE;
		
		List<Carta> straight = new ArrayList<Carta>();
		
		for (int i = 0; i < maoJogador.size(); i++) {
			for(int x = i+1; x < maoJogador.size(); x++) {
				if (maoJogador.get(i).getNaipe() == maoJogador.get(x).getNaipe()) {
					straight.add(maoJogador.get(i));
					straight.add(maoJogador.get(x));
				}
			}
		}
		int loops = cartasMonte.size() - straight.size();
		for (int i = 0; i < loops; i++) {
			straight.add(cartasMonte.get(i));
		}
		
		Collections.sort(straight, new Comparator<Carta>() {
			@Override
			public int compare(Carta carta1, Carta carta2) {
				return carta2.getValor().getPeso().compareTo(carta1.getValor().getPeso());
			}
		});

		
		return isSequence(straight) && isSameNaipe(straight) ? Boolean.TRUE :Boolean.FALSE; 
		
	}

	private static boolean isSequence(List<Carta> maoJogador) {
		boolean isSequence = false;
		
		for (int i = 0; i < maoJogador.size(); i++) {
			for (int x = i+1; x < maoJogador.size(); x++) {
				isSequence = (maoJogador.get(i).getValor().getPeso() - maoJogador.get(x).getValor().getPeso()) == 1;
				i++;
			}
		}
		
		return isSequence;
	}
	
	private static boolean isSameNaipe(List<Carta> maoJogador) {
		boolean isSameNaipe = false;
		Naipe naipe = maoJogador.get(0).getNaipe();
		for (int i = 1; i < maoJogador.size(); i++) {
			isSameNaipe = naipe == maoJogador.get(i).getNaipe();
		}
		
		return isSameNaipe;
	}

}
