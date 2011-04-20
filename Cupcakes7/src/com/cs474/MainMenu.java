package com.cs474;

import com.cs474.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button logButton = (Button) findViewById(R.id.logButton);
        final Button ingredientButton = (Button) findViewById(R.id.ingredientButton);
        ingredientButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(MainMenu.this, IngredientsActivity.class);
		        startActivity(i);
			}	    	
	    });
        logButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                helloLog("This is MainMenu speaking.");
            }
        });

    }
    private native void helloLog(String logThis);
    static {
        System.loadLibrary("rmsdk");
    }
}