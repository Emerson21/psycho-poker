package br.com.psychopoker.model;


public class Carta {
	
	private Naipe naipe;
	
	private Valor valor;
	
	public Carta (Valor valor, Naipe naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}
	
	public Naipe getNaipe() {
		return naipe;
	}

	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return this.valor.name().concat(naipe.name());
	}
	
	
	public enum Naipe {
		C ("Paus"), D ("Ouro"), S ("Espada"), H ("Copas");
		
		private String descricao;
		
		private Naipe(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return this.descricao;
		}
	}
	
	
}
