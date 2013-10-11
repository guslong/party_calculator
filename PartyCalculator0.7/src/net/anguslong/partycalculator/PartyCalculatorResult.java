package net.anguslong.partycalculator;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import net.anguslong.partycalculator.model.*;

public class PartyCalculatorResult extends Activity {

	static final String TAG = "Party Calculator";
	int numberOfMaleGuests;
	int numberOfFemaleGuests;
	int partyLength;
	
	
	TextView beerResultTextView;
	TextView redWineResultTextView;
	TextView whiteWineResultTextView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// get the extras bundle
		Bundle input = this.getIntent().getExtras();
		
		// set the variables to the values from the bundle
		try {
			numberOfMaleGuests = Integer.parseInt(input.getString("male"));
		} catch (NumberFormatException e) {
			numberOfMaleGuests = 0;
		}
		
		try {
			numberOfFemaleGuests = Integer.parseInt(input.getString("female"));
		} catch (NumberFormatException e) {
			numberOfFemaleGuests = 0;
		}
		
		
		try {
			partyLength = Integer.parseInt(input.getString("length"));
		} catch (NumberFormatException e) {
			partyLength = 1;
		}
		
		displayResults();
		
	}


	private void displayResults() {
		// get references to the textview fields that need to be updated
		beerResultTextView = (TextView)findViewById(R.id.beerResultTextView);
		redWineResultTextView = (TextView) findViewById(R.id.redWineResultTextView);
		whiteWineResultTextView = (TextView) findViewById(R.id.whiteWineResultTextView);

		PartyFactory factory = new PartyFactory();
		
		// get the partyType from the Application "global" variable
		int partyType = ((PartyCalculatorApplication)getApplication()).getPartyType();

		// get the intensity from the preferences
		double intensity = ((PartyCalculatorApplication)getApplication()).getIntensity();
		
		Party party = factory.createParty(partyType, partyLength,numberOfMaleGuests, 
				numberOfFemaleGuests, intensity);
		
		Log.d(TAG, "Created party of type: " + party.toString());
		Log.d(TAG, "Party intensity: " + party.getIntensity());
		
		
		party.calculateParty();
		// replace the text with the results
		beerResultTextView.setText(String.valueOf(party.getBeers()) + " bottles");
		redWineResultTextView.setText(String.valueOf(party.getRedWine())
				+ " bottles");
		whiteWineResultTextView.setText(String.valueOf(party.getWhiteWine())
				+ " bottles");
	}


}
