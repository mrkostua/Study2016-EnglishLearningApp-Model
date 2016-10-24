package com.example.english_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.english_app.FragmentTabsPager.FragmentNew;
import com.example.english_app.FragmentTabsPager.FragmentPurposes;
import com.example.english_app.FragmentTabsPager.FragmentWorldmap;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationview);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));

    }
        private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentNew(),getString(R.string.tab_new));
        adapter.addFragment(new FragmentPurposes(), getString(R.string.tab_purposes));
        adapter.addFragment(new FragmentWorldmap(), getString(R.string.tab_worldmap));

        viewPager.setAdapter(adapter);

    }

        class ViewPagerAdapter extends FragmentPagerAdapter
        {
            private final List<Fragment> mFragmentList = new ArrayList<>();
            private final List<String> mFragmentTitleList = new ArrayList<>();

            public ViewPagerAdapter(FragmentManager fm)
            {
                super(fm);
            }

            @Override
            public Fragment getItem(int position)
            {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount()
            {
                return mFragmentList.size();
            }

            public void addFragment( Fragment fragment,String title )
            {
                mFragmentList.add(fragment);
                mFragmentTitleList.add(title);

            }

            @Override
            public CharSequence getPageTitle(int position)
            {
                return mFragmentTitleList.get(position);
            }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.action_settings:
                Intent intent = new Intent(this,Settings_Preferences.class);
                startActivity(intent);
                break;
            case R.id.action_books:
                Toast.makeText(this, "You chose Books menu ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_movies:
                Toast.makeText(this, "You chose Movies menu ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_words:
                Toast.makeText(this, "You chose Words menu ", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

        public void Up_button (View view)
    {
        Toast toast = Toast.makeText(this,"Good, you press the up button , welcome to the my English app",Toast.LENGTH_LONG);
        toast.show();

    }
        public void Finish_activity (View view)
    {
        Toast toast = Toast.makeText(this,"By by ",Toast.LENGTH_SHORT);
        toast.show();
        finish();


    }
        public void Text_login_invisibility (View view)
        {
            View text_login = findViewById(R.id.logintext);
            text_login.setVisibility(View.INVISIBLE);
        }
         public void Text_password_invisibility (View view)
         {
            View text_password = findViewById(R.id.passwordtext);
            text_password.setVisibility(View.INVISIBLE);
        }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

}
