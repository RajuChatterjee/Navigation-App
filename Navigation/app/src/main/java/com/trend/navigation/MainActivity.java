package com.trend.navigation;

import android.content.ActivityNotFoundException;

import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.view.View;

import android.widget.Toast;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.android.material.navigation.NavigationView;


//public class MainActivity extends AppCompatActivity {
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String privacylink;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //  ****************************  Navigation and toobar   ************************************

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //    ***********************   Bottom Navigation  **************************

        //1 whatsapp web
        findViewById(R.id.BN1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Loading...1", Toast.LENGTH_SHORT).show();
            }
        });

        //2 save status

        findViewById(R.id.BN2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Loading...2", Toast.LENGTH_SHORT).show();
            }
        });

        //3change language

        findViewById(R.id.BN3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Loading...3", Toast.LENGTH_SHORT).show();

            }
        });

        // 4 whatsapp chat

        findViewById(R.id.BN4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Loading...4", Toast.LENGTH_SHORT).show();
            }
        });


        // 5 whatsapp show dialog

        findViewById(R.id.BN5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Loading...5", Toast.LENGTH_SHORT).show();
            }
        });


        //// ((  ****************************************     content      ***********************************************


        ////   ********************************************    content     *********************************************** ))

    }


    //*********************************************************  Option menu item  *********************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {

            Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.privacylink)));
            startActivity(intent2);
            // Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "Privacy Policy", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.item2) {
            onCreateDialog2();
            Toast.makeText(MainActivity.this, "Loading...2", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.item3) {
            onCreateDialog();
            Toast.makeText(MainActivity.this, "Loading...3", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // *************************************  top navigation menu  *******************************************

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.SN1) {

            Toast.makeText(MainActivity.this, "Loading...1", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.SN2) {

            Toast.makeText(MainActivity.this, "Loading...2", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.SN3) {

            Toast.makeText(MainActivity.this, "Loading...3", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.BN4) {


            Toast.makeText(MainActivity.this, "Loading...4", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.privacy_policy) {
//            webView.loadUrl("https://technicalraju22.blogspot.com/p/privacy-policy_58.html");

            Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.privacylink)));
            startActivity(intent2);
            // Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "Privacy Policy", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.rate_us) {

            try {

                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent gotoMarket = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(gotoMarket);
            } catch (ActivityNotFoundException e) {

                Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                Intent gotoMarket = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(gotoMarket);
            }

            Toast.makeText(MainActivity.this, "Rate Us", Toast.LENGTH_SHORT).show();
            return false;
        } else if (id == R.id.share) {

            Intent intent2 = new Intent(Intent.ACTION_SEND);
            intent2.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_message) + "https://play.google.com/store/apps/details?id=" + getPackageName());
            intent2.setType("text/plain");
            startActivity(intent2);

            Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.about) {
            onCreateDialog2();
            Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.exit) {
            onCreateDialog();
            Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
//      return false;
    }


//exit dialog


    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name))
                .setMessage("Are You Sure You Want To Exit This Application ?")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

// *****************************************  about dialog  ********************************************

    public void onCreateDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name))
                .setIcon(R.mipmap.ic_launcher_round)
                .setMessage(getString(R.string.versionName))
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        builder.setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }


// ************************************   backpress botton  ***************************************


    @Override
    public void onBackPressed() {
        onCreateDialog();
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//
//        } else {
//            super.onBackPressed();
//        }
    }

}

