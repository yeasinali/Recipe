package com.food.recipe.recipe.Profile;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.food.recipe.recipe.R;
import com.food.recipe.recipe.tabs.Description;

public class Profile extends AppCompatActivity {
    Context context;
    TabLayout tabLayout;
    ViewPager viewPager;
    AppBarLayout appbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = getApplicationContext();
        //getSupportActionBar().hide();

        tabLayout = (TabLayout) findViewById(R.id.profile_tabLayout);
        viewPager = (ViewPager) findViewById(R.id.profile_viewpager);
        viewPager.setAdapter(new TabsAdapter(context, getSupportFragmentManager()));
        viewPager.setAdapter(new TabsAdapter(context, getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

}
class TabsAdapter extends FragmentPagerAdapter {

    Context context;

    public TabsAdapter(Context con , FragmentManager fm) {
        super(fm);
        this.context = con;
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return Description.newInstance("","");
            case 1:
                //add your fragment
                return Description.newInstance("","");
            case 2:
                //add your fragment
                return Description.newInstance("","");
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "প্রিয়";
            case 1:
                return "আমার তৈরি";
            case 2:
                return "বন্ধুরা";
        }
        return "";
    }
}
