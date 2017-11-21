package android.practice.com.hskhanzi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.practice.com.hskhanzi.HanziFragment.OnListFragmentInteractionListener;
import java.util.List;

/**
 * Custom Adapter that manage a HanziFragment that contains a list of Hanzi
 */
public class HanziRecyclerViewAdapter extends RecyclerView.Adapter<HanziRecyclerViewAdapter.ViewHolder> {

    private final List<Hanzi> mHanziListValues;
    private final OnListFragmentInteractionListener mListener;

    public HanziRecyclerViewAdapter(List<Hanzi> items, OnListFragmentInteractionListener listener) {
        mHanziListValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_hanzi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mHanziView.setText(mHanziListValues.get(position).getHanzi());
        holder.mPinyinView.setText(mHanziListValues.get(position).getPinyin());

    }

    @Override
    public int getItemCount() {
        return mHanziListValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mHanziView;
        public final TextView mPinyinView;
        public final View mButton;
        public final View mButton2;

        public ViewHolder(View view) {
            super(view);

            mView = view;
            mHanziView = (TextView) view.findViewById(R.id.textViewHanzi);
            mPinyinView = (TextView) view.findViewById(R.id.textViewPinyin);
            mButton = view.findViewById(R.id.button);
            mButton2 = view.findViewById(R.id.button2);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mHanziView.getText() + "'";
        }
    }
}