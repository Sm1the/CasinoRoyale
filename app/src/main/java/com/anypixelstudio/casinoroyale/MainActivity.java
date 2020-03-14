package com.anypixelstudio.casinoroyale;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    boolean checkStake = false;
    boolean useSpin = false;


    ImageView spinWheel;
    TextView setUserMoney;
    TextView setStake;
    ImageView coinLower;
    ImageView coinUpper;
    ImageView coinEven;
    ImageView coinOdd;
    ImageView coinRed;
    ImageView coinBlack;
    ImageView coinZero;
    ImageView coinDoubleZero;

    int userMoney = 100;
    int userStake = 10;
    int Stake = 10;

    int getUserSelect = 0;

    Random random;
    int degree = 0, degree_old = 0;
    private static final float FACTOR = 4.86f;

    int Lower[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
    int Upper[] = {19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
    int Even[] = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
    int Odd[] = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
    int Red[] = {32,19,21,25,34,27,36,30,23,5,16,1,14,9,18,7,12,3};
    int Black[] = {15,4,2,17,6,13,11,8,10,24,33,20,31,22,29,28,35,26};
    int Zero_DoubleZero[] = {0};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinWheel = findViewById(R.id.iv_SpinWheel);
        setUserMoney = findViewById(R.id.tv_Money);
        setStake = findViewById(R.id.tv_Stake);

        coinLower = findViewById(R.id.iv_Lower);
        coinUpper = findViewById(R.id.iv_Upper);
        coinEven = findViewById(R.id.iv_Even);
        coinOdd = findViewById(R.id.iv_Odd);
        coinRed = findViewById(R.id.iv_Red);
        coinBlack = findViewById(R.id.iv_Black);
        coinZero = findViewById(R.id.iv_Zero);
        coinDoubleZero = findViewById(R.id.iv_DoubleZero);

        random = new Random();
        setUserMoney.setText("Счет : "+userMoney+" $");


    }

    public void startSpin(View view){
        if(userMoney != 0) {
            if (checkStake == true) {
                if(useSpin == false) {

                    userMoney = userMoney - userStake;
                    setUserMoney.setText("Счет : " + userMoney + "$");

                    setStake.setText(userStake + "");


                    degree_old = degree % 360;
                    degree = random.nextInt(3600) + 720;
                    RotateAnimation rotateAnimation = new RotateAnimation(degree_old, degree, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(3600);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setInterpolator(new DecelerateInterpolator());
                    rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                            Toast.makeText(MainActivity.this, "Вы поставили " + userStake + "$",
                                    Toast.LENGTH_LONG).show();
                            useSpin = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            String numberString = currentNumber(360 - (degree % 360));
                            Pattern pattern = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                            Matcher matcher = pattern.matcher(numberString);
                            int start = 0;
                            int result = 0;
                            while (matcher.find(start)) {
                                String value = numberString.substring(matcher.start(), matcher.end());
                                result = Integer.parseInt(value);
                                start = matcher.end();
                            }
                            switch (getUserSelect) {
                                case 1:
                                    for (int i = 0; i < Lower.length; i++) {
                                        if (result == Lower[i]) {
                                            userMoney = userMoney + (userStake * 2);
                                            setUserMoney.setText("Счет : " + userMoney + " $");
                                        }

                                    }
                                    break;
                                case 2:
                                    for (int i = 0; i < Upper.length; i++) {
                                        if (result == Upper[i]) {
                                            userMoney = userMoney + (userStake * 2);
                                            setUserMoney.setText("Счет : " + userMoney + " $");
                                        }

                                    }
                                    break;
                                case 3:
                                    for (int i = 0; i < Even.length; i++) {
                                        if (result == Even[i]) {
                                            userMoney = userMoney + (userStake * 2);
                                            setUserMoney.setText("Счет : " + userMoney + " $");
                                        }

                                    }
                                    break;
                                case 4:
                                    for (int i = 0; i < Odd.length; i++) {
                                        if (result == Odd[i]) {
                                            userMoney = userMoney + (userStake * 2);
                                            setUserMoney.setText("Счет : " + userMoney + " $");
                                        }

                                    }
                                    break;
                                case 5:
                                    for (int i = 0; i < Red.length; i++) {
                                        if (result == Red[i]) {
                                            userMoney = userMoney + (userStake * 2);
                                            setUserMoney.setText("Счет : " + userMoney + " $");
                                        }

                                    }
                                    break;
                                case 6:
                                    for (int i = 0; i < Black.length; i++) {
                                        if (result == Black[i]) {
                                            userMoney = userMoney + (userStake * 2);
                                            setUserMoney.setText("Счет : " + userMoney + " $");
                                        }

                                    }
                                    break;
                                case 7:
                                    for (int i = 0; i < Zero_DoubleZero.length; i++) {
                                        if (result == Zero_DoubleZero[i]) {
                                            userMoney = userMoney + (userStake * 2);
                                            setUserMoney.setText("Счет : " + userMoney + " $");
                                        }

                                    }
                                    break;
                                case 8:
                                    for (int i = 0; i < Zero_DoubleZero.length; i++) {
                                        if (result == Zero_DoubleZero[i]) {
                                            userMoney = userMoney + (userStake * 2);
                                            setUserMoney.setText("Счет : " + userMoney + " $");
                                        }

                                    }
                                    break;
                            }
                            Toast.makeText(MainActivity.this, currentNumber(360 - (degree % 360)),
                                    Toast.LENGTH_LONG).show();
                            useSpin = false;
                            checkStake = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    spinWheel.startAnimation(rotateAnimation);
                }
            } else {
                Toast.makeText(MainActivity.this, "Вы не выбрали число/цвет!",
                        Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(MainActivity.this, "У вас кончились деньги!",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void setNumberLower(View view){
        getUserSelect = 1;
        checkStake = true;
        Toast.makeText(MainActivity.this, "Вы поставили на числа от 1 до 18",
                Toast.LENGTH_LONG).show();
    }

    public void setNumberUpper(View view){
        getUserSelect = 2;
        checkStake = true;
        Toast.makeText(MainActivity.this, "Вы поставили на числа от 19 до 36",
                Toast.LENGTH_LONG).show();
    }

    public void setNumberEven(View view){
        getUserSelect = 3;
        checkStake = true;
        Toast.makeText(MainActivity.this, "Вы поставили на все четные",
                Toast.LENGTH_LONG).show();
    }

    public void setNumberOdd(View view){
        getUserSelect = 4;
        checkStake = true;
        Toast.makeText(MainActivity.this, "Вы поставили на все нечетные",
                Toast.LENGTH_LONG).show();
    }

    public void setNuberRed(View view){
        getUserSelect = 5;
        checkStake = true;
        Toast.makeText(MainActivity.this, "Вы поставили на красные",
                Toast.LENGTH_LONG).show();
    }

    public void setNumberBlack(View view){
        getUserSelect = 6;
        checkStake = true;
        Toast.makeText(MainActivity.this, "Вы поставили на черные",
                Toast.LENGTH_LONG).show();
    }

    public void setNumberZero(View view){
        getUserSelect = 7;
        checkStake = true;
        Toast.makeText(MainActivity.this, "Вы поставили на 0",
                Toast.LENGTH_LONG).show();
    }

    public void setNumberDoubleZero(View view){
        getUserSelect = 8;
        checkStake = true;
        Toast.makeText(MainActivity.this, "Вы поставили на удвоенный 0",
                Toast.LENGTH_LONG).show();
    }

    private String currentNumber(int degrees){
        String text = "";

        if(degrees >= (FACTOR * 1) && degrees < (FACTOR * 3)){
            text = "32 красное";
        }
        if(degrees >= (FACTOR * 3) && degrees < (FACTOR * 5)){
            text = "15 черное";
        }
        if(degrees >= (FACTOR * 5) && degrees < (FACTOR * 7)){
            text = "19 красное";
        }
        if(degrees >= (FACTOR * 7) && degrees < (FACTOR * 9)){
            text = "4 черное";
        }
        if(degrees >= (FACTOR * 9) && degrees < (FACTOR * 11)){
            text = "21 красное";
        }
        if(degrees >= (FACTOR * 11) && degrees < (FACTOR * 13)){
            text = "2 черное";
        }
        if(degrees >= (FACTOR * 13) && degrees < (FACTOR * 15)){
            text = "25 красное";
        }
        if(degrees >= (FACTOR * 15) && degrees < (FACTOR * 17)){
            text = "17 черное";
        }
        if(degrees >= (FACTOR * 17) && degrees < (FACTOR * 19)){
            text = "34 красное";
        }
        if(degrees >= (FACTOR * 19) && degrees < (FACTOR * 21)){
            text = "6 черное";
        }
        if(degrees >= (FACTOR * 21) && degrees < (FACTOR * 23)){
            text = "27 красное";
        }
        if(degrees >= (FACTOR * 23) && degrees < (FACTOR * 25)){
            text = "13 черное";
        }
        if(degrees >= (FACTOR * 25) && degrees < (FACTOR * 27)){
            text = "36 красное";
        }
        if(degrees >= (FACTOR * 27) && degrees < (FACTOR * 29)){
            text = "11 черное";
        }
        if(degrees >= (FACTOR * 29) && degrees < (FACTOR * 31)){
            text = "30 красное";
        }
        if(degrees >= (FACTOR * 31) && degrees < (FACTOR * 33)){
            text = "8 черное";
        }
        if(degrees >= (FACTOR * 33) && degrees < (FACTOR * 35)){
            text = "23 красное";
        }
        if(degrees >= (FACTOR * 35) && degrees < (FACTOR * 37)){
            text = "10 черное";
        }
        if(degrees >= (FACTOR * 37) && degrees < (FACTOR * 39)){
            text = "5 красное";
        }
        if(degrees >= (FACTOR * 39) && degrees < (FACTOR * 41)){
            text = "24 черное";
        }
        if(degrees >= (FACTOR * 41) && degrees < (FACTOR * 43)){
            text = "16 красное";
        }
        if(degrees >= (FACTOR * 43) && degrees < (FACTOR * 45)){
            text = "33 черное";
        }
        if(degrees >= (FACTOR * 45) && degrees < (FACTOR * 47)){
            text = "1 красное";
        }
        if(degrees >= (FACTOR * 47) && degrees < (FACTOR * 49)){
            text = "20 черное";
        }
        if(degrees >= (FACTOR * 49) && degrees < (FACTOR * 51)){
            text = "14 красное";
        }
        if(degrees >= (FACTOR * 51) && degrees < (FACTOR * 53)){
            text = "31 черное";
        }
        if(degrees >= (FACTOR * 53) && degrees < (FACTOR * 55)){
            text = "9 красное";
        }
        if(degrees >= (FACTOR * 55) && degrees < (FACTOR * 57)){
            text = "22 черное";
        }
        if(degrees >= (FACTOR * 57) && degrees < (FACTOR * 59)){
            text = "18 красное";
        }
        if(degrees >= (FACTOR * 59) && degrees < (FACTOR * 61)){
            text = "29 черное";
        }
        if(degrees >= (FACTOR * 61) && degrees < (FACTOR * 63)){
            text = "7 красное";
        }
        if(degrees >= (FACTOR * 63) && degrees < (FACTOR * 65)){
            text = "28 черное";
        }
        if(degrees >= (FACTOR * 65) && degrees < (FACTOR * 67)){
            text = "12 красное";
        }
        if(degrees >= (FACTOR * 67) && degrees < (FACTOR * 69)){
            text = "35 черное";
        }
        if(degrees >= (FACTOR * 69) && degrees < (FACTOR * 71)){
            text = "3 красное";
        }
        if(degrees >= (FACTOR * 71) && degrees < (FACTOR * 73)){
            text = "26 черное";
        }
        if ((degrees >= (FACTOR * 73) && degrees < 360 || (degrees >= 0 && degrees < (FACTOR *1)))){
            text = "0 зеленое";
        }
        return text;
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
            setStake.setText(userStake+"");
        }
    }

    public void addMoney(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Пополнение счета!");
        alert.setMessage("Введите сумму до 1000$");
        final EditText input = new EditText(this);
        alert.setView(input);
        alert.setPositiveButton("Пополнить", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String getMoneyUser = input.getText().toString();
                Pattern pattern = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                Matcher matcher = pattern.matcher(getMoneyUser);
                int start = 0;
                int result = 0;
                while (matcher.find(start)) {
                    String value = getMoneyUser.substring(matcher.start(), matcher.end());
                    result = Integer.parseInt(value);
                    start = matcher.end();
                }
                if(result > 1001){
                    Toast.makeText(MainActivity.this, "Пополнять больше 1000$ нельзя!",
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Вы успешно пополнили счет на " + result+"$",
                            Toast.LENGTH_LONG).show();
                    userMoney = userMoney + result;
                    setUserMoney.setText("Счет : "+userMoney+" $");
                }

            }
        });
        alert.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Toast.makeText(MainActivity.this, "Отмена пополнения!",
                        Toast.LENGTH_LONG).show();
            }
        });
        alert.show();
    }

    public void Setting(View view){
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        startActivity(intent);
    }
}
