package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.psychopoker.MelhorMao;
import br.com.psychopoker.model.Carta.Naipe;
import br.com.psychopoker.util.CollectionUtil;


public class StraightFlush implements MelhorMao {
	
	private Monte monte;
	
	public StraightFlush(Monte monte) {
		this.monte = monte;
	}
	
	@Override
	public boolean matches() {
		
		List<Carta> maoJogador = new ArrayList<Carta>(monte.getCartasJogador());
		List<Carta> cartasMonte = new ArrayList<Carta>(monte.getCartasMonte());
		List<Carta> trocas = new ArrayList<Carta>(monte.getCartasJogador());
		
		ordenaLista(maoJogador);
		
		if (isSequence(maoJogador)) return true;
		if (isSequence(cartasMonte)) return true;
		
		List<Carta> cartasASeremTrocadas = new ArrayList<Carta>();
		for (int a = 0; a < cartasMonte.size(); a++) {
			cartasASeremTrocadas.add(cartasMonte.get(a));
			
			for (int b = 0; b < (maoJogador.size() - a); b++) {
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				adicionaCartas(b, maoJogador, cartasASeremTrocadas, cartasASeremTrocadas.size());
				if (isSequence(maoJogador) && isSameNaipe(maoJogador)) return true;
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				voltaListaNormal(b, maoJogador, trocas, cartasASeremTrocadas.size());
			}
			
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
	
	private static void ordenaLista(List<Carta> maoJogador) {
		Collections.sort(maoJogador, new Comparator<Carta>() {
			@Override
			public int compare(Carta carta1, Carta carta2) {
				return carta2.getValor().getPeso().compareTo(carta1.getValor().getPeso());
			}
		});
	}
	
	private void removeCartas(int index, List<Carta> maoJogador, int loops) {	
		int count = 0;
		while (count < loops) {
			maoJogador.remove(index);
			++count;
		}
		
	}

	private static boolean isSequence(List<Carta> lista) {
		boolean isSequence = false;
		List<Carta> listaOrdenada = new ArrayList<Carta>(lista);
		ordenaLista(listaOrdenada);
		outter:
		for (int loop = 0; loop < listaOrdenada.size(); loop++) {
			for (int x = 1; x < listaOrdenada.size(); x++) {
				isSequence = (listaOrdenada.get(loop).getValor().getPeso() - listaOrdenada.get(x).getValor().getPeso() == 1);
				if (!isSequence) break outter;
				++loop;
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
	
	@Override
	public String toString() {
		return "Mão: ".concat(CollectionUtil.join(monte.getCartasJogador(), " ")) .concat(" Monte: ").concat(CollectionUtil.join(monte.getCartasMonte(), " "))
				.concat(" Melhor Jogo: straight-flush (sequência numérica e de naipe) ");
	}

}
