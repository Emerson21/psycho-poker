package br.com.psychopoker;

import org.junit.Assert;
import org.junit.Test;

import br.com.psychopoker.model.FourOfAKind;
import br.com.psychopoker.model.FullHouse;
import br.com.psychopoker.model.Monte;
import br.com.psychopoker.model.StraightFlush;

public class MelhorMaoTest {
	
	@Test
	public void combinacaoStraightFlush() throws Exception {
		Monte monte = new Monte("TH JH QC QD QS QH KH AH 2S 6S");
		Assert.assertTrue(new StraightFlush(monte).matches());
	}
	
	@Test
	public void melhorMaoFourOfAKind() throws Exception {
		Monte monte = new Monte("2H 2S 3H 3S 3C 2D 3D 6C 9C TH");
		Assert.assertTrue(new FourOfAKind(monte).matches());
	}
	
	@Test
	public void fullHouse() throws Exception {
		Monte monte = new Monte("2H 2S 3H 3S 3C 2D 9C 3D 6C TH");
		Assert.assertTrue(new FullHouse(monte).matches());
	}
	
}
