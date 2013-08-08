package net.anguslong.partycalculator.model;

public class Apero extends Party {
	
	private static final double BEER_FACTOR = 0.25; 
	private static final double REDWINE_FACTOR = 0.3; 
	private static final double WHITEWINE_FACTOR = 0.3;
	
	public Apero(int duration, int numMale, int numFemale) {
		this.partyLength = duration;
		this.numberOfMaleGuests = numMale;
		this.numberOfFemaleGuests = numFemale;
		this.numberOfGuests = numberOfFemaleGuests + numberOfMaleGuests;
	}

	@Override
	public void calcBeers() {
		int temp = (int) (numberOfMaleGuests * BEER_FACTOR * getPartyLength());
		if (temp > 1) {
			beers = temp;
		} else {
			beers = 1;
		}
	}

	@Override
	public void calcRedWine() {
		int temp = (int) (numberOfFemaleGuests * REDWINE_FACTOR * getPartyLength());
		if (temp > 1) {
			redWine = temp;
		} else {
			redWine = 1;
		}
	}

	@Override
	public void calcWhiteWine() {
		int temp = (int) (numberOfFemaleGuests * WHITEWINE_FACTOR * getPartyLength());
		if (temp > 1) {
			whiteWine = temp;
		} else {
			whiteWine = 1;
		}
	}

}
