package net.anguslong.partycalculator.model;

/**
 * base class for all party types
 * @author anguslong
 *
 */
public abstract class Party {

	// constants for the party types: note, must keep in order with the strings.xml array
	public static final int APERO = 1;
	public static final int BBQ_PARTY = 2;
	public static final int FONDUE_PARTY = 3;
	
	// constants for intensity
	public static final double LOW_INTENSITY = 0.7;
	public static final double MID_INTENSITY = 1;
	public static final double HIGH_INTENSITY = 1.3;
	
	protected double intensity;
	protected int partyLength;
	protected int numberOfMaleGuests;
	protected int numberOfFemaleGuests;
	protected int numberOfGuests;
	
	// getters and setters
	public int getPartyLength() {
		return partyLength;
	}

	public void setPartyLength(int partyLength) {
		this.partyLength = partyLength;
	}

	public int getNumberOfMaleGuests() {
		return numberOfMaleGuests;
	}

	public void setNumberOfMaleGuests(int numberOfMaleGuests) {
		this.numberOfMaleGuests = numberOfMaleGuests;
	}

	public int getNumberOfFemaleGuests() {
		return numberOfFemaleGuests;
	}

	public void setNumberOfFemaleGuests(int numberOfFemaleGuests) {
		this.numberOfFemaleGuests = numberOfFemaleGuests;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
	
	public double getIntensity() {
		return intensity;
	}
	
	
}
