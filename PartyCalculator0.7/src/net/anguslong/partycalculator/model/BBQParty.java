package net.anguslong.partycalculator.model;

/**
 * class represents the amounts needed for a BBQ Party
 * @author anguslong
 *
 */
public class BBQParty extends Party {
		
	private static final double BEER_FACTOR = 1;
	private static final double REDWINE_FACTOR = .2;
	private static final double WHITEWINE_FACTOR = 0.07;
	
	private static final double JUICE_FACTOR = 0.5;
	private static final double MEAT_FACTOR = 200.0; // grams
	private static final double BREAD_FACTOR = 0.5;
	
	public BBQParty(int duration, int numMale, int numFemale, double intensity) {
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
	
	/**
	 * calculates the amount needed. If party more than 4 hours, then more meat is required
	 * @return
	 */
	public int getMeat() {
		int temp;
		if (getPartyLength() > 4) {
			temp = (int) (numberOfGuests * MEAT_FACTOR * 1.5);
		}
		else {
			temp = (int) (numberOfGuests * MEAT_FACTOR);
		}
		
		if (temp > 1) {
			return temp;
		} else {
			return 1;
		}
	}
	

	
	public String toString() {
		return "BBQ";
	}

}
