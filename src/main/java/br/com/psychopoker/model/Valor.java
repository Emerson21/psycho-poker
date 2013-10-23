package br.com.psychopoker.model;

import java.util.HashMap;
import java.util.Map;


public enum Valor {

	A(14L, "A"),
	K(13L, "K"), 
	Q(12L, "Q"), 
	J(11L, "J"), 
	T(10L, "T"), 
	NOVE(9L, "9"), 
	OITO(8L, "8"), 
	SETE(7L, "7"), 
	SEIS(6L, "6"), 
	CINCO(5L,"5"), 
	QUATRO(4L, "4"), 
	TRES(3L, "3"), 
	DOIS(2L, "2"); 
	
	private static Map<Long, Valor> mapValor = new HashMap<Long, Valor>();
	
	static {
		for (Valor valor : Valor.values()) {
			Valor.mapValor.put(valor.getPeso(), valor);
		}
	}
	
	private Long peso;
	private String descricao;
	
	private Valor(Long peso, String descricao) {
		this.peso = peso;
		this.descricao = descricao;
	}
	
	public Long getPeso() {
		return this.peso;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static Valor valueOf(Long numero) {
		return mapValor.get(numero);
	}
	
}
