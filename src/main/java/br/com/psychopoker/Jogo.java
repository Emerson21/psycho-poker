package br.com.psychopoker;

import br.com.psychopoker.model.Monte;

public class Jogo {

	public static void main(String[] args) throws Exception {
		String entrada = "AC 2D 9C 3S KD 5S 4D KS AS 4C";
		
		MelhorMao melhorMao = JogoResolver.start(new Monte(entrada));
		System.out.println(melhorMao.toString());
	}
	
}
