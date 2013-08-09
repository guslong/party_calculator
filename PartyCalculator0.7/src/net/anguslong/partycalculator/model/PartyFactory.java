package net.anguslong.partycalculator.model;

public class PartyFactory {

	public Party createParty(int type, int duration, int male, int female, double intensity) {
		switch (type) {
		case Party.APERO:
			return new Apero(duration, male, female, intensity);
		case Party.BBQ_PARTY:
			return new BBQParty(duration, male, female); // TODO intensity
		case Party.FONDUE_PARTY:
			return new FondueParty(duration, male, female); // TODO intensity
		default:
			return null;
		}
		
		
	}
	
}
