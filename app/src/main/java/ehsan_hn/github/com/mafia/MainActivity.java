package ehsan_hn.github.com.mafia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    public static void replaceFragment(Fragment f, FragmentManager fm, boolean backToBackStack) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.listFragment, f);
        if (backToBackStack) {
            ft.addToBackStack("last");
        }
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        GameFragment gf = new GameFragment();
        FragmentManager fm = getSupportFragmentManager();
        replaceFragment(gf, fm, false);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        FragmentManager fm = getSupportFragmentManager();
                        switch (item.getItemId()) {
                            case R.id.game_item:

                                GameFragment gf = new GameFragment();
                                replaceFragment(gf, fm, true);
                                break;
                            case R.id.character_item:
                                CharacterFragment cf = new CharacterFragment();
                                replaceFragment(cf, fm, true);
                                break;
                            case R.id.learn_item:
                                LearnFragment lf = new LearnFragment();
                                replaceFragment(lf, fm, true);
                                break;
                        }
                        return false;
                    }
                });
    }
}