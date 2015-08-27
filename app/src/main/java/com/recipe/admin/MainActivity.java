package com.recipe.admin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    public static String recipe_S;
    EditText recipe,desc,time,calories,serving;
    String time_s,calories_s,serving_s;
    Button add;
    String mainCategory,desc_S;
    RadioGroup topic;
    RadioButton bf,mc,sk,ts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recipe = (EditText) findViewById(R.id.Recipe);
        recipe_S = recipe.getText().toString().trim();
        topic = (RadioGroup)findViewById(R.id.radiogrp);
        desc = (EditText)findViewById(R.id.desc);
        serving = (EditText) findViewById(R.id.serving);
        time = (EditText) findViewById(R.id.time);
        calories = (EditText) findViewById(R.id.calories);
        topic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected
        switch (checkedId) {
        case R.id.radioButton:
        Toast.makeText(MainActivity.this,"Breakdast",Toast.LENGTH_SHORT).show();
        break;
        case R.id.radioButton2:
        Toast.makeText(MainActivity.this,"Main course",Toast.LENGTH_SHORT).show();
        break;
        case R.id.radioButton3:
        Toast.makeText(MainActivity.this,"snacks",Toast.LENGTH_SHORT).show();
        break;
        case R.id.radioButton4:
        Toast.makeText(MainActivity.this,"Todays special",Toast.LENGTH_SHORT).show();
        break;
        default:
        break;
        }

            }



        });

        bf = (RadioButton)findViewById(R.id.radioButton);
        mc = (RadioButton)findViewById(R.id.radioButton2);
        sk = (RadioButton) findViewById(R.id.radioButton3);
        ts = (RadioButton) findViewById(R.id.radioButton4);



        final Context context = this;
        add = (Button) findViewById(R.id.button);
        View.OnClickListener oclBtnOk2 = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // change text of the TextView (tvOut)
                int selectedID = topic.getCheckedRadioButtonId();

                if(selectedID==bf.getId()){
                    mainCategory = "Breakfast";
                }
                else if(selectedID==mc.getId()){
                    mainCategory = "Main Course";
                }
                else if(selectedID==sk.getId()){
                    mainCategory = "Snacks";
                }
                else if(selectedID==ts.getId()){
                    mainCategory = "Today's Special";
                }
                else{


                }

                recipe_S = recipe.getText().toString().trim();
                desc_S = desc.getText().toString().trim();

                time_s = time.getText().toString().trim();
                serving_s = serving.getText().toString().trim();
                calories_s = calories.getText().toString().trim();
                if(recipe_S!=null&&mainCategory!=null&&desc_S!=null&&time_s!=null&&serving_s!=null&&calories_s!=null){
                   /** ParseObject gameScore = new ParseObject("recipes");

                    gameScore.getObjectId();
                    gameScore.saveInBackground();
                    String message = "Added: "+mainCategory+" : "+recipe_S;*/

                    ParseObject gameScore = new ParseObject("recipes");
                    gameScore.put("recipes", recipe_S);
                    gameScore.put("Main_Categories", mainCategory);
                    gameScore.put("Description", desc_S);
                    gameScore.put("like", 0);
                    gameScore.put("Time",Integer.parseInt(time_s));
                    gameScore.put("serving",Integer.parseInt(serving_s));
                    gameScore.put("calories",Integer.parseInt(calories_s));
                    gameScore.saveInBackground();
                    Toast.makeText(MainActivity.this, gameScore.getObjectId(),Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(context, addData.class);
                    startActivity(intent);
                }

            }
        };


        add.setOnClickListener(oclBtnOk2);
        //ParseObject gameScore = new ParseObject("recipes");
        //gameScore.put("recipes", recipe_S);

        //gameScore.saveInBackground();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        return;
    }


}
/**
 if (checkedId == R.id.silent) {

 Toast.makeText(getApplicationContext(), "choice: Silent",

 Toast.LENGTH_SHORT).show();

 } else if (checkedId == R.id.sound) {

 Toast.makeText(getApplicationContext(), "choice: Sound",

 Toast.LENGTH_SHORT).show();

 } else {

 Toast.makeText(getApplicationContext(), "choice: Vibration",

 Toast.LENGTH_SHORT).show();

 }


 switch (checkedId) {
 case R.id.radioButton:
 Toast.makeText(MainActivity.this,"Breakdast",Toast.LENGTH_SHORT).show();
 break;
 case R.id.radioButton2:
 Toast.makeText(MainActivity.this,"Main course",Toast.LENGTH_SHORT).show();
 break;
 case R.id.radioButton3:
 Toast.makeText(MainActivity.this,"snacks",Toast.LENGTH_SHORT).show();
 break;
 case R.id.radioButton4:
 Toast.makeText(MainActivity.this,"Todays special",Toast.LENGTH_SHORT).show();
 break;
 default:
 break;
 }*/