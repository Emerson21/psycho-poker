package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;

import br.com.psychopoker.MelhorMao;

public class FourOfAKind implements MelhorMao {

	private static final int FOUR_OF_A_KIND = 4;
	private Monte monte;
	
	public FourOfAKind(Monte monte) {
		this.monte = monte;
	}
	
	//TODO ter a possibilidade de trocar todas as cartas
	@Override
	public boolean matches() {
		List<Carta> maoJogador = new ArrayList<Carta>(monte.getCartasJogador());

		Set<Carta> s = new HashSet<Carta>();//TODO Refactoring - instanciar já passando a collection
		for (Carta carta : maoJogador) {
			s.add(carta);
		}
		
		List<Carta> cartaComMaiorFrequencia = new ArrayList<Carta>();
		
		Iterator<Carta> it = s.iterator();
		int frequency = 0;
		while (it.hasNext()) {
			Carta carta = it.next();
			int frequenciaCarta = Collections.frequency(maoJogador , carta);
			if (frequenciaCarta > frequency) {
				if (!cartaComMaiorFrequencia.isEmpty()){
					cartaComMaiorFrequencia.remove(0);
				}

				cartaComMaiorFrequencia.add(carta);
				frequency = frequenciaCarta;
			}
		}
		
		Carta carta = cartaComMaiorFrequencia.get(0);
		
		List<Carta> cartasMonte = new ArrayList<Carta>(monte.getCartasMonte());
		CollectionUtils.filter(maoJogador, PredicateUtils.equalPredicate(carta));
		
		for (int loop = 0; loop < (cartasMonte.size() - frequency); loop++) {
			maoJogador.add(cartasMonte.get(loop));
		}
		
		return Collections.frequency(maoJogador, carta) == FOUR_OF_A_KIND;
	}
}
