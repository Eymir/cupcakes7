package com.cs474;

import com.cs474.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends Activity {
    /** Called when the activity is first created. */
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button logButton = (Button) findViewById(R.id.logButton);
        final Button ingredientButton = (Button) findViewById(R.id.ingredientButton);
        final Button recipeButton = (Button) findViewById(R.id.recipeButton);
        final Button menuButton = (Button) findViewById(R.id.menuButton);
        final SharedPreferences appData = getSharedPreferences(PREFS_NAME, 0);
        
        ingredientButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(MainMenu.this, IngredientsActivity.class);
	        	i.putExtra("MY_CALLER", "MainMenu");
		        startActivity(i);
			}	    	
	    });
        
        recipeButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(MainMenu.this, RecipesActivity.class);
	        	i.putExtra("MY_CALLER", "MainMenu");
		        startActivity(i);
			}	    	
	    });
        
        menuButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//String recipeIngr = appData.getString("SEL_INGREDIENT", "");
				//((TextView) findViewById(R.id.mainHeader)).setText(recipeIngr);
			}	    	
	    });
        
        logButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                helloLog("This is MainMenu speaking.");
                //addIngredient("something", "Powdered", 50);
            }
        });

    }
    private native void helloLog(String logThis);
    static {
        System.loadLibrary("rmsdk");
    }
}