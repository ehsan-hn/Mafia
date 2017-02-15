package ehsan_hn.github.com.mafia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ehsan_hn.github.com.mafia.R;


public class CharacterDetail extends Fragment {

    private static final String ARG_NAME = "CharacterName";
    private static final String ARG_DESC = "CharacterString";
    private static final String ARG_IC = "characterIcon";

    private String mName;
    private String mDesc;
    private int mIcon;


    public CharacterDetail() {
        // Required empty public constructor
    }


    public static CharacterDetail newInstance(String ch, String desc, int ic) {
        CharacterDetail fragment = new CharacterDetail();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, ch);
        args.putString(ARG_DESC, desc);
        args.putInt(ARG_IC, ic);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
            mDesc = getArguments().getString(ARG_DESC);
            mIcon = getArguments().getInt(ARG_IC);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_detail, container, false);
        ImageView ic = (ImageView) view.findViewById(R.id.character_detail_icon);
        TextView name = (TextView) view.findViewById(R.id.character_detail_name);
        TextView desc = (TextView) view.findViewById(R.id.character_detail_desc);
        ic.setImageResource(mIcon);
        name.setText(mName);
        desc.setText(mDesc);
        return view;
    }


}
