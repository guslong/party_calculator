package net.anguslong.partycalculator;

import android.app.Application;

public class PartyCalculatorApplication extends Application {

	private int partyType = 1; // stores the type of party, initialised to 1
	
	
	public int getPartyType() {
		return partyType;
	}
	
	public void setPartyType(int t) {
		partyType = t;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
	
	
}
