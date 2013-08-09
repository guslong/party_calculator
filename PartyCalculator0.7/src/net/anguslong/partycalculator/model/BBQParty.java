package net.anguslong.partycalculator.model;

public class BBQParty extends Party {
	
	
	private static final double BEER_FACTOR = 1.00;
	private static final double REDWINE_FACTOR = .2;
	private static final double WHITEWINE_FACTOR = 0.07;
	
	// disabled in this version:
	//private static final double JUICE_FACTOR = 0.5;
	//private static final double MEAT_FACTOR = 150.0;
	//private static final double BREAD_FACTOR = 0.5;
	
	public BBQParty(int duration, int numMale, int numFemale, double intensity) {
		this.partyLength = duration;
		this.numberOfMaleGuests = numMale;
		this.numberOfFemaleGuests = numFemale;
		this.numberOfGuests = numberOfFemaleGuests + numberOfMaleGuests;
		this.intensity = intensity;
	}

	@Override
	public void calcBeers() {
		int temp = (int) (numberOfMaleGuests * intensity * BEER_FACTOR * getPartyLength());
		if (temp > 1) {
			beers = temp;
		} else {
			beers = 1;
		}
	}

	@Override
	public void calcRedWine() {
		int temp = (int) (numberOfFemaleGuests * intensity * REDWINE_FACTOR * getPartyLength());
		if (temp > 1) {
			redWine = temp;
		} else {
			redWine = 1;
		}
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
