package android.practice.com.hskhanzi;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 7;
    private Context context;
    private String[] tabTitle = {"统计", "1级", "2级", "3级", "4级", "5级", "6级"};


    public MyFragmentPagerAdapter(FragmentManager fragmentManager, Context context){
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public int getCount(){
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position){
        if (position == 0){
            return StatsFragment.newInstance("","");
        }else {
            //TODO Change return value, return HanziFragment(to be implemented)
            return StatsFragment.newInstance("","");
        }
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitle[position];
    }
}