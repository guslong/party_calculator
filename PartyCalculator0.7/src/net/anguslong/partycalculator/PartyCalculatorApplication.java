package net.anguslong.partycalculator;

import net.anguslong.partycalculator.model.Party;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.util.Log;

public class PartyCalculatorApplication extends Application implements OnSharedPreferenceChangeListener {

	static final String TAG = "YambaApp";
	private int partyType = Party.APERO;
	private double intensity = Party.MID_INTENSITY;
	SharedPreferences prefs;

	
	public int getPartyType() {
		return partyType;
	}
	
	public void setPartyType(int t) {
		partyType = t;
	}

	public double getIntensity() {
		return intensity;
	}

	public void setIntensity() {
		
		//this.intensity = intensity;
		
		// get the intensity value, default to 1
		String intensity_str = prefs.getString("party_intensity", "1");
		
		// parse the string to double
		try {
			intensity = Double.parseDouble(intensity_str);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d(TAG, "intensity is set to: " + intensity_str );
		
	}

	@Override
	public void onCreate() {

		super.onCreate();
		
		// get the values from preferences
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		prefs.registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		setIntensity();
		Log.d(TAG, "sharedPreferences changed");
		
	}
	
	
	
}
