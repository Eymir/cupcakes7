package com.cs474;

import android.app.Activity;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
	}
	public String[] recipeList()
    {
    	String toParse = listRecipes();
    	recipes = toParse.split("\n");

    	return recipes;
    }
	
	private native String listRecipes();
    static {
        System.loadLibrary("rmsdk");
    }
}
