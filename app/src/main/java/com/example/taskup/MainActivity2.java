package com.example.taskup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent1;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toogle;
    NavigationView navigationView;
    private boolean isLoggedIn = false; // Change to true if the user is logged in



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

                    /*-------Save login info----------------*/
    // Retrieve login state
        SharedPreferences preferences = getSharedPreferences("APP_PREFS", MODE_PRIVATE);
        isLoggedIn = preferences.getBoolean("isLoggedIn", false);


        /*------------------------Conteneurs---------------------------*/

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        /*----------------------------ToolBar Support---------------------------------*/
        setSupportActionBar(toolbar);

        // Access NavigationView menu
        Menu menu = navigationView.getMenu();
        MenuItem loginItem = menu.findItem(R.id.login_item);
        MenuItem logoutItem = menu.findItem(R.id.logout_item);

        // Set initial visibility based on login state
        if (isLoggedIn) {
            loginItem.setVisible(false);
            logoutItem.setVisible(true);
        } else {
            loginItem.setVisible(true);
            logoutItem.setVisible(false);
        }

        navigationView.bringToFront();
        toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Menu menu = navigationView.getMenu();
        MenuItem loginItem = menu.findItem(R.id.login_item);
        MenuItem logoutItem = menu.findItem(R.id.logout_item);

        if (itemId == R.id.login_item) {
            Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show();
            isLoggedIn = true;

            // Update menu visibility
            loginItem.setVisible(false);
            logoutItem.setVisible(true);

        } else if (itemId == R.id.logout_item) {
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
            isLoggedIn = false;

            // Update menu visibility
            loginItem.setVisible(true);
            logoutItem.setVisible(false);
            intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
            finish();
        }

        if (itemId == R.id.nav_home) {
            // Code for nav_home
        } else if (itemId == R.id.nav_calculator) {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
            Toast.makeText(this, "Calculator", Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.nav_dev) {
            Toast.makeText(this, "Developer", Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.nav_forum) {
            Toast.makeText(this, "Forum", Toast.LENGTH_LONG).show();
        }
        else if (itemId == R.id.profile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show();
        }
        else if (itemId == R.id.email_item) {
            Toast.makeText(this, cm"Email", Toast.LENGTH_LONG).show();
        }
        else if (itemId == R.id.phone_item) {
            Toast.makeText(this, "Phone", Toast.LENGTH_LONG).show();
        }
        else if (itemId == R.id.rate_item) {
            Toast.makeText(this, "Rate", Toast.LENGTH_LONG).show();
        }

        // Close the navigation drawer
        drawerLayout.closeDrawer(GravityCompat.START);




        return true;
    }







}








