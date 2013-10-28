package br.com.psychopoker;

import org.junit.Assert;
import org.junit.Test;

import br.com.psychopoker.model.Flush;
import br.com.psychopoker.model.FourOfAKind;
import br.com.psychopoker.model.FullHouse;
import br.com.psychopoker.model.HighestCard;
import br.com.psychopoker.model.Monte;
import br.com.psychopoker.model.OnePair;
import br.com.psychopoker.model.Straight;
import br.com.psychopoker.model.StraightFlush;
import br.com.psychopoker.model.ThreeOfAKind;
import br.com.psychopoker.model.TwoPairs;

public class MelhorMaoTest {
	
	@Test
	public void straightFlush() throws Exception {
		Monte monte = new Monte("TH JH QC QD QS QH KH AH 2S 6S");
		Assert.assertTrue(new StraightFlush(monte).matches());
	}
	
	@Test
	public void fourOfAKind() throws Exception {
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
	
	@Test
	public void threeOfAKind() throws Exception {
		Monte monte = new Monte("KS AH 2H 3C 4H KC 2C TC 2D AS");
		Assert.assertTrue(new ThreeOfAKind(monte).matches());
	}

	@Test
	public void twoPair() throws Exception {
		Monte monte = new Monte("AH 2C 9S AD 3C QH KS JS JD KD");
		Assert.assertTrue(new TwoPairs(monte).matches());
	}

	@Test
	public void pair() throws Exception {
		Monte monte = new Monte("6C 9C 8C 2D 7C 2H TC 4C 9S AH");
		Assert.assertTrue(new OnePair(monte).matches());
	}
	
	@Test
	public void highestCard() throws Exception {
		Monte monte = new Monte("3D 5S 2H QD TD 6S KH 9H AD QH");
		Assert.assertTrue(new HighestCard(monte).matches());
	}
}
