package com.cs474;

import android.app.Activity;
import android.app.ListActivity;
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

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setListAdapter(new ArrayAdapter<String>(this, R.layout.ingredients, RECIPES));
	    final SharedPreferences appData = getSharedPreferences(PREFS_NAME, 0);
	    ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
            {
              // When clicked, grab the text and send it to the Cupboard/Pantry/Fridge
          	  //Intent i = new Intent(IngredientsActivity.this, AnIngredientAct.class);
          	  //i.putExtra("AN_INGREDIENT", ((TextView) view).getText());
  		      //startActivity(i);
          	  SharedPreferences.Editor editor = appData.edit();
          	  editor.putString("SEL_RECIPE", (String) ((TextView) view).getText());
          	  editor.commit();
          	  finish();
            }
        });
	}
	static final String[] RECIPES = new String[] {
	    "Tacos", "Hashbrowns", "Spaghetti", "Chocolate Chip Cookies", "Pepperoni Pizza"
	  };
}
