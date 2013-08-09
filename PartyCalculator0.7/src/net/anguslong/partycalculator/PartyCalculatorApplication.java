package net.anguslong.partycalculator;

import net.anguslong.partycalculator.model.Party;
import android.app.Application;

public class PartyCalculatorApplication extends Application {

	private int partyType = Party.APERO;
	
	
	public int getPartyType() {
		return partyType;
	}
	
	public void setPartyType(int t) {
		partyType = t;
	}

	@Override
	public void onCreate() {

		super.onCreate();
	}
	
	
}
