package net.anguslong.partycalculator.model;

public class PartyFactory {

	public Party createParty(int type, int duration, int male, int female) {
		switch (type) {
		case Party.APERO:
			return new Apero(duration, male, female);
		case Party.BBQ_PARTY:
			return new BBQParty(duration, male, female);
		case Party.FONDUE_PARTY:
			return new FondueParty(duration, male, female);
		default:
			return null;
		}
		
		
	}
	
}
