package android.practice.com.hskhanzi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Hanzi.
 */
public class HanziFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    public static final String ARG_HANZILIST = "hanziList";
    List<Hanzi> hanziList;

    public HanziFragment() {
        // Required empty public constructor
    }

    public static HanziFragment newInstance(ArrayList<Hanzi> argHanziList) {
        HanziFragment fragment = new HanziFragment();

        Bundle args = new Bundle();
        args.putSerializable(ARG_HANZILIST, argHanziList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            hanziList = (ArrayList<Hanzi>) getArguments().getSerializable(ARG_HANZILIST);
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

            recyclerView.setAdapter(new HanziRecyclerViewAdapter(hanziList, mListener));
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