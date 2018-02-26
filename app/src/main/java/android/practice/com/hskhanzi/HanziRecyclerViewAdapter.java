package android.practice.com.hskhanzi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.practice.com.hskhanzi.HanziFragment.OnListFragmentInteractionListener;
import android.widget.Toast;

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final DatabaseController dbController = new DatabaseController(holder.mHanziView.getContext());
        holder.mHanziView.setText(mHanziListValues.get(position).getHanzi());

        switch (mHanziListValues.get(position).getLevel()){
            case "1":
                holder.mLevelView.setText("1");
                break;
            case "2":
                holder.mLevelView.setText("2");
                break;
            case "3":
                holder.mLevelView.setText("3");
                break;
            case "4":
                holder.mLevelView.setText("4");
                break;
            default:
                holder.mLevelView.setText("0");
                break;
        }

        // When a tap on a word of the list occur, show it's translation on a Toast
        holder.mHanziView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.mHanziView.getContext(),
                        mHanziListValues.get(holder.getAdapterPosition()).getHanzi()+
                                " ( "+
                                mHanziListValues.get(holder.getAdapterPosition()).getPinyin()+
                                " )"+
                                "\n"+
                                mHanziListValues.get(holder.getAdapterPosition()).getEnglish() , Toast.LENGTH_LONG).show();
            }
        });

        holder.mButtonLevelUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rowId = Integer.parseInt(mHanziListValues.get(holder.getAdapterPosition()).getId());
                int level = dbController.getLevelById(rowId);
                if (level < Hanzi.LEVEL_MAX_VALUE ) {
                    dbController.levelPlusOne(rowId);
                    level++;
                    holder.mLevelView.setText(Integer.toString(level));
                }
            }
        });

        holder.mButtonLevelDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rowId = Integer.parseInt(mHanziListValues.get(holder.getAdapterPosition()).getId());
                int level = dbController.getLevelById(rowId);
                if (level > Hanzi.LEVEL_MIN_VALUE){
                    dbController.levelMinusOne(rowId);
                    level--;
                    holder.mLevelView.setText(Integer.toString(level));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mHanziListValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mLevelView;
        public final TextView mHanziView;
        public final View mButtonLevelDown;
        public final View mButtonLevelUp;

        public ViewHolder(View view) {
            super(view);

            mView = view;
            mLevelView = (TextView) view.findViewById(R.id.textViewLevel);
            mHanziView = (TextView) view.findViewById(R.id.textViewHanzi);
            mButtonLevelDown = view.findViewById(R.id.buttonLevelDown);
            mButtonLevelUp = view.findViewById(R.id.buttonLevelUp);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mHanziView.getText() + "'";
        }
    }
}