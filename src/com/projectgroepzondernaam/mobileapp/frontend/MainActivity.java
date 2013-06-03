package com.projectgroepzondernaam.mobileapp.frontend;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
public class MainActivity extends TabActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        TabHost tabHost = getTabHost();
         
        // Tab for Apps
        TabSpec appsspec = tabHost.newTabSpec("Apps");
        appsspec.setIndicator("Apps", getResources().getDrawable(R.drawable.icon_apps_tab));
        Intent appsIntent = new Intent(this, AppsActivity.class);
        appsspec.setContent(appsIntent);
         
        // Tab for Account
        TabSpec accountspec = tabHost.newTabSpec("Account");        
        accountspec.setIndicator("Account", getResources().getDrawable(R.drawable.icon_account_tab));
        Intent accountIntent = new Intent(this, AccountActivity.class);
        accountspec.setContent(accountIntent);
         
        // Tab for Goede Doelen
        TabSpec doelenspec = tabHost.newTabSpec("Goede Doelen");
        doelenspec.setIndicator("Goede Doelen", getResources().getDrawable(R.drawable.icon_doelen_tab));
        Intent doelenIntent = new Intent(this, DoelenActivity.class);
        doelenspec.setContent(doelenIntent);
        
        // Tab for Over
        TabSpec overspec = tabHost.newTabSpec("Over");
        overspec.setIndicator("Over", getResources().getDrawable(R.drawable.icon_over_tab));
        Intent overIntent = new Intent(this, OverActivity.class);
        overspec.setContent(overIntent);
         
        // Adding the tabs
        tabHost.addTab(appsspec); 
        tabHost.addTab(accountspec); 
        tabHost.addTab(doelenspec);
        tabHost.addTab(overspec);
    }
}