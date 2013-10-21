package br.com.psychopoker;

import br.com.psychopoker.model.Monte;
import br.com.psychopoker.model.StraightFlush;
import br.com.psychopoker.util.CollectionUtil;

public class MelhorMao {

	public static MelhorMao resolver(Monte monte) {
		
		if (new StraightFlush().matches(monte)) {
			System.out.println("Mão: "+ CollectionUtil.join(monte.getCartasJogador(), ",") + " Monte: "
					+ CollectionUtil.join(monte.getCartasMonte(), ",") + " Melhor Jogo: straight-flush (sequência numérica e de naipe)");
			
			return new StraightFlush();
		}
		
		return null;

	}
	

}
