package br.com.psychopoker;

import org.junit.Assert;
import org.junit.Test;

import br.com.psychopoker.model.Flush;
import br.com.psychopoker.model.FourOfAKind;
import br.com.psychopoker.model.FullHouse;
import br.com.psychopoker.model.Monte;
import br.com.psychopoker.model.Straight;
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
	
	@Test
	public void flush() throws Exception {
		Monte monte = new Monte("2H 6H 5H AC 7H AH AD 9H 4H 3C");
		Assert.assertTrue(new Flush(monte).matches());
	}
	
	@Test
	public void straight() throws Exception {
		Monte monte = new Monte("AC QS 9C 3S KD JD TS 2D AS 4C");
		Assert.assertTrue(new Straight(monte).matches());
	}
	
}
