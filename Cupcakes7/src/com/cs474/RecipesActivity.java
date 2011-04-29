package com.cs474;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class RecipesActivity extends ListActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final int NEW_RECIPE = 1;

    public static String[] recipes;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setListAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item, recipeList()));
	    final SharedPreferences appData = getSharedPreferences(PREFS_NAME, 0);
	    ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        
	    String caller = getIntent().getStringExtra("MY_CALLER");
	    if(caller.equals("MainMenu"))
	    {
	    	 lv.setOnItemClickListener(new OnItemClickListener() {
		            public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
		            {
		            	String str = (String) ((TextView) view).getText();
		            	
		            	if(str.equals("Create new..."))
		            	{
		  	          	  Intent i = new Intent(RecipesActivity.this, NewRecipe.class);
		  	          	  startActivityForResult(i, NEW_RECIPE);
		            	}
		            	else
		            	{	//When clicked, grab the text and send it to the recipe object
				        	Intent i = new Intent(RecipesActivity.this, ARecipe.class);
				        	i.putExtra("A_RECIPE", ((TextView) view).getText());
				        	startActivity(i);
		            	}
		            }
	    	 });
	    }
	    else
	    {
	        lv.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
	            {
	            	String str = (String) ((TextView) view).getText();
	            	
	            	if(str.equals("Create new..."))
	            	{
	  	          	  Intent i = new Intent(RecipesActivity.this, NewRecipe.class);
	  	          	  startActivityForResult(i, NEW_RECIPE);
	            	}
	            	else
	            	{
		            	SharedPreferences.Editor editor = appData.edit();
		            	editor.putString("SEL_RECIPE", (String) ((TextView) view).getText());
		            	editor.commit();
		            	finish();
	            	}
	            }
	        });
	    }
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode)
            {
            case NEW_RECIPE:
                //String str = "";
            	//Toast.makeText(getApplicationContext(),"yo",Toast.LENGTH_LONG).show();
                setListAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item, recipeList()));
                break;
            }
        }
	}
	
	public String[] recipeList()
    {
    	String toParse = listRecipes();
    	recipes = toParse.split("\n");
    	String tempIngredients[] = new String[recipes.length + 1];
    	for(int i = 0; i<recipes.length; i++)
    	{
    		tempIngredients[i] = recipes[i];
    	}
    	tempIngredients[recipes.length] = "Create new...";
    	return tempIngredients;
    }
	
	private native String listRecipes();
    static {
        System.loadLibrary("rmsdk");
    }
	// RECIPES is just a placeholder for the String[] that should be returned in
    // a C++ NDK function call (depending on context); the "Create new..." option will
	// be added after the fact by this page
	/*static final String[] RECIPES = new String[] {
	    "Tacos", "Hashbrowns", "Spaghetti", "Chocolate Chip Cookies", "Create new..."
	  };*/
}
