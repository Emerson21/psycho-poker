package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.commons.lang3.StringUtils;

import br.com.psychopoker.model.Carta.Naipe;

public class Monte {

	private String[] entrada;
	private static Queue<Carta> monte = new LinkedList<Carta>();
	private List<Carta> cartasJogador = new ArrayList<Carta>();
	private List<Carta> cartasMonte = new ArrayList<Carta>();
	
	public Monte (String entrada) throws Exception {
		this.entrada = entrada.split(" ");
		if(entrada.length() != 29) throw new Exception("entrada.invalida");
		buildMonte();
		buildCartasJogador();
		buildCartasMonte();
	}
	
	private void buildMonte() {
		for (int i = 0; i < entrada.length; i++) {
			String valorNaipe = new String(entrada[i]);
			Valor valor = StringUtils.isNumeric(valorNaipe.substring(0,1)) ? Valor.valueOf(Long.valueOf(valorNaipe.substring(0,1))) : Valor.valueOf(valorNaipe.substring(0,1));  
			Carta carta = new Carta(valor, Naipe.valueOf(valorNaipe.substring(1,2)));
			addCarta(carta);
		}
	}

	private void addCarta(Carta carta) {
		monte.add(carta);
	}
	
	private void buildCartasJogador() {
		for (int i = 0; i < 5; i++) {
			cartasJogador.add(monte.poll());
		}
	}
	
	private void buildCartasMonte() {
		for (int i = 0; i < 5; i++) {
			cartasMonte.add(monte.poll());
		}
	}
	
	public List<Carta> getCartasJogador() {
		return cartasJogador;
	}

	public List<Carta> getCartasMonte() {
		return cartasMonte;
	}
	
	public Queue<Carta> getMonte() {
		return monte;
	}

	
}
