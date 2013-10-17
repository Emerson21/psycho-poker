package br.com.psychopoker.model;

import java.util.HashMap;
import java.util.Map;


public enum Valor {

	A(11L), DOIS(9L), TRES(10L), QUATRO(0L), CINCO(1L), SEIS(2L), SETE(3L), OITO(4L), NOVE(5L), T (6L), J(7L), Q (7L), K (8L);
	
	private static Map<Long, Valor> mapValor = new HashMap<Long, Valor>();
	
	static {
		for (Valor valor : Valor.values()) {
			Valor.mapValor.put(valor.getPeso(), valor);
		}
	}
	
	private Long peso;
	
	private Valor(Long peso) {
		this.peso = peso;
	}
	
	public long getPeso() {
		return this.peso;
	}
	
	
	public static Valor valueOf(Long numero) {
		return mapValor.get(numero);
	}
	
}
