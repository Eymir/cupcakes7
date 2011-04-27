package com.cs474;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;

public class NewIngredient extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.new_ingredient);
	    final ToggleButton sizeMeasure = (ToggleButton) findViewById(R.id.new_ingredient_sizeMeasure);
	    sizeMeasure.setText("SM");
	    sizeMeasure.setTextOff("SM");
	    sizeMeasure.setTextOn("LG");
	}

}
