package event.center.booking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class ThirdActivity extends AppCompatActivity {

    ImageView down_arrow;
    ScrollView third_scrollview;
    Animation from_bottom;
    Button like_button;
    @RequiresApi( api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        down_arrow=findViewById(R.id.down_arrow);
        third_scrollview=findViewById(R.id.third_scrollview);
        like_button=findViewById(R.id.like_button);
        from_bottom= AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        down_arrow.setAnimation(from_bottom);

        //Hide status bar and navigation bar at the bottom
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                       | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                       | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                       | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                       | View.SYSTEM_UI_FLAG_FULLSCREEN
                       | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        like_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seventhActivity = new Intent(ThirdActivity.this, SeventhActivity.class);
                startActivity(seventhActivity);
            }
        });

        down_arrow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(down_arrow, "activity_second");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ThirdActivity.this, pairs);

                startActivity(intent, options.toBundle());
            }
        });

    }
}