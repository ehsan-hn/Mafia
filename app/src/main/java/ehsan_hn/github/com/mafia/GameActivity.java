package ehsan_hn.github.com.mafia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import ehsan_hn.github.com.mafia.fragment.GameFragment;

public class GameActivity extends AppCompatActivity {
    ArrayList<String> characterList;
    int doubleclick=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        characterList = getIntent().getExtras().getStringArrayList(GameFragment.CHARACTER_PARAM);
        final TextView t = (TextView) findViewById(R.id.showingCharacterTextView);
        findViewById(R.id.background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doubleclick++;
                if (characterList.size()>0) {
                    if (doubleclick == 2) {
                        t.setText(getRandomItem());
                    } else if (doubleclick == 4) {
                        t.setText("");
                        doubleclick = 0;
                    }
                }
                else {
                    finish();
                }
            }
        });
    }
    public String getRandomItem(){
        Random randomizer = new Random();
        int x = randomizer.nextInt(characterList.size());
        String random = characterList.get(x);
        characterList.remove(x);
        return random;
    }


}
