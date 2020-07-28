package com.example.gameproject;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level17 extends AppCompatActivity {

    private Dialog dialog;
    private Dialog dialogEnd;

    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);
        text_left.setText("");
        text_right.setText("");

        //Меняем текст уровня - начало
        TextView text_levels = findViewById(R.id.text_levels);
        //-----------------------------------------------------------------------------------------------------------------------------
        text_levels.setText(R.string.level17);
        //-----------------------------------------------------------------------------------------------------------------------------
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
                        try {
                            Intent intent = new Intent(Level17.this, GameLevels.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка "Назад" - конец

        //Устанавливаем фон - начало
        ImageView background = (ImageView) findViewById(R.id.background);
        background.setImageResource(R.drawable.background_level17);
        //Устанавливаем фон - конец

        //Вызов диалогового окна в начале игры - начало
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialog.setCancelable(false); //окно нельзя закрыть системной кнопкой "Назад"

        //Устанавливаем картинку в диалоговое окно - начало
        ImageView previewimg = (ImageView) dialog.findViewById(R.id.previewimg);
        //-----------------------------------------------------------------------------------------------------------------------------
        previewimg.setImageResource(R.drawable.menu_game_icon);
        //-----------------------------------------------------------------------------------------------------------------------------
        //Устанавливаем картинку в диалоговое окно - конец

        //Устанавливаем фон диалогового окна в начале - начало
        LinearLayout dialogfon1 = (LinearLayout) dialog.findViewById(R.id.dialogfon);
        dialogfon1.setBackgroundResource(R.drawable.background_level16);
        //Устанавливаем фон диалогового окна в начале - конец

        //Устанавливаем текст в диалоговое окно - начало
        TextView textdescription = (TextView) dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.levelseventeen);
        //Устанавливаем текст в диалоговое окно - конец

        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose = (TextView) dialog.findViewById(R.id.btn_close);
        btnclose.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(Level17.this, GameLevels.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {

                        }
                        dialog.dismiss();
                    }
                }
        );
        //кнопка которая закрывает диалоговое окно - конец

        //кнопка "Продолжить" - начало
        Button btncontinue = (Button) dialog.findViewById(R.id.btn_continue);
        btncontinue.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                }
        );
        //кнопка "Продолжить" - конец

        dialog.show();
        //Вызов диалогового окна в начале игры - конец

        //Вызов диалогового окна в конце игры - начало
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); //окно нельзя закрыть системной кнопкой "Назад"

        //Устанавливаем фон диалогового окна в конце - начало
        LinearLayout dialogfon2 = (LinearLayout) dialogEnd.findViewById(R.id.dialogfon);
        dialogfon2.setBackgroundResource(R.drawable.background_level18);
        //Устанавливаем фон диалогового окна в конце - конец

        //Интерестный факт - начало
        TextView textdescriptionend = (TextView) dialogEnd.findViewById(R.id.textdescriptionend);
        textdescriptionend.setText(R.string.levelseventeenend);
        //Интерестный факт - конец

        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.btn_close);
        btnclose2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(Level17.this, GameLevels.class);
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
                        try {
                            Intent intent = new Intent(Level17.this, Level18.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {

                        }

                        dialogEnd.dismiss();
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
        final Animation animation = AnimationUtils.loadAnimation(Level17.this, R.anim.alpha);
        //Подключаем анимацию - конец

        //Вставляем рандомные числа - начало
        numLeft = random.nextInt(22);
        img_left.setImageResource(array.images17[numLeft]);

        numRight = random.nextInt(22);
        while (numLeft == numRight) {
            numRight = random.nextInt(22);
        }
        img_right.setImageResource(array.images17[numRight]);
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
                                if (level > 17) {

                                } else {
                                    SharedPreferences.Editor editor = save.edit();
                                    editor.putInt("Level", 18);
                                    editor.commit();
                                }
                                dialogEnd.show();
                            } else {
                                //Вставляем рандомные числа - начало
                                numLeft = random.nextInt(22);
                                img_left.setImageResource(array.images17[numLeft]);
                                img_left.startAnimation(animation);

                                numRight = random.nextInt(22);
                                while (numLeft == numRight) {
                                    numRight = random.nextInt(22);
                                }
                                img_right.setImageResource(array.images17[numRight]);
                                img_right.startAnimation(animation);
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
                                if (level > 17) {

                                } else {
                                    SharedPreferences.Editor editor = save.edit();
                                    editor.putInt("Level", 18);
                                    editor.commit();
                                }
                                dialogEnd.show();
                            } else {
                                //Вставляем рандомные числа - начало
                                numLeft = random.nextInt(22);
                                img_left.setImageResource(array.images17[numLeft]);
                                img_left.startAnimation(animation);

                                numRight = random.nextInt(22);
                                while (numLeft == numRight) {
                                    numRight = random.nextInt(22);
                                }
                                img_right.setImageResource(array.images17[numRight]);
                                img_right.startAnimation(animation);
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
        try {
            Intent intent = new Intent(Level17.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
    //Системная кнопка "Назад" - конец
}