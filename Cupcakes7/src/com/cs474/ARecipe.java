package com.cs474;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
    String currentIngredient = null;
    private static final int GET_INGREDIENT = 1;
    private static final int NEW_INGREDIENT = 2;
    private static final int EDIT_INGREDIENT = 3;


    //private ArrayAdapter<String> adp;
    private ListView ingredientList;
    private String aRecipe;
    private int selectedListPosition = -1;
    public static String[] ingredients;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    aRecipe = getIntent().getStringExtra("A_RECIPE");
	    setContentView(R.layout.a_recipe);
		final Button newButton = (Button) findViewById(R.id.a_recipe_new_ingredient_button);
		final Button editButton = (Button) findViewById(R.id.a_recipe_edit_button);
		final Button deleteButton = (Button) findViewById(R.id.a_recipe_deleteButton);
		final Button deleteRecipeButton = (Button) findViewById(R.id.a_recipe_delete_recipe);

		((TextView) findViewById(R.id.a_recipe_Name)).setText(aRecipe);
		ingredientList =(ListView)findViewById(R.id.a_recipe_ingredient_list);
		// By using setAdpater method in listview we an add string array in list.
		//adp = new ArrayAdapter<String>(this,R.layout.simple_list_item, MYINGREDIENTS);
		ingredientList.setAdapter(new ArrayAdapter<String>(getApplicationContext(), 
				R.layout.simple_list_item, ingredientList(aRecipe)));
		deleteButton.getBackground().setColorFilter(0xFFDF3F1F, PorterDuff.Mode.MULTIPLY);
		deleteRecipeButton.getBackground().setColorFilter(0xFFDF3F1F, PorterDuff.Mode.MULTIPLY);
		deleteRecipeButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) 
			{
				deleteRecipe(aRecipe);
				setResult(RESULT_OK, new Intent());
				finish();
			}
		});
		deleteButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) 
			{
				if(selectedListPosition < 0)
				{
					Toast.makeText(getApplicationContext(),"No ingredient selected!", Toast.LENGTH_LONG).show();
				}
				else
				{
					deleteIngredientFromRecipe(aRecipe, currentIngredient);
					ingredientList.setAdapter(new ArrayAdapter<String>(getApplicationContext(), 
	        				R.layout.simple_list_item, ingredientList(aRecipe)));
					/*String str = MYINGREDIENTS[selectedListPosition];
					MYINGREDIENTS[selectedListPosition] = MYINGREDIENTS[MYINGREDIENTS.length - 1];
	                String[] temp = new String[MYINGREDIENTS.length - 1];
	                for(int i = 0; i< MYINGREDIENTS.length - 1; i++)
	                {
	                	temp[i] = MYINGREDIENTS[i];
	                }
	                MYINGREDIENTS = temp;
	                Toast.makeText(getApplicationContext(),"Deleted " + str, Toast.LENGTH_LONG).show();
	        		ingredientList.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
	        				R.layout.simple_list_item, MYINGREDIENTS));*/

				}
				//finish();
			}
	    });
		ingredientList.setOnItemClickListener(new OnItemClickListener() 
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
			{
				currentIngredient = ((TextView) view).getText().toString();
				((TextView) view).setPressed(true);
				selectedListPosition = position;
				//setBackgroundColor(0xFFE4AB0F);
				
			}
		});
		editButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(currentIngredient == null)
				{
					Toast.makeText(getApplicationContext(),"No ingredient selected!",
							Toast.LENGTH_LONG).show();
				}
				else
				{
					Intent i = new Intent(ARecipe.this, AnIngredientAct.class);
		        	i.putExtra("MY_CALLER", "ARecipe");
		        	i.putExtra("RECIPE_NAME", aRecipe);
		        	i.putExtra("AN_INGREDIENT", currentIngredient);
			        startActivityForResult(i, EDIT_INGREDIENT);
				}
			}	    	
	    });
		newButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(ARecipe.this,NewIngredient.class);
	        	i.putExtra("MY_CALLER", "ARecipe");
	        	i.putExtra("RECIPE_NAME", aRecipe);
	        	startActivityForResult(i, NEW_INGREDIENT);
	        	//startActivity(i);
			}	    	
	    });
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == GET_INGREDIENT) {
            	ingredientList.setAdapter(new ArrayAdapter<String>(getApplicationContext(), 
        				R.layout.simple_list_item, ingredientList(aRecipe)));
                //Bundle b = data.getExtras();
                //String str = "";
                //String[] temp = new String[MYINGREDIENTS.length + 1];
               // for(int i = 0; i< MYINGREDIENTS.length; i++)
                //{
                	/*str += *///temp[i] = MYINGREDIENTS[i];
                	//str+= " ";
               // }
                /*str += *///temp[MYINGREDIENTS.length] = b.getString("SEL_INGREDIENT");
                //MYINGREDIENTS = temp;
            	//Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
        		//ingredientList.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
        		//		R.layout.simple_list_item, MYINGREDIENTS));

            	//ingredientList.get
            }
            else if (requestCode == NEW_INGREDIENT) {
            	ingredientList.setAdapter(new ArrayAdapter<String>(getApplicationContext(), 
        				R.layout.simple_list_item, ingredientList(aRecipe)));
            }
            else{
            	ingredientList.setAdapter(new ArrayAdapter<String>(getApplicationContext(), 
        				R.layout.simple_list_item, ingredientList(aRecipe)));
            }
        }
	}
	
	public String[] ingredientList(String name)
    {
    	String toParse = listIngredients(name);
    	ingredients = toParse.split("\n");
    	/*String tempIngredients[] = new String[ingredients.length + 1];
    	for(int i = 0; i<ingredients.length; i++)
    	{
    		tempIngredients[i] = ingredients[i];
    	}
    	tempIngredients[ingredients.length] = "Create new...";
    	return tempIngredients;*/
    	return ingredients;
    }
    
    private native String listIngredients(String name);
	private native void deleteIngredientFromRecipe(String recipeName, String ingredientName);
	private native void deleteRecipe(String name);
	static {
        System.loadLibrary("rmsdk");
    }
	/*private static String[] MYINGREDIENTS = new String[] {
	    "Flour", "Sugar", "Water"
	  };*/

}
