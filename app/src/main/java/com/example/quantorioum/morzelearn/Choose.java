package com.example.quantorioum.morzelearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Choose extends AppCompatActivity {

    private ImageButton anw1,anw2,anw3,anw4;
    private TextView exerc, numoflvl;
    private int  r = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButtonsEngine2();
    }

    public void ButtonsEngine2() {
        anw1 = (ImageButton)findViewById(R.id.answer1);
        anw2 = (ImageButton)findViewById(R.id.answer2);
        anw3 = (ImageButton)findViewById(R.id.answer3);
        anw4 = (ImageButton)findViewById(R.id.answer4);
        exerc = (TextView)findViewById(R.id.exercise);
        numoflvl = (TextView)findViewById(R.id.numlvl);

//        anw1.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        AlertDialog.Builder wrong = new AlertDialog.Builder(Choose.this);
//                            wrong.setMessage("Неправильно")
//                                    .setCancelable(false)
//                                    .setNegativeButton("Вернуться", new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialogInterface, int i) {
//                                            Intent endof2 = new Intent(Choose.this, MainActivity.class);
//                                            startActivity(endof2);
//
//                                        }});
//                        AlertDialog alert = wrong.create();
//                        alert.show();
//                    }
//                }
//        );

//        anw2.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        AlertDialog.Builder wrong = new AlertDialog.Builder(Choose.this);
//                        wrong.setMessage("Неправильно")
//                                .setCancelable(false)
//                                .setNegativeButton("Вернуться", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int i) {
//                                        Intent endof2 = new Intent(Choose.this, MainActivity.class);
//                                        startActivity(endof2);
//
//                                    }});
//                        AlertDialog alert = wrong.create();
//                        alert.show();
//                    }
//                }
//        );

        anw3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (r == 0) {
                            r = r + 1;
                            anw1.setImageResource(R.drawable.wheel);
                            anw2.setImageResource(R.drawable.sun);
                            anw3.setImageResource(R.drawable.car);
                            anw4.setImageResource(R.drawable.space);
                            exerc.setText(R.string.lvl2_2);
                            numoflvl.setText(R.string.lvl2);
                        }
//                        else { AlertDialog.Builder wrong = new AlertDialog.Builder(Choose.this);
//                        wrong.setMessage("Неправильно")
//                                .setCancelable(false)
//                                .setNegativeButton("Вернуться", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int i) {
//                                        Intent endof2 = new Intent(Choose.this, MainActivity.class);
//                                        startActivity(endof2);
//                                    }
//                                });
//                            AlertDialog alert = wrong.create();
//                            alert.show();}

                        if (r == 2) {
                            r = r + 1;
                            AlertDialog.Builder a_builder = new AlertDialog.Builder(Choose.this);
                            a_builder.setTitle(R.string.Congrats)
                                    .setCancelable(false)
                                    .setNegativeButton(R.string.comeback, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int i) {
                                            dialog.cancel();
                                            Intent endof2 = new Intent(Choose.this, LearnActivity.class);
                                            startActivity(endof2);
                                        }
                                    });
                            AlertDialog alert = a_builder.create();
                            alert.show();

                        }
//                        else { AlertDialog.Builder wrong = new AlertDialog.Builder(Choose.this);
//                            wrong.setMessage("Неправильно")
//                                    .setCancelable(false)
//                                    .setNegativeButton("Вернуться", new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialogInterface, int i) {
//                                            Intent endof2 = new Intent(Choose.this, MainActivity.class);
//                                            startActivity(endof2);
//                                        }
//                                    });
//                            AlertDialog alert = wrong.create();
//                            alert.show();}
                    }
                }
        );

        anw4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (r == 1) {
                            r = r + 1;
                            anw1.setImageResource(R.drawable.fruit);
                            anw2.setImageResource(R.drawable.phone);
                            anw3.setImageResource(R.drawable.energy);
                            anw4.setImageResource(R.drawable.coctail);
                            exerc.setText(R.string.lvl2_3);
                            numoflvl.setText(R.string.lvl3);
                        }
//                        else { AlertDialog.Builder wrong = new AlertDialog.Builder(Choose.this);
//                            wrong.setMessage("Неправильно")
//                                    .setCancelable(false)
//                                    .setNegativeButton("Вернуться", new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialogInterface, int i) {
//                                            Intent endof2 = new Intent(Choose.this, MainActivity.class);
//                                            startActivity(endof2);
//                                        }
//                                    });
//                            AlertDialog alert = wrong.create();
//                            alert.show();}
                    }
                }
        );

    }
}
