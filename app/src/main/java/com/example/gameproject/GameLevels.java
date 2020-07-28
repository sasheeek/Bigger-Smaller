package com.example.gameproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class GameLevels extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        MobileAds.initialize(this, "ca-app-pub-5435877674918779~6012250790");
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        //Развернуть игру на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Развернуть игру на весь экран - конец

        //Кнопка "Назад" - начало
        Button buttonBack = (Button) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(GameLevels.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка "Назад" - конец

        //Кнопка для перехода на 1 уровень - начало
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 1) {
                                Intent intent = new Intent(GameLevels.this, Level1.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 1 уровень - конец

        //Кнопка для перехода на 2 уровень - начало
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 2) {
                                Intent intent = new Intent(GameLevels.this, Level2.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 2 уровень - конец

        //Кнопка для перехода на 3 уровень - начало
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 3) {
                                Intent intent = new Intent(GameLevels.this, Level3.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 3 уровень - конец

        //Кнопка для перехода на 4 уровень - начало
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 4) {
                                Intent intent = new Intent(GameLevels.this, Level4.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 4 уровень - конец

        //Кнопка для перехода на 5 уровень - начало
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 5) {
                                Intent intent = new Intent(GameLevels.this, Level5.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 5 уровень - конец

        //Кнопка для перехода на 6 уровень - начало
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 6) {
                                Intent intent = new Intent(GameLevels.this, Level6.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 6 уровень - конец

        //Кнопка для перехода на 7 уровень - начало
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 7) {
                                Intent intent = new Intent(GameLevels.this, Level7.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 7 уровень - конец

        //Кнопка для перехода на 8 уровень - начало
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 8) {
                                Intent intent = new Intent(GameLevels.this, Level8.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 8 уровень - конец

        //Кнопка для перехода на 9 уровень - начало
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 9) {
                                Intent intent = new Intent(GameLevels.this, Level9.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 9 уровень - конец

        //Кнопка для перехода на 10 уровень - начало
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        textView10.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 10) {
                                Intent intent = new Intent(GameLevels.this, Level10.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 10 уровень - конец

        //Кнопка для перехода на 11 уровень - начало
        TextView textView11 = (TextView) findViewById(R.id.textView11);
        textView11.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 11) {
                                Intent intent = new Intent(GameLevels.this, Level11.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 11 уровень - конец

        //Кнопка для перехода на 12 уровень - начало
        TextView textView12 = (TextView) findViewById(R.id.textView12);
        textView12.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 12) {
                                Intent intent = new Intent(GameLevels.this, Level12.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 12 уровень - конец

        //Кнопка для перехода на 13 уровень - начало
        TextView textView13 = (TextView) findViewById(R.id.textView13);
        textView13.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 13) {
                                Intent intent = new Intent(GameLevels.this, Level13.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 13 уровень - конец

        //Кнопка для перехода на 14 уровень - начало
        TextView textView14 = (TextView) findViewById(R.id.textView14);
        textView14.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 14) {
                                Intent intent = new Intent(GameLevels.this, Level14.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 14 уровень - конец

        //Кнопка для перехода на 15 уровень - начало
        TextView textView15 = (TextView) findViewById(R.id.textView15);
        textView15.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 15) {
                                Intent intent = new Intent(GameLevels.this, Level15.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 15 уровень - конец

        //Кнопка для перехода на 16 уровень - начало
        TextView textView16 = (TextView) findViewById(R.id.textView16);
        textView16.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 16) {
                                Intent intent = new Intent(GameLevels.this, Level16.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 16 уровень - конец

        //Кнопка для перехода на 17 уровень - начало
        TextView textView17 = (TextView) findViewById(R.id.textView17);
        textView17.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 17) {
                                Intent intent = new Intent(GameLevels.this, Level17.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 17 уровень - конец

        //Кнопка для перехода на 18 уровень - начало
        TextView textView18 = (TextView) findViewById(R.id.textView18);
        textView18.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 18) {
                                Intent intent = new Intent(GameLevels.this, Level18.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 18 уровень - конец

        //Кнопка для перехода на 19 уровень - начало
        TextView textView19 = (TextView) findViewById(R.id.textView19);
        textView19.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 19) {
                                Intent intent = new Intent(GameLevels.this, Level19.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 19 уровень - конец

        //Кнопка для перехода на 20 уровень - начало
        TextView textView20 = (TextView) findViewById(R.id.textView20);
        textView20.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 20) {
                                Intent intent = new Intent(GameLevels.this, Level20.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 20 уровень - конец

        //Кнопка для перехода на 21 уровень - начало
        TextView textView21 = (TextView) findViewById(R.id.textView21);
        textView21.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 21) {
                                Intent intent = new Intent(GameLevels.this, Level21.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 21 уровень - конец

        //Кнопка для перехода на 22 уровень - начало
        TextView textView22 = (TextView) findViewById(R.id.textView22);
        textView22.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 22) {
                                Intent intent = new Intent(GameLevels.this, Level22.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 22 уровень - конец

        //Кнопка для перехода на 23 уровень - начало
        TextView textView23 = (TextView) findViewById(R.id.textView23);
        textView23.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 23) {
                                Intent intent = new Intent(GameLevels.this, Level23.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 23 уровень - конец

        //Кнопка для перехода на 24 уровень - начало
        TextView textView24 = (TextView) findViewById(R.id.textView24);
        textView24.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 24) {
                                Intent intent = new Intent(GameLevels.this, Level24.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 24 уровень - конец

        //Кнопка для перехода на 25 уровень - начало
        TextView textView25 = (TextView) findViewById(R.id.textView25);
        textView25.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 25) {
                                Intent intent = new Intent(GameLevels.this, Level25.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 25 уровень - конец

        //Кнопка для перехода на 26 уровень - начало
        TextView textView26 = (TextView) findViewById(R.id.textView26);
        textView26.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 26) {
                                Intent intent = new Intent(GameLevels.this, Level26.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 26 уровень - конец

        //Кнопка для перехода на 27 уровень - начало
        TextView textView27 = (TextView) findViewById(R.id.textView27);
        textView27.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 27) {
                                Intent intent = new Intent(GameLevels.this, Level27.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 27 уровень - конец

        //Кнопка для перехода на 28 уровень - начало
        TextView textView28 = (TextView) findViewById(R.id.textView28);
        textView28.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 28) {
                                Intent intent = new Intent(GameLevels.this, Level28.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 28 уровень - конец

        //Кнопка для перехода на 29 уровень - начало
        TextView textView29 = (TextView) findViewById(R.id.textView29);
        textView29.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 29) {
                                Intent intent = new Intent(GameLevels.this, Level29.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 29 уровень - конец

        //Кнопка для перехода на 30 уровень - начало
        TextView textView30 = (TextView) findViewById(R.id.textView30);
        textView30.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (level >= 30) {
                                Intent intent = new Intent(GameLevels.this, Level30.class);
                                startActivity(intent);
                                finish();
                            } else {}
                        } catch (Exception e) {

                        }
                    }
                }
        );
        //Кнопка для перехода на 30 уровень - конец

        final int[] x = {
                R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
                R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10,
                R.id.textView11, R.id.textView12, R.id.textView13, R.id.textView14, R.id.textView15,
                R.id.textView16, R.id.textView17, R.id.textView18, R.id.textView19, R.id.textView20,
                R.id.textView21, R.id.textView22, R.id.textView23, R.id.textView24, R.id.textView25,
                R.id.textView26, R.id.textView27, R.id.textView28, R.id.textView29, R.id.textView30
        };

        for (int a = 1; a < level; a++) {
            TextView tv = findViewById(x[a]);
            tv.setText("" + (a + 1));
        }
    }

    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
    //Системная кнопка "Назад" - конец
}