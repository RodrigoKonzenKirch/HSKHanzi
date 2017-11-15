package android.practice.com.hskhanzi;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HanziFragment.OnListFragmentInteractionListener,
        StatsFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPagerActivityMain);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayoutActivityMain);
        tabLayout.setBackgroundColor(Color.BLACK);
        tabLayout.setTabTextColors(Color.LTGRAY ,Color.WHITE);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onListFragmentInteraction(Hanzi argHanzi){

    }

    public void onFragmentInteraction(Hanzi argHanzi){

    }
}
