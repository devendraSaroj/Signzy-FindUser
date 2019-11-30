package com.devendra_saroj.finduser.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.devendra_saroj.finduser.R;
import com.google.android.material.tabs.TabLayout;

public class DetailActivity extends AppCompatActivity {


    Toolbar toolbar, toolbartab;
    ViewPager viewPager;
    TabLayout tabLayout;
    PageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbartab = (Toolbar) findViewById(R.id.toolbartab);
        viewPager = (ViewPager)  findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout1);

        pageAdapter = new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new ProfileFragment(), "Profile");
        pageAdapter.addFragment(new RepoFragment(), "Repo");

        viewPager.setAdapter(pageAdapter);
    }
}
