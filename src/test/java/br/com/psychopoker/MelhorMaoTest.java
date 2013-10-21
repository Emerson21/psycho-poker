package br.com.psychopoker;

import org.junit.Assert;
import org.junit.Test;

import br.com.psychopoker.model.Monte;
import br.com.psychopoker.model.StraightFlush;

public class MelhorMaoTest {
	
	@Test
	public void combinacaoStraightFlush() throws Exception {
		String entrada = "TH JH QC QD QS QH KH AH 2S 6S";
		MelhorMao straightFlush = MelhorMao.resolver(new Monte(entrada)); 
		
		Assert.assertTrue(straightFlush instanceof StraightFlush);
	}
	
}
