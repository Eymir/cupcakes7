package com.cs474;

import java.util.ArrayList;

import com.cs474.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final int CREATE_NEW = 1;
    public static final int CREATE_NEW_RETURN = 2;
    public static final int EDIT_VIEW = 3;
    public static String[] ingredients;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.ingredients);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item, ingredientList()));
        final SharedPreferences appData = getSharedPreferences(PREFS_NAME, 0);

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
	    String caller = getIntent().getStringExtra("MY_CALLER");
	    if(caller.equals("MainMenu"))
	    {
	    	lv.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
	            {
	              // When clicked, grab the text and send it to the Cupboard/Pantry/Fridge
	            	String str = (String) ((TextView) view).getText();
	            	//Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();

	            	if(str.equals("Create new..."))
	            	{
	  	          	  Intent i = new Intent(IngredientsActivity.this, NewIngredient.class);
	  	          	  startActivityForResult(i, CREATE_NEW);
	            	}
	            	else
	            	{
	            		Intent i = new Intent(IngredientsActivity.this, AnIngredientAct.class);
	          	  		i.putExtra("MY_CALLER", "IngredientsActivity");
	          	  		i.putExtra("AN_INGREDIENT", ((TextView) view).getText());
	          	  		startActivityForResult(i, EDIT_VIEW);
	            	}
	            }
	          });
	    }
	    else if(caller.equals("ARecipe"))
	    {
	    	lv.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
	            {
	              // When clicked, grab the text and return it to the calling context
	            	String str = (String) ((TextView) view).getText();
	            	//Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();

	          	  //SharedPreferences.Editor editor = appData.edit();
	          	  //editor.putString("SEL_INGREDIENT", (String) ((TextView) view).getText());
	          	  //editor.commit();
	          	  //finish();
	            	if(str.equals("Create new..."))
	            	{
	  	          	  Intent i = new Intent(IngredientsActivity.this, NewIngredient.class);
	  	          	  startActivityForResult(i, CREATE_NEW_RETURN);
	            	}
	            	else
	            	{
		            	Bundle bundle = new Bundle();
		            	bundle.putString("SEL_INGREDIENT", str);
		            	Intent mIntent = new Intent();
		            	mIntent.putExtras(bundle);
		            	setResult(RESULT_OK, mIntent);
		            	//Toast.makeText(getApplicationContext(),(String) ((TextView) view).getText(),Toast.LENGTH_LONG).show();
		            	finish();
	            	}
	            }
	          });
	    }
	    else
	    {
	    	
	    }
        
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode)
            {
            case CREATE_NEW:
                //String str = "";
            	//Toast.makeText(getApplicationContext(),"yo",Toast.LENGTH_LONG).show();
                setListAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item, ingredientList()));
                break;
            case EDIT_VIEW:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item, ingredientList()));
                break;
            	//ingredientList.get
            }
        }
	}
    public String[] ingredientList()
    {
    	String toParse = listIngredients();
    	ingredients = toParse.split("\n");
    	String tempIngredients[] = new String[ingredients.length + 1];
    	for(int i = 0; i<ingredients.length; i++)
    	{
    		tempIngredients[i] = ingredients[i];
    	}
    	tempIngredients[ingredients.length] = "Create new...";
    	return tempIngredients;
    }
    
    private native String listIngredients();
    static {
        System.loadLibrary("rmsdk");
    }
    // INGREDIENTS is just a placeholder for the String[] that should be returned in
    // a C++ NDK function call (depending on context); the "Create new..." option will
	// be added after the fact by this page
    /*static final String[] INGREDIENTS = new String[] {
	    "Parsley", "Potatos", "Pasta", "Pita", "Pepperoni", "Create new..."
	  };*/
}