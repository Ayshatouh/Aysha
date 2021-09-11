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
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {
    ImageView third_back_arrow,third_arrow_up;
    TextView third_title,third_subtitle,third_rating_number,third_rating_number2,more_details2;
    RatingBar third_rating_bar;
    Animation anim_from_left,anim_from_right,anim_from_bottom;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        third_back_arrow = findViewById(R.id.third_back_arrow);
        third_arrow_up = findViewById(R.id.third_arrow_up);
        third_rating_number = findViewById(R.id.third_rating_number);
        third_rating_number2 = findViewById(R.id.third_rating_number2);
        third_title = findViewById(R.id.third_title);
        third_subtitle = findViewById(R.id.third_subtitle);
        third_rating_bar = findViewById(R.id.third_rating_bar);

        third_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        third_arrow_up.setOnClickListener((view) ->  {
            Intent intent = new Intent(FourthActivity.this, SixthActivity.class);

            Pair[] pairs= new Pair[1];
            pairs[0] = new Pair<View, String>(third_arrow_up, "activity_third");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(FourthActivity.this, pairs);

            startActivity(intent, options. toBundle());


        });




    }
}