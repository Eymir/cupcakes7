package com.cs474;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ARecipe extends Activity {
    String currentIngredient = "";
    private static final int GET_INGREDIENT = 1;
    private ArrayAdapter<String> adp;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    String aRecipe = getIntent().getStringExtra("A_RECIPE");
	    setContentView(R.layout.a_recipe);
		final Button newButton = (Button) findViewById(R.id.a_recipe_new_ingredient_button);
		final Button editButton = (Button) findViewById(R.id.a_recipe_edit_button);
		final Button deleteButton = (Button) findViewById(R.id.a_recipe_deleteButton);
		((TextView) findViewById(R.id.a_recipe_Name)).setText(aRecipe);
		ListView ingredientList =(ListView)findViewById(R.id.a_recipe_ingredient_list);
		// By using setAdpater method in listview we an add string array in list.
		adp = new ArrayAdapter<String>(this,R.layout.simple_list_item, MYINGREDIENTS);
		ingredientList.setAdapter(adp);
		deleteButton.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
		deleteButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) 
			{
				finish();
			}
	    });
		ingredientList.setOnItemClickListener(new OnItemClickListener() 
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
			{
				currentIngredient = ((TextView) view).getText().toString();
			}
		});
		editButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(ARecipe.this, AnIngredientAct.class);
	        	i.putExtra("MY_CALLER", "ARecipe");
	        	i.putExtra("AN_INGREDIENT", currentIngredient);
		        startActivity(i);
			}	    	
	    });
		newButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(ARecipe.this,IngredientsActivity.class);
	        	i.putExtra("MY_CALLER", "ARecipe");
	        	startActivityForResult(i, GET_INGREDIENT);
	        	//startActivity(i);
			}	    	
	    });
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == GET_INGREDIENT) {
                Bundle b = data.getExtras();
                String str = "";
                String[] temp = new String[MYINGREDIENTS.length + 1];
                for(int i = 0; i< MYINGREDIENTS.length; i++)
                {
                	str += temp[i] = MYINGREDIENTS[i];
                	str+= " ";
                }
                str += temp[MYINGREDIENTS.length] = b.getString("SEL_INGREDIENT");
                MYINGREDIENTS = temp;
            	Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();

                adp.notifyDataSetChanged();
            }
        }
	}
	static String[] MYINGREDIENTS = new String[] {
	    "Flour", "Sugar", "Water"
	  };

}
