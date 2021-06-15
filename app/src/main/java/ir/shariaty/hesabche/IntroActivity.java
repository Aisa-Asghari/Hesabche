package ir.shariaty.hesabche;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import ir.shariaty.hesabche.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {

    ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(IntroActivity.this, SignupActivity.class));
            }
        }, 3500);

        RunAnimation();

    }

    private void RunAnimation() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotate.reset();
        binding.myName.clearAnimation();
        binding.myName.startAnimation(rotate);
        binding.appName.clearAnimation();
        binding.appName.startAnimation(rotate);

        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        alpha.reset();
        binding.calculator.clearAnimation();
        binding.calculator.startAnimation(alpha);
        binding.dollar.clearAnimation();
        binding.dollar.startAnimation(alpha);
        binding.coin.clearAnimation();
        binding.coin.startAnimation(alpha);
        binding.coin0.clearAnimation();
        binding.coin0.startAnimation(alpha);
    }
}