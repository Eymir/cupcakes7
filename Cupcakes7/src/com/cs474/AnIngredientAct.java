package com.cs474;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class AnIngredientAct extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    final String anIngredient = getIntent().getStringExtra("AN_INGREDIENT");
	    setContentView(R.layout.an_ingredient);
		final Button deleteButton = (Button) findViewById(R.id.deleteButton);
		final Button addButton = (Button) findViewById(R.id.addButton);
		final Button useButton = (Button) findViewById(R.id.useButton);
		final EditText modAmount = (EditText) findViewById(R.id.modifyAmount);
	    final ToggleButton sizeMeasure = (ToggleButton) findViewById(R.id.an_ingredient_sizeMeasure);
	    sizeMeasure.setText("SM");
	    sizeMeasure.setTextOff("SM");
	    sizeMeasure.setTextOn("LG");
		((TextView) findViewById(R.id.unitText)).setText(" " + getUnits(getType(anIngredient)));
		((TextView) findViewById(R.id.ingredientName)).setText(anIngredient);
		((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient) 
				+ " " + getUnits(getType(anIngredient)));
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
	    addButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				addAmount(anIngredient, Integer.parseInt(modAmount.getText().toString()), !sizeMeasure.isChecked());
				if(!sizeMeasure.isChecked()){
					((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient) 
							+ " " + getUnits(getType(anIngredient)));}
					else{
						((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient)/getConversionFactor(getType(anIngredient)) 
							+ " " + getUnits(getType(anIngredient)));}
					
			}	    	
	    });
	    useButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				useAmount(anIngredient, Integer.parseInt(modAmount.getText().toString()), !sizeMeasure.isChecked());
				
				if(!sizeMeasure.isChecked()){
					((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient) 
							+ " " + getUnits(getType(anIngredient)));}
					else{
						((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient)/getConversionFactor(getType(anIngredient)) 
							+ " " + getUnits(getType(anIngredient)));}
					
			}	    	
	    });
		deleteButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				deleteIngredient(anIngredient);
                setResult(RESULT_OK, new Intent());
				finish();
			}	    	
	    });
	    sizeMeasure.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				((TextView) findViewById(R.id.unitText)).setText(" " + getUnits(getType(anIngredient)));
				if(!sizeMeasure.isChecked()){
				((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient) 
						+ " " + getUnits(getType(anIngredient)));}
				else{
					((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient)/getConversionFactor(getType(anIngredient)) 
						+ " " + getUnits(getType(anIngredient)));}
				
			}
	    	
	    });
	}
	
	private String getUnits(String type)
	{
	    ToggleButton sizeMeasure = (ToggleButton) findViewById(R.id.an_ingredient_sizeMeasure);

		if(type.equals("Whole"))
		{
			if(!sizeMeasure.isChecked()) return "units";
			return "lbs";
		}
		else if(type.equals("Liquid"))
		{
			if(!sizeMeasure.isChecked()) return "teaspoons";
			return "fluid oz";
		}
		else if(type.equals("Powdered"))
		{
			if(!sizeMeasure.isChecked()) return "teaspoons";
			return "lbs";
		}
		else
			return "";
	}
	private int getConversionFactor(String type)
	{
	    
		if(type.equals("Whole"))
		{
			return 4;
		}
		else if(type.equals("Liquid"))
		{
			return 16;
		}
		else if(type.equals("Powdered"))
		{
			return 96;
		}
		return 1;
	}
	private native int getAmount(String name);
	private native String getType(String name);
	private native void addAmount(String name, int amt, boolean isSmall);
	private native void useAmount(String name, int amt, boolean isSmall);
	private native void deleteIngredient(String name);
	static {
		System.loadLibrary("rmsdk");
	}
}
