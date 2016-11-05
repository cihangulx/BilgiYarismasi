package com.cihangul.bilgiyarismasi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DatabaseReference mDataBase;
    public static TextView textView_A, textView_B, textView_C, textView_D, textView_soruNo, textView_dk, textView_soru_metni;
    public static List<Soru> soruList;
    int count;
    public static Button start_buton;
    RelativeLayout relativeLayout1;
    RelativeLayout relativeLayout2;
    RelativeLayout relativeLayout3;
    static int dogru;
    static int yanlis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        soruList = new ArrayList<>();
        mDataBase = FirebaseDatabase.getInstance().getReference().child("Sorular");

        relativeLayout1=(RelativeLayout)findViewById(R.id.relativeLayout1);
        relativeLayout2=(RelativeLayout)findViewById(R.id.relativeLayout2);
        relativeLayout3=(RelativeLayout)findViewById(R.id.relativeLayout3);

        textView_A = (TextView) findViewById(R.id.textView_A);
        textView_B = (TextView) findViewById(R.id.textView_B);
        textView_C = (TextView) findViewById(R.id.textView_C);
        textView_D = (TextView) findViewById(R.id.textView_D);
        textView_dk = (TextView) findViewById(R.id.textView_dk);
        textView_soru_metni = (TextView) findViewById(R.id.textView_soru_metni);
        textView_soruNo = (TextView) findViewById(R.id.textView_soruNo);
        start_buton = (Button) findViewById(R.id.start_buton);


        start_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                dogru=0;
                yanlis=0;
                relativeLayout3.setVisibility(View.INVISIBLE);
                relativeLayout1.setVisibility(View.VISIBLE);
                relativeLayout2.setVisibility(View.VISIBLE);
                if(count<soruList.size()) {
                    soruGetir(soruList.get(count).getSoruMetni()
                            , "" + (count + 1)
                            , soruList.get(count).getSecenekA()
                            , soruList.get(count).getSecenekB()
                            , soruList.get(count).getSecenekC()
                            , soruList.get(count).getSecenekD()

                    );
                    count++;
                }
            }
        });

        textView_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if (soruList.get(count-1).getCevap().equals("A")){
                        textView_A.setBackgroundResource(R.drawable.text_green_background);
                        dogru++;
                    }
                    else {
                        textView_A.setBackgroundResource(R.drawable.text_red_background);
                        yanlis++;
                    }
                }
                catch (Exception e){

                }

                //200 milisaniye beklemesini istiyoruz.

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        //Süre bittikten sonra ne yapması gerektiğini yazıyoruz
                        if(count<soruList.size()) {
                            textView_A.setBackgroundResource(R.drawable.text_background);
                            soruGetir(soruList.get(count).getSoruMetni()
                                    , "" + (count + 1)
                                    , soruList.get(count).getSecenekA()
                                    , soruList.get(count).getSecenekB()
                                    , soruList.get(count).getSecenekC()
                                    , soruList.get(count).getSecenekD()

                            );
                        }

                        else{
                           startActivity(new Intent(getApplicationContext(),Sonuc.class));
                        }
                        count++;
                    }
                }, 200);

            }
        });

        textView_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    if (soruList.get(count-1).getCevap().equals("B")){
                        textView_B.setBackgroundResource(R.drawable.text_green_background);
                        dogru++;
                    }
                    else {
                        textView_B.setBackgroundResource(R.drawable.text_red_background);
                        yanlis++;
                    }

                }catch (Exception e){

                }


                //200 milisaniye beklemesini istiyoruz.

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        //Süre bittikten sonra ne yapması gerektiğini yazıyoruz
                        if(count<soruList.size()) {
                            textView_B.setBackgroundResource(R.drawable.text_background);
                            soruGetir(soruList.get(count).getSoruMetni()
                                    , "" + (count + 1)
                                    , soruList.get(count).getSecenekA()
                                    , soruList.get(count).getSecenekB()
                                    , soruList.get(count).getSecenekC()
                                    , soruList.get(count).getSecenekD()

                            );
                        }

                        else{
                            startActivity(new Intent(getApplicationContext(),Sonuc.class));
                        }
                        count++;
                    }
                }, 200);



            }
        });

        textView_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (soruList.get(count-1).getCevap().equals("C")){
                        textView_C.setBackgroundResource(R.drawable.text_green_background);
                        dogru++;
                    }
                    else {
                        textView_C.setBackgroundResource(R.drawable.text_red_background);
                        yanlis++;
                    }

                }
                catch (Exception e){

                }



                //200 milisaniye beklemesini istiyoruz.

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        //Süre bittikten sonra ne yapması gerektiğini yazıyoruz
                        if(count<soruList.size()) {
                            textView_C.setBackgroundResource(R.drawable.text_background);
                            soruGetir(soruList.get(count).getSoruMetni()
                                    , "" + (count + 1)
                                    , soruList.get(count).getSecenekA()
                                    , soruList.get(count).getSecenekB()
                                    , soruList.get(count).getSecenekC()
                                    , soruList.get(count).getSecenekD()

                            );
                        }

                        else{
                            startActivity(new Intent(getApplicationContext(),Sonuc.class));
                        }
                        count++;
                    }
                }, 200);



            }
        });
        textView_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (soruList.get(count-1).getCevap().equals("D")){
                        textView_D.setBackgroundResource(R.drawable.text_green_background);
                        dogru++;
                    }
                    else {
                        Toast.makeText(getApplicationContext(),""+soruList.get(count).getCevap(),Toast.LENGTH_LONG).show();
                        textView_D.setBackgroundResource(R.drawable.text_red_background);
                        yanlis++;
                    }


                }catch (Exception e){

                }


                //200 milisaniye beklemesini istiyoruz.

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        //Süre bittikten sonra ne yapması gerektiğini yazıyoruz
                        if(count<soruList.size()) {
                            textView_D.setBackgroundResource(R.drawable.text_background);
                            soruGetir(soruList.get(count).getSoruMetni()
                                    , "" + (count + 1)
                                    , soruList.get(count).getSecenekA()
                                    , soruList.get(count).getSecenekB()
                                    , soruList.get(count).getSecenekC()
                                    , soruList.get(count).getSecenekD()

                            );
                        }

                        else{
                            startActivity(new Intent(getApplicationContext(),Sonuc.class));
                        }
                        count++;
                    }
                }, 200);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void soruGetir(String soruMetni, String soruNo, String a_secenegi, String b_secenegi, String c_secenegi, String d_secenegi) {
        textView_soru_metni.setText(soruMetni);
        textView_soruNo.setText(soruNo);
        textView_A.setText(a_secenegi);
        textView_B.setText(b_secenegi);
        textView_C.setText(c_secenegi);
        textView_D.setText(d_secenegi);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (int i = 1; i <= dataSnapshot.getChildrenCount(); i++) {
                    soruList.add(new Soru(dataSnapshot.child("soru"+i).child("soruMetni").getValue().toString()
                            ,dataSnapshot.child("soru"+i).child("aSecenegi").getValue().toString()
                            ,dataSnapshot.child("soru"+i).child("bSecenegi").getValue().toString()
                            ,dataSnapshot.child("soru"+i).child("cSecenegi").getValue().toString()
                            ,dataSnapshot.child("soru"+i).child("dSecenegi").getValue().toString()
                            ,dataSnapshot.child("soru"+i).child("cevap").getValue().toString()));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
