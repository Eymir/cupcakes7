package com.cs474;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AnIngredientAct extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    String anIngredient = getIntent().getStringExtra("AN_INGREDIENT");
	    setContentView(R.layout.an_ingredient);
		((TextView) findViewById(R.id.ingredientName)).setText(anIngredient);

	    
	}

}
