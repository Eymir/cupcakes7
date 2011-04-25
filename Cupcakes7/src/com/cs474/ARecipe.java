package com.cs474;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ARecipe extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    String aRecipe = getIntent().getStringExtra("A_RECIPE");
	    setContentView(R.layout.a_recipe);
		final Button deleteButton = (Button) findViewById(R.id.a_recipe_deleteButton);
		((TextView) findViewById(R.id.a_recipe_Name)).setText(aRecipe);
		ListView ingredientList =(ListView)findViewById(R.id.a_recipe_ingredient_list);
		// By using setAdpater method in listview we an add string array in list.
		ingredientList.setAdapter(new ArrayAdapter<String>(this,R.layout.simple_list_item, MYINGREDIENTS));
		//View.inflate(ARecipe.this, R.id.a_recipe_ingredient_list, ingredientList);
		deleteButton.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
		deleteButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}	    	
	    });
		
	}
	static final String[] MYINGREDIENTS = new String[] {
	    "Flour 2 cups", "Sugar 1 cup", "Water 1 cup"
	  };

}
