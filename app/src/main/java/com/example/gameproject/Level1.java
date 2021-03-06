package com.example.gameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class Level1 extends AppCompatActivity {

    private Dialog dialog;
    private Dialog dialogEnd;

    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    public InterstitialAd interstitialAd; //Реклама
    public int transition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Реклама - начало
        MobileAds.initialize(this, "ca-app-pub-5435877674918779~6012250790");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5435877674918779/9855292885");
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
        //Реклама - конец

        //Закрытие рекламы на крестик - начало
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                try {
                    switch (transition) {
                        case 0: break;
                        case 1: Intent intent1 = new Intent(Level1.this, Level2.class);
                                startActivity(intent1);
                                finish();
                                break;
                        case 2: Intent intent2 = new Intent(Level1.this, GameLevels.class);
                                startActivity(intent2);
                                finish();
                                break;
                        default: break;
                    }
                } catch (Exception e) {}
            }
        });
        //Закрытие рекламы на крестик - конец

        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);

        //Меняем текст уровня - начало
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);
        //Меняем текст уровня - конец

        //код который скругляет углы - начало
        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_left.setClipToOutline(true);
        img_right.setClipToOutline(true);
        //код который скругляет углы - конец

        //Развернуть игру на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Развернуть игру на весь экран - конец

        //Кнопка "Назад" - начало
        Button buttonBack = (Button) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (interstitialAd.isLoaded()) {
                            transition = 2;
                            interstitialAd.show();
                        } else {
                            try {
                                Intent intent = new Intent(Level1.this, GameLevels.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {

                            }
                        }
                    }
                }
        );
        //Кнопка "Назад" - конец

        //Вызов диалогового окна в начале игры - начало
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialog.setCancelable(false); //окно нельзя закрыть системной кнопкой "Назад"

        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose1 = (TextView) dialog.findViewById(R.id.btn_close);
        btnclose1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(Level1.this, GameLevels.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {

                        }
                        dialog.dismiss();
                    }
                }
        );
        //кнопка которая закрывает диалоговое окно - конец

        Button btncontinue1 = (Button) dialog.findViewById(R.id.btn_continue);
        btncontinue1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                }
        );

        dialog.show();
        //Вызов диалогового окна в начале игры - конец

        //Вызов диалогового окна в конце игры - начало
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); //окно нельзя закрыть системной кнопкой "Назад"

        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.btn_close);
        btnclose2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(Level1.this, GameLevels.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {

                        }
                        dialogEnd.dismiss();
                    }
                }
        );
        //кнопка которая закрывает диалоговое окно - конец

        Button btncontinue2 = (Button) dialogEnd.findViewById(R.id.btn_continue);
        btncontinue2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (interstitialAd.isLoaded()) {
                            transition = 1;
                            interstitialAd.show();
                        } else {
                            try {
                                Intent intent = new Intent(Level1.this, Level2.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {

                            }

                            dialogEnd.dismiss();
                        }
                    }
                }
        );
        //Вызов диалогового окна в конце игры - конец

        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20
        };

        //Подключаем анимацию - начало
        final Animation animation = AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);
        //Подключаем анимацию - конец

        //Вставляем рандомные числа - начало
        numLeft = random.nextInt(10);
        img_left.setImageResource(array.images1[numLeft]);
        text_left.setText(array.texts1[numLeft]);

        numRight = random.nextInt(10);
        while (numLeft == numRight) {
            numRight = random.nextInt(10);
        }
        img_right.setImageResource(array.images1[numRight]);
        text_right.setText(array.texts1[numRight]);
        //Вставляем рандомные числа - конец

        //Нажатия на левую картинку - начало
        img_left.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                            img_right.setEnabled(false);

                            if (numLeft > numRight) {
                                img_left.setImageResource(R.drawable.img_true);
                            } else {
                                img_left.setImageResource(R.drawable.img_false);
                            }
                        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                            if (numLeft > numRight) {
                                if (count < 20) {
                                    count++;
                                }

                                for (int a = 0; a < 20; a++) {
                                    TextView tv = findViewById(progress[a]);
                                    tv.setBackgroundResource(R.drawable.style_points);
                                }

                                for (int a = 0; a < count; a++) {
                                    TextView tv = findViewById(progress[a]);
                                    tv.setBackgroundResource(R.drawable.style_points_green);
                                }
                            } else {
                                if (count > 0) {
                                    if (count == 1) {
                                        count = 0;
                                    } else {
                                        count = count - 2;
                                    }
                                }

                                for (int a = 0; a < 19; a++) {
                                    TextView tv = findViewById(progress[a]);
                                    tv.setBackgroundResource(R.drawable.style_points);
                                }

                                for (int a = 0; a < count; a++) {
                                    TextView tv = findViewById(progress[a]);
                                    tv.setBackgroundResource(R.drawable.style_points_green);
                                }
                            }

                            if (count == 20) {
                                //Виход из уровня
                                SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                                final int level = save.getInt("Level", 1);
                                if (level > 1) {

                                } else {
                                    SharedPreferences.Editor editor = save.edit();
                                    editor.putInt("Level", 2);
                                    editor.commit();
                                }
                                dialogEnd.show();
                            } else {
                                //Вставляем рандомные числа - начало
                                numLeft = random.nextInt(10);
                                img_left.setImageResource(array.images1[numLeft]);
                                img_left.startAnimation(animation);
                                text_left.setText(array.texts1[numLeft]);

                                numRight = random.nextInt(10);
                                while (numLeft == numRight) {
                                    numRight = random.nextInt(10);
                                }
                                img_right.setImageResource(array.images1[numRight]);
                                img_right.startAnimation(animation);
                                text_right.setText(array.texts1[numRight]);
                                //Вставляем рандомные числа - конец

                                img_right.setEnabled(true);
                            }
                        }

                        return true;
                    }
                }
        );
        //Нажатия на левую картинку - конец

        //Нажатия на правую картинку - начало
        img_right.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                            img_left.setEnabled(false);

                            if (numLeft < numRight) {
                                img_right.setImageResource(R.drawable.img_true);
                            } else {
                                img_right.setImageResource(R.drawable.img_false);
                            }
                        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                            if (numLeft < numRight) {
                                if (count < 20) {
                                    count++;
                                }

                                for (int a = 0; a < 20; a++) {
                                    TextView tv = findViewById(progress[a]);
                                    tv.setBackgroundResource(R.drawable.style_points);
                                }

                                for (int a = 0; a < count; a++) {
                                    TextView tv = findViewById(progress[a]);
                                    tv.setBackgroundResource(R.drawable.style_points_green);
                                }
                            } else {
                                if (count > 0) {
                                    if (count == 1) {
                                        count = 0;
                                    } else {
                                        count = count - 2;
                                    }
                                }

                                for (int a = 0; a < 19; a++) {
                                    TextView tv = findViewById(progress[a]);
                                    tv.setBackgroundResource(R.drawable.style_points);
                                }

                                for (int a = 0; a < count; a++) {
                                    TextView tv = findViewById(progress[a]);
                                    tv.setBackgroundResource(R.drawable.style_points_green);
                                }
                            }

                            if (count == 20) {
                                //Виход из уровня
                                SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                                final int level = save.getInt("Level", 1);
                                if (level > 1) {

                                } else {
                                    SharedPreferences.Editor editor = save.edit();
                                    editor.putInt("Level", 2);
                                    editor.commit();
                                }
                                dialogEnd.show();
                            } else {
                                //Вставляем рандомные числа - начало
                                numLeft = random.nextInt(10);
                                img_left.setImageResource(array.images1[numLeft]);
                                img_left.startAnimation(animation);
                                text_left.setText(array.texts1[numLeft]);

                                numRight = random.nextInt(10);
                                while (numLeft == numRight) {
                                    numRight = random.nextInt(10);
                                }
                                img_right.setImageResource(array.images1[numRight]);
                                img_right.startAnimation(animation);
                                text_right.setText(array.texts1[numRight]);
                                //Вставляем рандомные числа - конец

                                img_left.setEnabled(true);
                            }
                        }

                        return true;
                    }
                }
        );
        //Нажатия на правую картинку - конец

    }

    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        if (interstitialAd.isLoaded()) {
            transition = 2;
            interstitialAd.show();
        } else {
            try {
                Intent intent = new Intent(Level1.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        }
    }
    //Системная кнопка "Назад" - конец
}