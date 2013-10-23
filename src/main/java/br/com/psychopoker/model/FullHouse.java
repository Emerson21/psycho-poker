package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;

import br.com.psychopoker.MelhorMao;

public class FullHouse implements MelhorMao {
	
	private static final int TRES = 3;
	private static final int DOIS = 2;
	
	private Monte monte;
	private List<Carta> cartasMonte;
	private List<Carta> trinca = new ArrayList<Carta>();
	private List<Carta> par = new ArrayList<Carta>();
	
	public FullHouse(Monte monte) {
		this.monte = monte;
		cartasMonte = new ArrayList<Carta>(monte.getCartasMonte());
	}
	
	@Override
	public boolean matches() {
		
		resolve(new ArrayList<Carta>(monte.getCartasJogador()));
		
		if (trinca.size() == TRES && par.size() == DOIS) return true;
		
		if (trinca.size() == TRES) {
			for (int loop = 0; loop < DOIS; loop++) {
				trinca.add(cartasMonte.get(loop));
			}
			
			@SuppressWarnings("unchecked")
			List<Carta> select = (List<Carta>) CollectionUtils.selectRejected(trinca, PredicateUtils.equalPredicate(trinca.get(0)));
			for (Carta carta : select) {
				return isPar(select, carta);
			}
			
		} else if (par.size() == DOIS) {
			for (int loop = 0; loop < TRES; loop++) {
				par.add(cartasMonte.get(loop));
			}
			
			@SuppressWarnings("unchecked")
			List<Carta> select = (List<Carta>) CollectionUtils.selectRejected(par, PredicateUtils.equalPredicate(par.get(0)));
			for (Carta carta : select) {
				return isTrinca(select, carta);
			}
			
		} else {
			resolve(cartasMonte);
			return trinca.size() == TRES && par.size() == DOIS;
		}
		
		return false;
	}

	private void resolve(List<Carta> lista) {
		Set<Carta> set = new HashSet<Carta>(lista);
		Iterator<Carta> iterator = set.iterator();
		while (iterator.hasNext()) {
			Carta carta = (Carta) iterator.next();
			
			if (isTrinca(lista, carta)) {
				trinca = new ArrayList<Carta>(lista);
				Predicate predicate = PredicateUtils.equalPredicate(carta);
				CollectionUtils.filter(trinca, predicate);
				
			} else if (isPar(lista, carta)) {
				par = new ArrayList<Carta>(lista);
				Predicate predicate = PredicateUtils.equalPredicate(carta);
				CollectionUtils.filter(par, predicate);
			}
		}		
	}

	private boolean isPar(List<Carta> lista, Carta carta) {
		return Collections.frequency(lista, carta) == DOIS;
	}

	private boolean isTrinca(List<Carta> lista, Carta carta) {
		return Collections.frequency(lista, carta) == TRES;
	}

}
