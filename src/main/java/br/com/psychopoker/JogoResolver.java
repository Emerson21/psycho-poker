package br.com.psychopoker;

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

public class JogoResolver {

	public static MelhorMao start(Monte monte) {
		
		StraightFlush straightFlush = new StraightFlush(monte);
		if (straightFlush.matches()) return straightFlush;
		
		FourOfAKind fourOfAKind = new FourOfAKind(monte);
		if (fourOfAKind.matches()) return fourOfAKind;
		
		FullHouse fullHouse = new FullHouse(monte);
		if (fullHouse.matches()) return fullHouse;
		
		Flush flush = new Flush(monte);
		if (flush.matches()) return flush;
		
		Straight straight = new Straight(monte);
		if (straight.matches()) return straight;
		
		ThreeOfAKind threeOfAKind = new ThreeOfAKind(monte);
		if (threeOfAKind.matches()) return threeOfAKind;
		
		TwoPairs twoPairs = new TwoPairs(monte);
		if (twoPairs.matches()) return twoPairs;
		
		OnePair onePair = new OnePair(monte);
		if (onePair.matches()) return onePair; 
		
		HighestCard highestCard = new HighestCard(monte);
		if (highestCard.matches()) return highestCard;
		
		return null;
	}

}
