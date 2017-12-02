package com.uhack.help.Core.View;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.uhack.help.Core.Control.Listener.MenuListener;
import com.uhack.help.Core.View.HelpLoginFragment;
import com.uhack.help.Core.Model.MenuItem;
import com.uhack.help.Core.View.MenuAdapter;
import com.uhack.help.R;

import java.util.ArrayList;


public class HelpLoginActivity extends AppCompatActivity implements MenuListener
{

    DrawerLayout drawer;
    FloatingActionButton fab;
    NavigationView navigationView;
    RecyclerView rv_view;
    MenuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_main);
        getSupportActionBar().hide();
        rv_view = (RecyclerView) findViewById(R.id.rv_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_view.setLayoutManager(layoutManager);
        ArrayList<MenuItem> menus = new ArrayList<>();

        menus.add(new MenuItem("Login"));
        menus.add(new MenuItem("Start Helping"));
        menus.add(new MenuItem("Settings"));
        menus.add(new MenuItem("About Help!"));
        adapter = new MenuAdapter(menus,rv_view,this);

        rv_view.setAdapter(adapter);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        fab = (FloatingActionButton) findViewById(R.id.fab_button);
        navigationView =  (NavigationView) findViewById(R.id.navigation_view);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(navigationView);
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new HelpLoginFragment(),"LOGIN").commit();



    }




    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void selected(MenuItem menu)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.ll_container);
        if(fragment!=null)
        {
            getSupportFragmentManager().beginTransaction().remove(fragment);
        }
        drawer.closeDrawer(navigationView);
        switch (menu.getName())
        {
            case "Login":


                getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new HelpLoginFragment(),"LOGIN").commit();
                break;
            case "Start Helping":
                getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new HelpLoginFragment(),"REGSITER").commit();
                break;
            case "Settings":
                getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new HelpLoginFragment(),"SETTINGS").commit();
                break;
            case "About Help!":
                getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new HelpLoginFragment(),"ABOUT HELP").commit();
                break;
        }
    }
}