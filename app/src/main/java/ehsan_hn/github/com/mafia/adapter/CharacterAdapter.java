package ehsan_hn.github.com.mafia.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ehsan_hn.github.com.mafia.MainActivity;
import ehsan_hn.github.com.mafia.R;
import ehsan_hn.github.com.mafia.fragment.CharacterDetail;
import ehsan_hn.github.com.mafia.fragment.GameFragment;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.MyViewHolder>
        implements View.OnClickListener {
    String[] mCharacterNames;
    int[] mDesces;
    int[] mIcones;
    FragmentActivity mContext;
    int mPositon = 0;

    public CharacterAdapter(FragmentActivity context, String[] ch, int[] desc, int[] icon) {
        mCharacterNames = ch;
        mContext = context;
        mIcones = icon;
        mDesces = desc;
    }

    @Override
    public CharacterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_item, parent, false);
        return new MyViewHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(CharacterAdapter.MyViewHolder holder, int position) {
        mPositon = position;
        holder.mIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.mName.setText(mCharacterNames[position]);
        holder.mDesc.setText(mContext.getString(mDesces[position]));
        holder.mIcon.setBackgroundResource(mIcones[position]);
    }

    @Override
    public int getItemCount() {
        return mCharacterNames.length;
    }

    @Override
    public void onClick(View view) {

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public TextView mName;
        public ImageView mIcon;
        public TextView mDesc;
        public FragmentActivity mFragmentActivity;

        public MyViewHolder(View v, FragmentActivity mContext) {
            super(v);
            v.setOnClickListener(this);
            mName = (TextView) v.findViewById(R.id.character_listitem_name);
            mIcon = (ImageView) v.findViewById(R.id.character_listitem_imageview);
            mDesc = (TextView) v.findViewById(R.id.character_listitem_desc);
            mFragmentActivity = mContext;
        }

        @Override
        public void onClick(View view) {
            int postion = this.getAdapterPosition();
            CharacterDetail cd = CharacterDetail.newInstance(GameFragment.shakhsiatList[postion],
                    mFragmentActivity.getString(GameFragment.characterDesc[postion]),
                    GameFragment.characterIcon[postion]);
            FragmentManager fm = mFragmentActivity.getSupportFragmentManager();
            MainActivity.replaceFragment(cd, fm, true);
        }
    }
}
