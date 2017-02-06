package ehsan_hn.github.com.mafia;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    public static String[] shakhsiatList = {"مافیا", "دکتر",
            "کارگاه", "فاحشه", "اسنایپر",
            "فراماسون", "گادفادر", "تروریست",
            "کشیش", "جاسوس",
            "ساقی", "کلانتر", "افسونگر",
            "رویین تن", "دزد"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        GameFragment gf = new GameFragment();
        ft.replace(R.id.listFragment, gf);
        ft.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        switch (item.getItemId()) {
                            case R.id.game_item:

                                GameFragment gf = new GameFragment();
                                ft.replace(R.id.listFragment, gf);
                                ft.commit();
                                break;
                            case R.id.character_item:
                                CharacterFragment cf = new CharacterFragment();
                                ft.replace(R.id.listFragment, cf);
                                ft.commit();
                                break;
                            case R.id.learn_item:
                                LearnFragment lf = new LearnFragment();
                                ft.replace(R.id.listFragment, lf);
                                ft.commit();
                                break;
                        }
                        return false;
                    }
                });
    }
}