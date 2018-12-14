package vida.donizete.com.br.mobilecurriculosenai.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import vida.donizete.com.br.mobilecurriculosenai.R;

public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.gif)
    ImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ButterKnife.bind(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        startActivity();
    }

    private void startActivity() {
        Glide.with(this).asGif().load(R.drawable.gif).into(gif);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);

                startActivity(i);
            }
        }, 5000);
    }
}
