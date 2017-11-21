package android.practice.com.hskhanzi;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * Fragment containing a table that shows information received by parameter.
 * Corresponds to the first tab of the viewPager
 */
public class StatsFragment extends Fragment{

    private static final String ARG_STATS_DATA = "stats-data";
    private OnFragmentInteractionListener mListener;
    String[][] stats = new String[5][6];

    public StatsFragment() {
        // Required empty public constructor
    }

    public static StatsFragment newInstance(String[][] argStatsData) {
        StatsFragment fragment = new StatsFragment();
        Bundle argsBundle = new Bundle();
        argsBundle.putSerializable(ARG_STATS_DATA, argStatsData);
        fragment.setArguments(argsBundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            stats = (String[][]) getArguments().getSerializable(ARG_STATS_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_stats, container, false);

        GridLayout mGridLayout = (GridLayout) mView.findViewById(R.id.gridLayoutStats);

        String[][] statsGridContent = {{" ","0","1","2","3","4"},
                {"HSK 1",stats[0][0], stats[1][0], stats[2][0], stats[3][0], stats[4][0]},
                {"HSK 2",stats[0][1], stats[1][1], stats[2][1], stats[3][1], stats[4][1]},
                {"HSK 3",stats[0][2], stats[1][2], stats[2][2], stats[3][2], stats[4][2]},
                {"HSK 4",stats[0][3], stats[1][3], stats[2][3], stats[3][3], stats[4][3]},
                {"HSK 5",stats[0][4], stats[1][4], stats[2][4], stats[3][4], stats[4][4]},
                {"HSK 6",stats[0][5], stats[1][5], stats[2][5], stats[3][5], stats[4][5]}};
        for (int row=0; row<=6; row++) {
            for (int col = 0; col <= 5; col++) {
                TextView mTextView = new TextView(getContext());

                if (row%2 == 0)
                    mTextView.setBackgroundColor(Color.GRAY);
                if (col==2)
                    mTextView.setTextColor(getResources().getColor(R.color.red));
                if (col==3)
                    mTextView.setTextColor(getResources().getColor(R.color.yellow));
                if (col==4)
                    mTextView.setTextColor(getResources().getColor(R.color.green));
                if (col==5)
                    mTextView.setTextColor(getResources().getColor(R.color.cyan));

                mTextView.setHeight(50);
                mTextView.setWidth(100);
                mTextView.setGravity(Gravity.CENTER);
                mTextView.setText(statsGridContent[row][col]);
                mGridLayout.addView(mTextView);
            }
        }
        mView.setBackgroundColor(Color.LTGRAY);

        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Hanzi hanzi);
    }
}