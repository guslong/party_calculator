package net.anguslong.partycalculator.model;

public class FondueParty extends Party {
	
	private static final double BEER_FACTOR = 0; // no beer at a fondue party
	private static final double REDWINE_FACTOR = 0; // no red wine at a fondue party
	private static final double WHITEWINE_FACTOR = 0.07;
	
	
	public FondueParty (int duration, int numMale, int numFemale, double intensity) {
		this.partyLength = duration;
		this.numberOfMaleGuests = numMale;
		this.numberOfFemaleGuests = numFemale;
		this.numberOfGuests = numberOfFemaleGuests + numberOfMaleGuests;
		this.intensity = intensity;
	}
	
	@Override
	public void calcBeers() {
		int temp = (int) (numberOfMaleGuests * intensity * BEER_FACTOR * getPartyLength());
		
	}

	@Override
	public void calcRedWine() {
		int temp = (int) (numberOfFemaleGuests * intensity * REDWINE_FACTOR * getPartyLength());

	}

	@Override
	public void calcWhiteWine() {
		int temp = (int) (numberOfFemaleGuests * intensity * WHITEWINE_FACTOR * getPartyLength());
		if (temp > 1) {
			whiteWine = temp;
		} else {
			whiteWine = 1;
		}
	}

}
