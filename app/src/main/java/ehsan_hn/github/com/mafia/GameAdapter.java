package ehsan_hn.github.com.mafia;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class GameAdapter extends RecyclerView.Adapter<GameAdapter.MyViewHolder> {
    private String[] mDataset;
    private Context mContext;
    private int[] mIcon;
    private int[] spValue;


    // Provide a suitable constructor (depends on the kind of dataset)
    public GameAdapter(String[] myDataset, Context context, int[] icon) {
        mDataset = myDataset;
        mContext = context;
        mIcon = icon;
        spValue = new int[myDataset.length];
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextView.setText(mDataset[position]);
        CircleTransform cf  = new CircleTransform();
        Picasso.with(mContext).load(mIcon[position]).transform(cf).into(holder.mIcon);
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i<10;i++) {
            list.add(String.valueOf(i));
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(mContext,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.mSpinner.setAdapter(dataAdapter);
        holder.mSpinner.setSelection(spValue[position]);
        holder.mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spValue[position] = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public int getSpinnerValue(int i){
        return spValue[i];
    }

    public String getCharacterName(int i){
        return mDataset[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView mTextView;
        public Spinner mSpinner;
        public ImageView mIcon;
        public TextView mDesc;
        public MyViewHolder(View v) {
            super(v);
            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.item_name);
            mSpinner = (Spinner) v.findViewById(R.id.item_spinner);
            mIcon = (ImageView) v.findViewById(R.id.icon);
            mDesc = (TextView) v.findViewById(R.id.item_desc);
        }

    }




}
