package net.anguslong.partycalculator.model;

public class DinnerParty extends Party {
	
	
	private static final double BEER_FACTOR = 0; // posh dinner parties have no beer
	private static final double REDWINE_FACTOR = 0.66; //  but lots of red wine
	private static final double WHITEWINE_FACTOR = 0.1; // someone always has the fish, or white with the starter
	
	// disabled in this version:
	//private static final double JUICE_FACTOR = 0.5;
	//private static final double MEAT_FACTOR = 150.0;
	//private static final double BREAD_FACTOR = 0.5;
	
	public DinnerParty(int duration, int numMale, int numFemale, double intensity) {
		this.partyLength = duration;
		this.numberOfMaleGuests = numMale;
		this.numberOfFemaleGuests = numFemale;
		this.numberOfGuests = numberOfFemaleGuests + numberOfMaleGuests;
		this.intensity = intensity;
	}

	@Override
	public void calcBeers() {
		
			beers = 0;
		
	}

	@Override
	public void calcRedWine() {
		int temp = (int) (numberOfGuests * intensity * REDWINE_FACTOR * getPartyLength());
		if (temp > 1) {
			redWine = temp;
		} else {
			redWine = 1;
		}
	}

	@Override
	public void calcWhiteWine() {
		int temp = (int) (numberOfGuests * intensity * WHITEWINE_FACTOR * getPartyLength());
		if (temp > 1) {
			whiteWine = temp;
		} else {
			whiteWine = 1;
		}
	}
	
	public String toString() {
		return "Dinner Party";
	}

}
