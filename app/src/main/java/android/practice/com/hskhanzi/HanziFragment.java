package android.practice.com.hskhanzi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Hanzi.
 */
public class HanziFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;

    //TODO Populate hanziList with data from the database
    @SuppressWarnings("unused")
    List<Hanzi> hanziList;
    int hskLevel = 1;

    public HanziFragment() {
        // Required empty public constructor
    }

    public static HanziFragment newInstance(ArrayList<Hanzi> hanziList) {
        HanziFragment fragment = new HanziFragment();
        // TODO Create bundle with hanziList
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the HSK level to populate the fragment accordingly
        if (getArguments() != null){
            // TODO Receive bundle here
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hanzi_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));

            //TODO Populate hanziList with data from the database
            Hanzi hanziItemDummy_1 = new Hanzi("0","1", "我", "wo", "Me", "1");
            Hanzi hanziItemDummy_2 = new Hanzi("1","1", "你", "ni", "you", "1");

            List<Hanzi> hanziListDummy = new ArrayList<>();
            hanziListDummy.add(hanziItemDummy_1);
            hanziListDummy.add(hanziItemDummy_2);
            recyclerView.setAdapter(new HanziRecyclerViewAdapter(hanziListDummy, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
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

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Hanzi hanzi);
    }
}