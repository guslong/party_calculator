package net.anguslong.partycalculator;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Main extends Activity {

	private static final String SAVED_MALE = "SAVED_MALE";
	private static final String SAVED_FEMALE = "SAVED_FEMALE";
	private static final String SAVED_PARTY_LENGTH = "SAVED_PARTY_LENGTH";
	private static final String LOGGER = "PartyCalculatorLogger";
	
	EditText maleGuestsEditText;
	EditText femaleGuestsEditText;
	EditText partyLengthEditText;
	
	Button calculateButton;
	
	SeekBar partyLengthSeekBar;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// get references to the components
		maleGuestsEditText = (EditText) findViewById(R.id.maleGuestsEditText);
		femaleGuestsEditText = (EditText) findViewById(R.id.femaleGuestsEditText);
		partyLengthEditText = (EditText) findViewById(R.id.partyLengthEditText);
		
		
		calculateButton = (Button) findViewById(R.id.calculateButton);
		calculateButton.setOnClickListener(calculateButtonListener);
		
		partyLengthSeekBar = (SeekBar) findViewById(R.id.partyLengthSeekBar);
		partyLengthSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				Integer partyLength = (seekBar.getProgress()/10 < 1) ? 1 : (seekBar.getProgress()/10);
				partyLengthEditText.setText(partyLength.toString());
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// hides the soft keypad automatically when the seekbar is activated
				((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
						partyLengthEditText.getWindowToken(),0);
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// do nothing	
			}
		});
		
		
		// check if the app just started or is being restored from memory
		if (savedInstanceState == null) {
			Log.d(LOGGER, "no saved state to restore.");
		} else { // restore the variables and set text
			maleGuestsEditText.setText(savedInstanceState.getString(SAVED_MALE));
			femaleGuestsEditText.setText(savedInstanceState.getString(SAVED_FEMALE));
			partyLengthEditText.setText(savedInstanceState.getString(SAVED_PARTY_LENGTH));
			Log.d(LOGGER, "restored saved state");
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(SAVED_MALE, maleGuestsEditText.getText().toString());
		outState.putString(SAVED_FEMALE, femaleGuestsEditText.getText().toString());
		outState.putString(SAVED_FEMALE, femaleGuestsEditText.getText().toString());
		
		Log.d(LOGGER, "onSaveInstanceState called");
	}


	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		setContentView(R.layout.main);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		
		switch (item.getItemId()) {
		case R.id.sel_party_type:
			// launch a AlertDialog with the party type choices
			showPartyOptionsDialog();
			return true;
		case R.id.sel_reset:
			resetInput();
			return true;
		default:
			return false;

		}

	}
	
	private void showPartyOptionsDialog() {
		// create a list with the possible choices from the model
		final String[] partyChoices = getResources().getStringArray(R.array.party_types);
		Log.d(LOGGER, "got resources: " + partyChoices.toString());
		
		// create a new AlertDialog builder and set its title
		AlertDialog.Builder choicesBuilder = new AlertDialog.Builder(this);
		choicesBuilder.setTitle(R.string.choices_title);
		
		// add possible choices to the dialog and set the behaviour when one of the items is clicked
		choicesBuilder.setItems(partyChoices, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int item) {
			
				//  first item is 0 so need to add +1
				int partyKey = item + 1;
				// set the application variable partyType to the item in the array
				
				((PartyCalculatorApplication)getApplication()).setPartyType(partyKey);
				
				
			}
			
					
		});
		
		// create an AlertDialog from the builder
		AlertDialog choicesDialog = choicesBuilder.create();
		
		// show the Dialog
		choicesDialog.show();
		
		// reset the party input
		resetInput();
	}

	public void resetInput() {
		maleGuestsEditText.setText("");
		femaleGuestsEditText.setText("");
		partyLengthEditText.setText("");
		partyLengthSeekBar.setProgress(10);
		maleGuestsEditText.requestFocus();
		Log.d(LOGGER, "reset text");
	}

	OnClickListener calculateButtonListener = new OnClickListener() {
		public void onClick(View arg0) {
			// check that there is already some kind of input
			//if (maleGuestsEditText.getText().toString() != "" && femaleGuestsEditText.getText().toString() != "") {
				
			// when the button is clicked, go to the Result Activity
			Intent submit = new Intent(Main.this,PartyCalculatorResult.class);
			
			// put the values from the fields into the extra bundle
			submit.putExtra("male", maleGuestsEditText.getText().toString());
			submit.putExtra("female", femaleGuestsEditText.getText().toString());
			submit.putExtra("length", partyLengthEditText.getText().toString());
					
			Main.this.startActivity(submit);
			
		}
	};

}
