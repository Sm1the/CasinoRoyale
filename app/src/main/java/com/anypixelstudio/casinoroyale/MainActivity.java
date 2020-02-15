package com.anypixelstudio.casinoroyale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView spinWheel;
    TextView setUserMoney;
    TextView setStake;
    int userMoney = 100;
    int userStake = 10;
    int Stake = 10;
    Random random;
    int degree = 0, degree_old = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinWheel = findViewById(R.id.iv_SpinWheel);
        setUserMoney = findViewById(R.id.tv_Money);
        setStake = findViewById(R.id.tv_Stake);

        random = new Random();
        setUserMoney.setText("Счет : "+userMoney+" $");

    }

    public void startSpin(View view){
        degree_old = degree % 360;
        degree = random.nextInt(3600)+720;
        RotateAnimation rotateAnimation = new RotateAnimation(degree_old,degree,RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(3600);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        spinWheel.startAnimation(rotateAnimation);
    }

    public void plusStake(View view){
        if (userStake < userMoney){
            userStake = userStake + Stake;
            setStake.setText(userStake+"");
        }else{
            Toast.makeText(MainActivity.this, "У нас недостаточно средств!",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void minusStake(View view){
        if (userStake > Stake){
            userStake = userStake - Stake;
            setStake.setText(userStake+"");

        }else{
           Toast.makeText(MainActivity.this, "Минимальная ставка 10$",
                    Toast.LENGTH_LONG).show();
            userStake = 10;
            setStake.setText("10");
        }


    }
}
