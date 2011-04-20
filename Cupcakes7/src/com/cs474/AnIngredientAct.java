package com.cs474;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AnIngredientAct extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    String anIngredient = getIntent().getStringExtra("AN_INGREDIENT");
	    setContentView(R.layout.an_ingredient);
		final Button deleteButton = (Button) findViewById(R.id.deleteButton);
		((TextView) findViewById(R.id.ingredientName)).setText(anIngredient);
		deleteButton.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
		deleteButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}	    	
	    });
	    
	}

}
