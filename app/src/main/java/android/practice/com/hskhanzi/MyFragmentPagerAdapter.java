package android.practice.com.hskhanzi;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 7;
    private Context context;
    private String[] tabTitle = {"统计", "1级", "2级", "3级", "4级", "5级", "6级"};
    private DatabaseController mDatabaseController;



    public MyFragmentPagerAdapter(FragmentManager fragmentManager, Context context){
        super(fragmentManager);
        this.context = context;
        mDatabaseController = new DatabaseController(context);
    }

    @Override
    public int getCount(){
        return PAGE_COUNT;
    }

    //TODO Send data to fragments
    @Override
    public Fragment getItem(int position){
        ArrayList<Hanzi> hanziList = new ArrayList<>();

        int[][] statsInt = mDatabaseController.getStats();
        String[][] statsString = new String[mDatabaseController.STATS_MAX_ROWS][mDatabaseController.STATS_MAX_COLUMNS];
        for ( int row = 0; row < statsInt.length; row++){
            for (int col = 0; col < statsInt[row].length; col++){
                statsString[row][col] = String.valueOf(statsInt[row][col]);
            }
        }

        if (position == 0){
            return StatsFragment.newInstance(statsString);
        }else {
            return HanziFragment.newInstance(mDatabaseController.getHanziListByHsk(position));
        }
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitle[position];
    }


}