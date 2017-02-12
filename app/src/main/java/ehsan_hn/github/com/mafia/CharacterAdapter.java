package ehsan_hn.github.com.mafia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.MyViewHolder> {
    String[] mCharacterNames;
    int[] mDesces;
    int[] mIcones;
    Context mContext;

    public CharacterAdapter(Context context, String[] ch, int[] desc, int[] icon) {
        mCharacterNames = ch;
        mContext = context;
        mIcones = icon;
        mDesces = desc;
    }

    @Override
    public CharacterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CharacterAdapter.MyViewHolder holder, int position) {
        holder.mIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.mName.setText(mCharacterNames[position]);
        holder.mDesc.setText(mContext.getString(mDesces[position]));
        holder.mIcon.setBackgroundResource(mIcones[position]);
    }

    @Override
    public int getItemCount() {
        return mCharacterNames.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public ImageView mIcon;
        public TextView mDesc;

        public MyViewHolder(View v) {
            super(v);
            mName = (TextView) v.findViewById(R.id.character_listitem_name);
            mIcon = (ImageView) v.findViewById(R.id.character_listitem_imageview);
            mDesc = (TextView) v.findViewById(R.id.character_listitem_desc);
        }

    }
}
