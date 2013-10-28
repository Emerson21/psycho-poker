package br.com.psychopoker;

import br.com.psychopoker.model.Monte;

public class Jogo {

	public static void main(String[] args) throws Exception {
		String entrada = "TH JH QC QD QS QH KH AH 2S 6S";
		
		MelhorMao melhorMao = JogoResolver.start(new Monte(entrada));
		System.out.println(melhorMao.toString());
	}
	
}
