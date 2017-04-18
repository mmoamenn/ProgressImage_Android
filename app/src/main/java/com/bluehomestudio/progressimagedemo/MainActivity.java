package com.bluehomestudio.progressimagedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.bluehomestudio.demoprogressimage.R;
import com.bluehomestudio.progressimage.ProgressPicture;

public class MainActivity extends AppCompatActivity {
    LinearLayout mainView;
    ProgressPicture progressPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView = (LinearLayout) findViewById(R.id.main_view);

        progressPicture = new ProgressPicture(this, ProgressPicture.Animations.ROTATION);
        progressPicture.setImageResource(R.drawable.ic_action_name);

        mainView.addView(progressPicture);
    }

}
