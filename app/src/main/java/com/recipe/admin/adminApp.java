package com.recipe.admin;

import android.app.ActionBar;
import android.app.Application;

import com.parse.Parse;

/**
 * Created by Smit on 26/8/15.
 */
public class adminApp extends Application{

    public void onCreate(){

        super.onCreate();
        // Enable Local Datastore.
        // Enable Local Datastore.


        Parse.initialize(this, "6nP9xgxMPHwqZAyh4AkzJ9R4U0dpdcfN7OH59dTG", "sjxaR61pDvPtzW3IaRZ40JM3GrGpjQx0uGn4Demd");
    }
}
