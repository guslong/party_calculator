package net.anguslong.partycalculator;

import net.anguslong.partycalculator.model.Party;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.util.Log;

public class PartyCalculatorApplication extends Application implements
		OnSharedPreferenceChangeListener {

	static final String TAG = "Party Calculator";
	private int partyType = Party.APERO;
	private double intensity = 1;
	SharedPreferences prefs;
	String intensity_pref;

	@Override
	public void onCreate() {
		super.onCreate();
		getPrefs();
	}

	private void getPrefs() {
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		prefs.registerOnSharedPreferenceChangeListener(this);
		setIntensity();

	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {

		getPrefs();
		Log.d(TAG, "sharedPreferences changed");

	}

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

		String intensity_pref = prefs.getString("intensity_pref_key", "error");

		Log.d(TAG, "logging string intensity_pref: " + intensity_pref);

		try {
			intensity = Double.parseDouble(intensity_pref);
			Log.d(TAG, "successfully parsed the prefs value to double");
		} catch (NumberFormatException e) {
			intensity = 1;
			Log.d(TAG,
					"NumberFormatException caused by setIntensity method in PartyCalculatorApplication");
		}
		Log.d(TAG, "intensity is set to: " + intensity);
	}

}
