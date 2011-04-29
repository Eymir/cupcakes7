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
import android.widget.Toast;
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
		final String caller = getIntent().getStringExtra("MY_CALLER");
		((TextView) findViewById(R.id.ingredientName)).setText(anIngredient);
		
		deleteButton.getBackground().setColorFilter(0xFFDF3F1F, PorterDuff.Mode.MULTIPLY);
		
		//Get context of call to this page - we are either working with Recipe's ingredients
		//or Pantry's ingredients, and must access the underlying data specific to the call
	    if(caller.equals("ARecipe"))
	    {
		    String aRecipe = getIntent().getStringExtra("RECIPE_NAME");
	    	((TextView) findViewById(R.id.unitText)).setText(" " + getUnits(getTypeFromRecipe(aRecipe,
	    			anIngredient)));
			((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmountFromRecipe(aRecipe,
					anIngredient) + " " + getUnits(getTypeFromRecipe(aRecipe, anIngredient)));
	    }
	    else if(caller.equals("IngredientsActivity"))
	    {
			((TextView) findViewById(R.id.unitText)).setText(" " + getUnits(getType(anIngredient)));
			((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient) 
					+ " " + getUnits(getType(anIngredient)));
	    }
	    else
	    {
            Toast.makeText(getApplicationContext(),caller, Toast.LENGTH_LONG).show();
	    }
	    addButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(caller.equals("ARecipe"))
			    {
				    String aRecipe = getIntent().getStringExtra("RECIPE_NAME");
					addAmountFromRecipe(aRecipe, anIngredient, Integer.parseInt(modAmount.getText().toString()), !sizeMeasure.isChecked());
					if(!sizeMeasure.isChecked())
					{
						((TextView) findViewById(R.id.an_ingredient_amount)).setText(" " + getUnits(getTypeFromRecipe(aRecipe,
			    			anIngredient)));
					}
					else
					{
						((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmountFromRecipe(aRecipe, 
							anIngredient)/getConversionFactor(getTypeFromRecipe(aRecipe, anIngredient))
							+ " " + getUnits(getTypeFromRecipe(aRecipe, anIngredient)));
					}
			    }
				else if(caller.equals("IngredientsActivity"))
			    {
					addAmount(anIngredient, Integer.parseInt(modAmount.getText().toString()), !sizeMeasure.isChecked());
			    
					if(!sizeMeasure.isChecked()){
						((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient) 
								+ " " + getUnits(getType(anIngredient)));}
						else{
							((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient)/getConversionFactor(getType(anIngredient)) 
								+ " " + getUnits(getType(anIngredient)));}
			    }
					
			}	    	
	    });
	    useButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(caller.equals("ARecipe"))
			    {
				    String aRecipe = getIntent().getStringExtra("RECIPE_NAME");
					useAmountFromRecipe(aRecipe, anIngredient, Integer.parseInt(modAmount.getText().toString()), !sizeMeasure.isChecked());
					if(!sizeMeasure.isChecked())
					{
						((TextView) findViewById(R.id.an_ingredient_amount)).setText(" " + getUnits(getTypeFromRecipe(aRecipe,
			    			anIngredient)));
					}
					else
					{
						((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmountFromRecipe(aRecipe, 
							anIngredient)/getConversionFactor(getTypeFromRecipe(aRecipe, anIngredient))
							+ " " + getUnits(getTypeFromRecipe(aRecipe, anIngredient)));
					}
			    }
				else if(caller.equals("IngredientsActivity"))
			    {
					useAmount(anIngredient, Integer.parseInt(modAmount.getText().toString()), !sizeMeasure.isChecked());
					
					if(!sizeMeasure.isChecked()){
						((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient) 
								+ " " + getUnits(getType(anIngredient)));}
						else{
							((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient)/getConversionFactor(getType(anIngredient)) 
								+ " " + getUnits(getType(anIngredient)));}
			    }
					
			}	    	
	    });
		deleteButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(caller.equals("ARecipe"))
			    {
				    String aRecipe = getIntent().getStringExtra("RECIPE_NAME");
				    deleteIngredientFromRecipe(aRecipe, anIngredient);
	                setResult(RESULT_OK, new Intent());
					finish();
			    }
				else if(caller.equals("IngredientsActivity"))
			    {
					deleteIngredient(anIngredient);
	                setResult(RESULT_OK, new Intent());
					finish();
			    }
				else
				{
		            Toast.makeText(getApplicationContext(),"What?", Toast.LENGTH_LONG).show();

				}
			}	    	
	    });
	    sizeMeasure.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				if(caller.equals("ARecipe"))
			    {
				    String aRecipe = getIntent().getStringExtra("RECIPE_NAME");
				    ((TextView) findViewById(R.id.unitText)).setText(" " + getUnits(getTypeFromRecipe(aRecipe, anIngredient)));
				    
					if(!sizeMeasure.isChecked())
					{
						((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmountFromRecipe(aRecipe, anIngredient) 
							+ " " + getUnits(getTypeFromRecipe(aRecipe, anIngredient)));
					}
					else
					{
						((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + 
							getAmountFromRecipe(aRecipe, anIngredient)/getConversionFactor(getTypeFromRecipe(aRecipe, anIngredient)) 
							+ " " + getUnits(getTypeFromRecipe(aRecipe, anIngredient)));
					}
			    }
				else if(caller.equals("IngredientsActivity"))
			    {
					((TextView) findViewById(R.id.unitText)).setText(" " + getUnits(getType(anIngredient)));
			    
					if(!sizeMeasure.isChecked()){
					((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient) 
							+ " " + getUnits(getType(anIngredient)));}
					else{
						((TextView) findViewById(R.id.an_ingredient_amount)).setText("" + getAmount(anIngredient)/getConversionFactor(getType(anIngredient)) 
							+ " " + getUnits(getType(anIngredient)));}
			    }
				
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
	private native int getAmountFromRecipe(String recipeName, String ingredientName);
	private native String getType(String name);
	private native String getTypeFromRecipe(String recipeName, String ingredientName);
	private native void addAmount(String name, int amt, boolean isSmall);
	private native void useAmount(String name, int amt, boolean isSmall);
	private native void deleteIngredient(String name);
	private native void addAmountFromRecipe(String recipeName, String ingredientName, int amt, boolean isSmall);
	private native void useAmountFromRecipe(String recipeName, String ingredientName, int amt, boolean isSmall);
	private native void deleteIngredientFromRecipe(String recipeName, String ingredientName);
	static {
		System.loadLibrary("rmsdk");
	}
}
