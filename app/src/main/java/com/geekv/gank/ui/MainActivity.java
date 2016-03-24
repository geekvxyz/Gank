package com.geekv.gank.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Response;
import com.geekv.gank.R;
import com.geekv.gank.adapter.ArticlesAdapter;
import com.geekv.gank.adapter.MyFragmentAdapter;
import com.geekv.gank.bean.Article;
import com.geekv.gank.fragment.AndroidFragment;
import com.geekv.gank.fragment.FuliFragment;
import com.geekv.gank.fragment.IosFragment;
import com.geekv.gank.fragment.JSFragment;
import com.geekv.gank.fragment.VideoFragment;
import com.geekv.gank.utils.HttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager vp;
    TabLayout tablayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MyFragmentAdapter fragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager()
        ,getFragments());
        vp= (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(fragmentAdapter);
        tablayout= (TabLayout) findViewById(R.id.tablayout);
        String[]list_title=new String[]{"Android","iOS","福利","前端","休息视频"};
        //设置TabLayout的模式
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tablayout.addTab(tablayout.newTab().setText(list_title[0]));
        tablayout.addTab(tablayout.newTab().setText(list_title[1]));
        tablayout.addTab(tablayout.newTab().setText(list_title[2]));
        tablayout.addTab(tablayout.newTab().setText(list_title[3]));
        tablayout.addTab(tablayout.newTab().setText(list_title[4]));

        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //切换到指定的item
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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

        if (id == R.id.nav_data) {
            // Handle the camera action

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public List<Fragment> getFragments() {
        List<Fragment>fragments=new ArrayList<>();
        fragments.add(new AndroidFragment());
        fragments.add(new IosFragment());
        fragments.add(new FuliFragment());
        fragments.add(new JSFragment());
        fragments.add(new VideoFragment());
        return fragments;
    }
}
