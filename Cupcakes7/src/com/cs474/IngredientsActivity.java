package com.cs474;

import com.cs474.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class IngredientsActivity extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.ingredients);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.ingredients, INGREDIENTS));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
            // When clicked, grab the text and send it to the Cupboard/Pantry/Fridge
        	  Intent i = new Intent(IngredientsActivity.this, AnIngredientAct.class);
        	  i.putExtra("AN_INGREDIENT", ((TextView) view).getText());
		      startActivity(i);
          }
      });
    }
    static final String[] INGREDIENTS = new String[] {
	    "Parsley", "Potatos", "Pasta", "Pita", "Pepperoni", "Purple stuff"
	  };
}