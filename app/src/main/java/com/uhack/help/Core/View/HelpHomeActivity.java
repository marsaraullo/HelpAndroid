package com.uhack.help.Core.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.uhack.help.Core.Control.Preference.UserPreference;
import com.uhack.help.R;

/**
 * Created by Mars on 12/3/2017.
 */

public class HelpHomeActivity extends AppCompatActivity
{
    BottomNavigationView navigation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_home);
        getSupportActionBar().setHomeButtonEnabled(true);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.ll_container);
                        if(fragment!=null)
                        {
                            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        }
                        getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new HelpHomeFragment(),"HOME").commit();
                        return true;
                    case R.id.navi_signout:
                        UserPreference.setPassword("");
                        UserPreference.setUsername("");

                        Intent i = new Intent(getBaseContext(),HelpLoginActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(i);

                        finish();
                        return true;
                    case R.id.navigation_help:
                        Fragment f = getSupportFragmentManager().findFragmentById(R.id.ll_container);
                        if(f!=null)
                        {
                            getSupportFragmentManager().beginTransaction().remove(f).commit();
                        }
                        getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new HelpFindHelpFragment(),"HELP").commit();
                        return true;
                }
                return false;

            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new HelpHomeFragment(),"HOME").commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.navi_signout:
                    UserPreference.setPassword("");
                    UserPreference.setUsername("");

                    Intent i = new Intent(getBaseContext(),HelpLoginActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);

                    finish();
                    return true;
            }
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    return true;
//                case R.id.navigation_dashboard:
//                    return true;
//                case R.id.navi:
//
//                    return true;
//            }
            return false;
        }
    };
}
