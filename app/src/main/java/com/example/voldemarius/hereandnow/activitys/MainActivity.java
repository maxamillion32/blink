package com.example.voldemarius.hereandnow.activitys;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.voldemarius.hereandnow.R;
import com.example.voldemarius.hereandnow.fragments.FirstWindowFragment;
import com.example.voldemarius.hereandnow.fragments.InterestingFragment;
import com.example.voldemarius.hereandnow.fragments.NearbyFragment;
import com.example.voldemarius.hereandnow.fragments.NewEventFragment;
import com.example.voldemarius.hereandnow.fragments.ProfileFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomBar bottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        implementViews();
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,FirstWindowFragment.newInstance()).addToBackStack(null).commit();//Добавляем перву вкладку (hot and friends)
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId)
                {
                    case R.id.hot:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,FirstWindowFragment.newInstance()).addToBackStack(null).commit();
                        invalidateOptionsMenu();
                    }
                        break;
                    case R.id.nearby:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,NearbyFragment.newInstance()).addToBackStack(null).commit();
                        invalidateOptionsMenu();
                    }
                        break;
                    case R.id.newEvent:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,NewEventFragment.newInstance()).addToBackStack(null).commit();
                        invalidateOptionsMenu();
                    }
                        break;
                    case R.id.interesting:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, InterestingFragment.newInstance()).addToBackStack(null).commit();
                        invalidateOptionsMenu();
                    }
                        break;
                    case R.id.profile:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,ProfileFragment.newInstance()).addToBackStack(null).commit();
                        invalidateOptionsMenu();
                    }
                        break;
                }


            }
        });
    }

    private void implementViews() {
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        bottomBar=(BottomBar) findViewById(R.id.bottomBar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem menuItem=menu.findItem(R.id.friends);//Для того, чтобы спрятать кнопку в меню тулбара
        if (bottomBar.getCurrentTabId()==R.id.hot) {
            menuItem.setVisible(true);
        }
        else {
            menuItem.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.friends)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            for (Fragment fragment : fragmentManager.getFragments()) {
                if (fragment != null && fragment.isVisible() && fragment instanceof FirstWindowFragment) {
                    ((FirstWindowFragment) fragment).changePage(1);//Через кнопку переход на друзей в ViewPager
                }
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
