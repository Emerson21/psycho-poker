package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;

import br.com.psychopoker.MelhorMao;
import br.com.psychopoker.model.Carta.Naipe;
import br.com.psychopoker.util.CollectionUtil;

public class Flush implements MelhorMao{

	private static final int CINCO = 5;
	private List<Naipe> naipes = new ArrayList<Carta.Naipe>();
	
	private Monte monte;
	
	public Flush(Monte monte) {
		this.monte = monte;
	}
	
	@Override
	public boolean matches() {
		
		List<Carta> maoJogador = new ArrayList<Carta>(monte.getCartasJogador());
		List<Carta> cartasMonte = new ArrayList<Carta>(monte.getCartasMonte());
		List<Carta> trocas = new ArrayList<Carta>(monte.getCartasJogador());
		
		ordenaLista(trocas);
		ordenaLista(maoJogador);
		
		if (isFlush(maoJogador)) return true;
		
		List<Carta> cartasASeremTrocadas = new ArrayList<Carta>();
		for (int a = 0; a < cartasMonte.size(); a++) {
			cartasASeremTrocadas.add(cartasMonte.get(a));
			
			for (int b = 0; b < (maoJogador.size() - a); b++) {
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				adicionaCartas(b, maoJogador, cartasASeremTrocadas, cartasASeremTrocadas.size());
				if (isFlush(maoJogador)) return true;
				removeCartas(b, maoJogador, cartasASeremTrocadas.size());
				voltaListaNormal(b, maoJogador, trocas, cartasASeremTrocadas.size());
			}
			
		}
		
		return false;
	}
	
	private boolean isFlush(List<Carta> maoJogador) {
		for (int i = 0; i < maoJogador.size(); i++) {
			naipes.add(maoJogador.get(i).getNaipe());
			filtrar(naipes, maoJogador.get(i).getNaipe());
			
		}
		if (naipes.size() != CINCO) naipes = new ArrayList<Naipe>();
		
		return !naipes.isEmpty();
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

	private void filtrar(List<Naipe> naipes, Naipe naipe) {
		CollectionUtils.filter(naipes, PredicateUtils.equalPredicate(naipe));
	}

	@Override
	public String toString() {
		return "Mão: ".concat(CollectionUtil.join(monte.getCartasJogador(), " ")) .concat(" Monte: ").concat(CollectionUtil.join(monte.getCartasMonte(), " "))
				.concat(" Melhor Jogo: flush (sequência de naipe) ");
	}
	
}
