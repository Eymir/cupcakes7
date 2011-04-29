package com.cs474;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuGenerated extends ListActivity {

	public static String[] myRecipes;
	/** Called when the activity is first created. */
	@Override
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setListAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item, recipeList()));
        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
	}
	public String[] recipeList()
    {
    	String toParse = listRecipes();
    	myRecipes = toParse.split("\n");

    	return myRecipes;
    }
	
	private native String listRecipes();
    static {
        System.loadLibrary("rmsdk");
    }
}
