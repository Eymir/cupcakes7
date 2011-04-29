package com.cs474;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MenuList extends Activity {

	/** Called when the activity is first created. */
    public static String[] recipes;
    private ListView lView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.checkbox_list_item);
	    lView = (ListView) findViewById(R.id.ListView01);
		 // Set option as Multiple Choice. So that user can able to select more the one option from list
		 lView.setAdapter(new ArrayAdapter<String>(this,
		 android.R.layout.simple_list_item_multiple_choice, recipeList()));
		 lView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		 final Button menuCreateButton = (Button) findViewById(R.id.grocerylb);
		 
	      menuCreateButton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	setupSmenu();
	                SparseBooleanArray stuff = lView.getCheckedItemPositions();
	                for(int i = 0; i<recipes.length; i++)
	                {
	                	if(stuff.get(i) == true)
	                	{
	                	
	                		addToSmenu(i);
	                	}
	                }
	                Intent i = new Intent(MenuList.this, MenuGenerated.class);
	  	          	startActivity(i);
	                //addIngredient("something", "Powdered", 50);
	            }
	        });
	}
	public String[] recipeList()
    {
    	String toParse = listRecipes();
    	recipes = toParse.split("\n");

    	return recipes;
    }
	
	private native String listRecipes();
	private native void setupSmenu();
	private native void addToSmenu(int a);
    static {
        System.loadLibrary("rmsdk");
    }
}
