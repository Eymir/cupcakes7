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
		deleteButton.getBackground().setColorFilter(0xFFDF3F1F, PorterDuff.Mode.MULTIPLY);
		//Get context of call to this page - we are either working with Recipe's ingredients
		//or Pantry's ingredients, and must access the underlying data specific to the call
		String caller = getIntent().getStringExtra("MY_CALLER");
	    if(caller.equals("ARecipe"))
	    {
	    
	    }
	    else if(caller.equals("IngredientsActivity"))
	    {
	    	
	    }
	    else
	    {
	    	
	    }
		deleteButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}	    	
	    });
	    
	}

}
