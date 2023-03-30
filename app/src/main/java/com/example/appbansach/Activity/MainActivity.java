package com.example.appbansach.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.appbansach.Adapter.MainViewPagerAdapter;
import com.example.appbansach.Fragment.Fragment_Home;
import com.example.appbansach.Fragment.Fragment_Person;
import com.example.appbansach.Fragment.Fragment_Search;
import com.example.appbansach.R;
import com.example.appbansach.Service.APIService;
import com.example.appbansach.Service.DataService;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    public static String Username = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }
    public void init(){
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        Intent t = getIntent();
        if(t.hasExtra("acc") && t!=null){
            Bundle bundle = t.getBundleExtra("acc");
            String username = bundle.getString("username");

            Bundle d = new Bundle();
            d.putString("username",username);
            Fragment_Person libraryFragment = new Fragment_Person();
            libraryFragment.setArguments(d);
            Fragment_Home fragment_home = new Fragment_Home();
            fragment_home.setArguments(d);
            mainViewPagerAdapter.addFragment(fragment_home,"Home");
            mainViewPagerAdapter.addFragment(new Fragment_Search(),"Search");
            mainViewPagerAdapter.addFragment(libraryFragment,"User");
        }else{
            mainViewPagerAdapter.addFragment(new Fragment_Home(),"Home");
            mainViewPagerAdapter.addFragment(new Fragment_Search(),"Search");
            mainViewPagerAdapter.addFragment(new Fragment_Person(),"User");
        }
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.search);
        tabLayout.getTabAt(2).setIcon(R.drawable.account);

    }

    private void anhxa() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
    }
}