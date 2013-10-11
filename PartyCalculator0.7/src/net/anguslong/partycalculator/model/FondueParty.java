package net.anguslong.partycalculator.model;

public class FondueParty extends Party {
	
	private static final double BEER_FACTOR = 0; // no beer at a fondue party
	private static final double REDWINE_FACTOR = 0; // no red wine at a fondue party
	private static final double WHITEWINE_FACTOR = 0.3;
	private static final double CHEESE_FACTOR = 175; // in grams of cheese
	
	public FondueParty (int duration, int numMale, int numFemale, double intensity) {
		this.partyLength = duration;
		this.numberOfMaleGuests = numMale;
		this.numberOfFemaleGuests = numFemale;
		this.numberOfGuests = numberOfFemaleGuests + numberOfMaleGuests;
		this.intensity = intensity;
	}
	

	public int getWhiteWine() {

		int temp = (int) (numberOfGuests * intensity * WHITEWINE_FACTOR * getPartyLength());
		if (temp > 1) {
			return temp;
		} else {
			return 1;
		}
	}
	
	public int getCheese() {

		int temp = (int) (numberOfGuests * CHEESE_FACTOR);
		if (temp > 1) {
			return temp;
		} else {
			return 1;
		}
	}
	
	public String toString() {
		return "Fondue";
	}

}
