package design.example.ngondo.newsfeeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class Home extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Top Stories");
        toolbar.setTitleTextColor(0xffffffff);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        navigationDrawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
     public void navigationDrawer(){
         DrawerLayout drawerLayout =(DrawerLayout) findViewById(R.id.dLayout);
         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                 this, drawerLayout, toolbar, R.string.openDrawer , R.string.closeDrawer);
         drawerLayout.setDrawerListener(toggle);
         toggle.syncState();

         NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(MenuItem item) {
                 int id = item.getItemId();
                 //when either of the ids are selected, do the action
                 switch (id){
                     case R.id.news:
                         Intent i = new Intent(Home.this, News.class);
                         startActivity(i);
                         break;
                     case R.id.sports:
                         Intent j = new Intent(Home.this, Sports.class);
                         startActivity(j);
                         break;
                     case R.id.technical:
                         Intent k = new Intent(Home.this, Tech.class);
                         startActivity(k);
                         break;
                 }

                 DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dLayout);
                 drawer.closeDrawer(GravityCompat.START);
                 return true;
             }
         });

     }

}
