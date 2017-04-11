package com.food.recipe.recipe.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.food.recipe.recipe.Profile.Profile;
import com.food.recipe.recipe.R;
import com.food.recipe.recipe.adapter.RecyclerViewAdapter;
import com.food.recipe.recipe.login.Login_activity;
import com.food.recipe.recipe.model.Recipe_model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {


    private StaggeredGridLayoutManager _sGridLayoutManager;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        _sGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(_sGridLayoutManager);
        List<Recipe_model> gaggeredList = getListItemData();

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        LinearLayout logo_click = (LinearLayout)findViewById(R.id.singin_logo);
//        Button button = (Button) findViewById(R.id.singin);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();
//
//            }
//        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent iinent= new Intent(MainActivity.this,NewRecipe.class);
                startActivity(iinent);
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
    private List<Recipe_model> getListItemData(){
        List<Recipe_model> listViewItems = new ArrayList<Recipe_model>();

        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.recipe_one));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.recipe_two));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.recipes_three));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.recipe_four));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.recipes_five));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও ", R.drawable.recipe_six));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.recipes_seven));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.recipe_four));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.recipe_one));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.recipe_two));
        listViewItems.add(new Recipe_model("মিশ্র পোলাও", R.drawable.dessert));
        return listViewItems;
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

       if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
