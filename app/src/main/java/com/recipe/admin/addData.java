package com.recipe.admin;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by Smit on 26/8/15.
 */
public class addData extends ActionBarActivity {

    Button intruct,ingred;
    TextView recipe;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_list);
        recipe = (TextView)findViewById(R.id.RecipeName);
        intruct = (Button) findViewById(R.id.instruct);
        ingred = (Button) findViewById(R.id.ingred);
        MainActivity OG = new MainActivity();

        recipe.setText(OG.recipe_S);



    }

    public void instruct(View v){
        final Context context = this;
        Intent intent = new Intent(context, instruct.class);
        startActivity(intent);

    }
    public void ingred(View v){
        final Context context = this;
        Intent intent = new Intent(context, ingred.class);
        startActivity(intent);

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
