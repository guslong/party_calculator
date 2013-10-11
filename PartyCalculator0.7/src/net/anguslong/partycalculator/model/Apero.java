package net.anguslong.partycalculator.model;

public class Apero extends Party {

	private static final double BEER_FACTOR = 1;
	private static final double REDWINE_FACTOR = 0.3;
	private static final double WHITEWINE_FACTOR = 0.3;

	public Apero(int duration, int numMale, int numFemale, double intensity) {
		this.partyLength = duration;
		this.numberOfMaleGuests = numMale;
		this.numberOfFemaleGuests = numFemale;
		this.numberOfGuests = numberOfFemaleGuests + numberOfMaleGuests;
		this.intensity = intensity;
	}

	public int getBeers() {
		int temp = (int) (numberOfMaleGuests * intensity * BEER_FACTOR * getPartyLength());
		if (temp > 1) {
			return temp;
		} else {
			return 1;
		}
	}

	public int getRedWine() {
		int temp = (int) (numberOfFemaleGuests * intensity * REDWINE_FACTOR * getPartyLength());
		if (temp > 1) {
			return temp;
		} else {
			return 1;
		}
	}

	public int getWhiteWine() {
		int temp = (int) (numberOfFemaleGuests * intensity * WHITEWINE_FACTOR * getPartyLength());
		if (temp > 1) {
			return temp;
		} else {
			return 1;
		}
	}

	public String toString() {
		return "Drinks only";
	}

}
