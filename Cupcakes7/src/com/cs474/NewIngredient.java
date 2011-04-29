package com.cs474;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class NewIngredient extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.new_ingredient);
	    final ToggleButton sizeMeasure = (ToggleButton) findViewById(R.id.new_ingredient_sizeMeasure);
	    final Button createButton = (Button) findViewById(R.id.new_ingredient_create);
	    final EditText ingrName = (EditText) findViewById(R.id.new_ingredient_name);
	    final EditText ingrAmt = (EditText) findViewById(R.id.new_ingredient_amount);
	    final RadioGroup ingrType = (RadioGroup) findViewById(R.id.new_ingredient_type);
	    final String caller = getIntent().getStringExtra("MY_CALLER");
	    sizeMeasure.setText("SM");
	    sizeMeasure.setTextOff("SM");
	    sizeMeasure.setTextOn("LG");
	    
	    createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //helloLog("This is MainMenu speaking.");
            	if(caller.equals("ARecipe"))
            	{
            		String myRecipe = getIntent().getStringExtra("RECIPE_NAME");
            		addToRecipe(myRecipe, ingrName.getText().toString(), 
                    		((RadioButton)findViewById(ingrType.getCheckedRadioButtonId())).getText().toString(), 
                    		Integer.parseInt(ingrAmt.getText().toString()), !sizeMeasure.isChecked());
            	}
            	else
            	{
            		addIngredient(ingrName.getText().toString(), 
                		((RadioButton)findViewById(ingrType.getCheckedRadioButtonId())).getText().toString(), 
                		Integer.parseInt(ingrAmt.getText().toString()), !sizeMeasure.isChecked());
            	}
                setResult(RESULT_OK, new Intent());
                finish();
            }
        });
	}
    private native void addIngredient(String name, String type, int amount, boolean isSmall);
    private native void addToRecipe(String recipeName, String ingredientName, String type, int amount, boolean isSmall);

    static {
        System.loadLibrary("rmsdk");
    }

}
