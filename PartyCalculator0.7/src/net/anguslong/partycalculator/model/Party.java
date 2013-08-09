package net.anguslong.partycalculator.model;

public abstract class Party {

	// constants for the party types: note, must keep in order with the strings.xml array
	public static final int APERO = 1;
	public static final int BBQ_PARTY = 2;
	public static final int FONDUE_PARTY = 3;
	
	protected int partyLength;
	protected int numberOfMaleGuests;
	protected int numberOfFemaleGuests;
	protected int numberOfGuests;

	protected int beers;
	protected int redWine;
	protected int whiteWine;
		
	// template method - TODO is this going to work for the food as well?
	public final void calculateParty() {
		calcBeers();
		calcWhiteWine();
		calcRedWine();

	}
	
	// abstract algorithms to be overridden by subclasses
	abstract void calcBeers();
	abstract void calcRedWine();
	abstract void calcWhiteWine();

	
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
	
	public int getBeers() {
		return beers;
	}

	public int getRedWine() {
		return redWine;
	}

	public int getWhiteWine() {
		return whiteWine;
	}
	
	
}
