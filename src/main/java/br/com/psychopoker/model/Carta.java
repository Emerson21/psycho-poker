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
		return this.valor.getDescricao().concat(naipe.name());
	}
	
	@Override
	public boolean equals(Object obj) {
		Carta carta = (Carta) obj;
		return this.valor == carta.getValor();
	}
	
	@Override
	public int hashCode() {
		return this.valor.hashCode();
	}
	
	public enum Naipe {
		C , D , S , H ;
	}
	
}
