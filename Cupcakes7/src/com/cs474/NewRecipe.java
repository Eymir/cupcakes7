package com.cs474;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class NewRecipe extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.new_recipe);
	    final EditText recipeName = (EditText) findViewById(R.id.new_recipe_name);
	    final Button createButton = (Button) findViewById(R.id.new_recipe_create);
	    final RadioGroup recipeType = (RadioGroup) findViewById(R.id.new_recipe_type);

	    createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	addRecipe(recipeName.getText().toString(), 
                		((RadioButton)findViewById(recipeType.getCheckedRadioButtonId())).getText().toString());
                setResult(RESULT_OK, new Intent());
                finish();
            }
        });
	}
	
	private native void addRecipe(String name, String type);
    static {
        System.loadLibrary("rmsdk");
    }

}
