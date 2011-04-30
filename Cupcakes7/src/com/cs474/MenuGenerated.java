package com.cs474;

import android.app.Activity;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MenuGenerated extends Activity {

	public static String[] myRecipes;
	private ListView lView;
	/** Called when the activity is first created. */
	@Override
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.menu_generated);
	    lView = (ListView) findViewById(R.id.menu_generated_listView1);
	    Button generateShoppingList = (Button)findViewById(R.id.menu_generate_shopping_list);
	    final TextView shopList = (TextView)findViewById(R.id.shopList);

	    lView.setAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item, recipeList()));
	    generateShoppingList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	shopList.setText(generateShoppingList());
            	
            }
	    });
	}
	public String[] recipeList()
    {
    	String toParse = listRecipes();
    	myRecipes = toParse.split("\n");

    	return myRecipes;
    }
	
	private native String generateShoppingList();
	private native String listRecipes();
    static {
        System.loadLibrary("rmsdk");
    }
}
