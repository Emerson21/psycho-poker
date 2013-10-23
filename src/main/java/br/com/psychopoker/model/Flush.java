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
import br.com.psychopoker.model.Carta.Naipe;

public class Flush implements MelhorMao{

	private static final int CINCO = 5;
	
	private Monte monte;
	
	public Flush(Monte monte) {
		this.monte = monte;
	}
	
	@Override
	public boolean matches() {
		List<Naipe> naipes = new ArrayList<Carta.Naipe>();
		Naipe naipe = Naipe.C;
		
		for (int loop = 0; loop < monte.getCartasJogador().size(); loop++) {
			naipes.add(monte.getCartasJogador().get(loop).getNaipe());
		}
		
		Set<Naipe> setNaipes = new HashSet<Carta.Naipe>(naipes);
		Iterator<Naipe> iterator = setNaipes.iterator();
		int frequencia = 0;
		while (iterator.hasNext()) {
			Naipe naipeAtual = iterator.next();
			int frequenciaNaipe = Collections.frequency(naipes, naipeAtual);
			if (frequenciaNaipe > frequencia) {
				frequencia = frequenciaNaipe;
				naipe = naipeAtual;
			}
		}
		
		filtrar(naipes, naipe);
		
		if (naipes.size() == CINCO) return true;
		
		for (int loop = 0; loop < (monte.getCartasMonte().size() - frequencia); loop++) {
			naipes.add(monte.getCartasMonte().get(loop).getNaipe());
		}
		
		filtrar(naipes, naipe);
		
		return naipes.size() == CINCO;
	}

	private void filtrar(List<Naipe> naipes, Naipe naipe) {
		CollectionUtils.filter(naipes, PredicateUtils.equalPredicate(naipe));
	}

}
