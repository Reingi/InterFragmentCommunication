package com.lakpa.interfragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity  implements FragmentOne.SendMessage{

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void sendData(String message) {

        //System.out.println("the message is: "+message);

        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        FragmentTwo f = (FragmentTwo) getSupportFragmentManager().findFragmentByTag(tag);
        //FragmentTwo f = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.frag2);
        System.out.println(tag);
        f.displayReceivedData(message);
    }
}
