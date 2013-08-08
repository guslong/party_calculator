package net.anguslong.partycalculator.model;

public class FondueParty extends Party {
	
	private static final double BEER_FACTOR = 0; // no beer at a fondue party
	private static final double REDWINE_FACTOR = 0; // no red wine at a fondue party
	private static final double WHITEWINE_FACTOR = 0.07;
	
	
	public FondueParty (int duration, int numMale, int numFemale) {
		this.partyLength = duration;
		this.numberOfMaleGuests = numMale;
		this.numberOfFemaleGuests = numFemale;
		this.numberOfGuests = numberOfFemaleGuests + numberOfMaleGuests;
	}
	
	@Override
	public void calcBeers() {
		beers = (int) (numberOfMaleGuests * BEER_FACTOR * getPartyLength());
	}

	@Override
	public void calcRedWine() {
		redWine = (int) (numberOfFemaleGuests * REDWINE_FACTOR * getPartyLength());
	}

	@Override
	// for a fondue party we calculate white wine based on the total number of guests
	public void calcWhiteWine() {
		whiteWine = (int) (numberOfGuests * WHITEWINE_FACTOR * getPartyLength());
	}

}
