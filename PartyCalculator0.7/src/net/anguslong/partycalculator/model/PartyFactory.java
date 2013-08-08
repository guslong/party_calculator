package net.anguslong.partycalculator.model;

public class PartyFactory {

	public Party createParty(int type, int duration, int male, int female) {
		if (type == 1) return new Apero(duration, male, female);
		if (type == 2) return new BBQParty(duration, male, female);
		if (type == 3) return new FondueParty(duration, male, female);
		return null;
	}
	
}
