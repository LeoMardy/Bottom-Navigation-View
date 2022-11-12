package com.example.problem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.window.SplashScreen;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Button activityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*--------------To Hide ActionBar---------------*/
        getSupportActionBar().hide();

        /*--------------------------Hooks-------------------------*/
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        activityButton=findViewById(R.id.acivityButton);


            /*----------------Move Activity to Fragment-----------------*/

        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityButton.setVisibility(View.GONE);
                Fragment fragment=new StoriesFragment();
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_Container,fragment).commit();
            }
        });
        /*===================================================================================*/

        /*----------------------Notification (count) Sign ----------------------*/
        BadgeDrawable badgeDrawable=bottomNavigationView.getOrCreateBadge(R.id.notification_id);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);

        /*===================================================================================*/

        /*-----------------------------Condition Part ----------------------------*/
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                    switch (item.getItemId()){
                        case R.id.chat_Id:
                            fragment=new ChatFragment();
                            break;
                        case R.id.videoCall_id:
                            fragment=new CallFragment();
                            break;
                        case R.id.notification_id:
                            fragment=new NotificationFragment();
                            break;

                        case R.id.people_id:
                            fragment=new PeopleFragment();
                            break;
                        case R.id.stories_id:
                            fragment=new StoriesFragment();
                            break;
                    }
                /*--------------------Transaction Fragment---------------------*/
              getSupportFragmentManager().beginTransaction().replace(R.id.main_Container,fragment).commit();

                return false;
            }
        });
        
    }
}
