package ehsan_hn.github.com.mafia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class GameFragment extends Fragment {

    public static String CHARACTER_PARAM = "characters";
    public static String[] shakhsiatList = {"شهروند", "مافیا", "دکتر",
            "کارآگاه", "سایلنسر", "اسنایپر",
            "فراماسون","گادفادر","تروریست",
            "کشیش","جاسوس",
            "ساقی","کلانتر","افسونگر",
            "رویین تن","دزد"};
    public static int[] characterIcon = {R.drawable.shahrvand,
            R.drawable.mafia,
            R.drawable.doctor,
            R.drawable.kargah,
            R.drawable.silenser,
            R.drawable.sniper,
            R.drawable.mason,
            R.drawable.godfather,
            R.drawable.terrorist,
            R.drawable.keshish,
            R.drawable.jasos,
            R.drawable.saghi,
            R.drawable.kalantar,
            R.drawable.afsongar,
            R.drawable.rointan,
            R.drawable.dozd
    };
    public static int[] characterDesc = {
            R.string.shahrvand,
            R.string.mafia_desc,
            R.string.doctor_desc,
            R.string.karagah_desc,
            R.string.faheshe_desc,
            R.string.sniper_desc,
            R.string.framason_desc,
            R.string.goftaher_desc,
            R.string.terorist_desc,
            R.string.keshish_desc,
            R.string.jasos_desc,
            R.string.saghi_desc,
            R.string.karagah_desc,
            R.string.afsongar_desc,
            R.string.robinTan_desc,
            R.string.dozd_desc
    };
    public GameFragment() {
        // Required empty public constructor
    }
    public static GameFragment newInstance() {

        Bundle args = new Bundle();
        GameFragment fragment = new GameFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_game, container, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.game_rv);


        final GameAdapter adapter = new GameAdapter(shakhsiatList, getContext(), characterIcon);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        view.findViewById(R.id.start_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> characterList = new ArrayList<>();
                int j = adapter.getItemCount();
                for (int i = 0;i<j ; i++){
                    int nu = adapter.getSpinnerValue(i);
                    for (int k = 0 ; k < nu; k++){
                        characterList.add(adapter.getCharacterName(i));
                    }
                }
                if (characterList.size()>0){
                    Intent intent = new Intent(getContext(),GameActivity.class);
                    intent.putStringArrayListExtra(CHARACTER_PARAM, (ArrayList<String>) characterList);
                    startActivity(intent);

                }
            }
        });
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
