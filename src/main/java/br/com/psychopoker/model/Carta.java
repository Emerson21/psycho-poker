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

	private enum Valor {
		A("Ás"), DIGIT("0-9"), T("10"), J("Valete"), Q("Dama"), K("Rei");
		
		private String descricao;
		
		private Valor (String descricao) {
			this.descricao = descricao;
		}
		
	}
	
	private enum Naipe {
		C("Paus"), D("Ouro"), S("Espada"), H("Copas");
		
		private String descricao;
		
		private Naipe(String descricao) {
			this.descricao = descricao;
		}
	}
	
}
