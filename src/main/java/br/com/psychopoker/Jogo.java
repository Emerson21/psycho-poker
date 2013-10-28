package br.com.psychopoker;

import java.util.Collections;
import java.util.List;

import br.com.psychopoker.model.Baralho;
import br.com.psychopoker.model.Carta;
import br.com.psychopoker.model.Monte;
import br.com.psychopoker.util.CollectionUtil;

public class Jogo {

	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 900; i++){
			List<Carta> baralho = Baralho.getBaralho();
			Collections.shuffle(baralho);
			
			String entrada = CollectionUtil.join(baralho.subList(0, 10), " ") ;
			
			MelhorMao melhorMao = JogoResolver.start(new Monte(entrada));
			if (melhorMao == null) {
				System.out.println(entrada);
				System.out.println("Não foi identificado nenhuma regra para a jogada");
			} else {
				System.out.println(melhorMao.toString());
			}
		}
	}
	
}
