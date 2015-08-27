package com.recipe.admin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smit on 27/8/15.
 */
public class instruct extends ActionBarActivity{

    EditText addquan,addtext;
    Button edit;
    //ListView printingre,printquan;
    String recipeName;
    ArrayList<String> ingredients_arr;
    //ArrayList<String> quantity_arr;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingred_look);
        addquan = (EditText)findViewById(R.id.quantity);
        addtext = (EditText)findViewById(R.id.addText);
        edit = (Button)findViewById(R.id.add);
        getSupportActionBar().setTitle("Instructions");
        addquan.setEnabled(false);
        //printingre = (ListView) findViewById(R.id.listView);
        //printquan = (ListView) findViewById(R.id.listView2);
        MainActivity OG = new MainActivity();
        recipeName = OG.recipe_S;
        //final ArrayAdapter<String> arrayAdapter;
        Toast.makeText(instruct.this,recipeName,Toast.LENGTH_SHORT).show();
        //printlist(ingredients_arr,printingre);
        //printlist(quantity_arr,printquan);
        edit.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //ingredients_arr.add(addtext.getText().toString().trim());
                //quantity_arr.add(addquan.getText().toString().trim());
                //arrayAdapter.notifyDataSetChanged();
                ParseObject gameScore = new ParseObject("instructions");
                gameScore.put("recipe", recipeName);
                gameScore.put("instructions", addtext.getText().toString().trim());
                //gameScore.put("quantity", addquan.getText().toString().trim());
                gameScore.saveInBackground();
                Toast.makeText(instruct.this,addtext.getText().toString().trim()+" Added",Toast.LENGTH_SHORT).show();
                addtext.setText("");

            }
        });


    }


    /**void getIngredients() {

     ParseQuery<ParseObject> query = ParseQuery.getQuery("ingredients");
     query.whereEqualTo("recipe", recipeName);
     query.findInBackground(new FindCallback<ParseObject>() {
     public void done(List<ParseObject> ingredients, ParseException e) {
     if (e == null) {
     for (ParseObject question : ingredients) {
     // Get the questionTopic value from the question object

     String ind = question.getString("ingredients");
     ingredients_arr.add(ind);
     ind = null;
     }

     } else {
     Log.d("score", "Error: " + e.getMessage());
     }
     }
     });

     printlist(ingredients_arr);

     }*/

    void printlist(ArrayList<String> arr,ListView view) {



        if (arr.isEmpty()) {

            Toast.makeText(instruct.this, "Empty List", Toast.LENGTH_SHORT).show();
        } else {


            ArrayAdapter<String> arrayAdapter =
                    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);

            view.setAdapter(arrayAdapter);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final Context context = this;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}
