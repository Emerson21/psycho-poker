package br.com.psychopoker.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.commons.lang3.StringUtils;

import br.com.psychopoker.model.Carta.Naipe;

public class Monte {

	private String[] entrada;
	private static Queue<Carta> cartasMonte = new LinkedList<Carta>();
	
	public Monte (String entrada) {
		this.entrada = entrada.split(" ");
		buildMonte();
	}
	
	private void buildMonte() {
		for (int i = 0; i < entrada.length; i++) {
			String valorNaipe = entrada[i];
			Valor valor = StringUtils.isNumeric(valorNaipe.substring(0,1)) ? Valor.valueOf(Long.valueOf(valorNaipe.substring(0,1))) : Valor.valueOf(valorNaipe.substring(0,1));  
			Carta carta = new Carta(valor, Naipe.valueOf(valorNaipe.substring(1,2)));
			addCarta(carta);
		}
	}

	private void addCarta(Carta carta) {
		cartasMonte.add(carta);
	}
	
	public static List<Carta> getCartasJogador() {
		List<Carta> cartasJogador = new ArrayList<Carta>();
		for (int i = 0; i < 5; i++) {
			cartasJogador.add(cartasMonte.poll());
			i++;
		}
		return cartasJogador;
	}
	
}
