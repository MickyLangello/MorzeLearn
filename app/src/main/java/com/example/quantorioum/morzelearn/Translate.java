package com.example.quantorioum.morzelearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Translate extends AppCompatActivity {

    private int r = 0;
    private Button dot, tire, spacebar, nextlvl;
    private TextView num;
    private EditText anw;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        ButtonsEngine();
    }

    public void ButtonsEngine() {
        dot = (Button)findViewById(R.id.dotbutton);
        tire = (Button)findViewById(R.id.tirebutton);
        spacebar = (Button)findViewById(R.id.spacebarbutton);
        nextlvl = (Button)findViewById(R.id.nextlvlbutton);
        anw = (EditText) findViewById(R.id.answer1);
        img = (ImageView)findViewById(R.id.imagelvl);
        num = (TextView)findViewById(R.id.numoflvl);

        dot.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        anw.append("•");
                    }
                }
        );

        tire.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        anw.append("−");
                    }
                }
        );

        spacebar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        anw.append(" ");
                    }
                }
        );

        nextlvl.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (String.valueOf(anw.getText()).equals(getString(R.string.Answer1_1)) && (r == 0)) {
                            r = r + 1;
                            img.setImageResource(R.drawable.water);
                            num.setText(R.string.lvl2);
                            anw.setText(null);
                        }
                        else
                        if (String.valueOf(anw.getText()).equals(getString(R.string.Answer1_2)) && (r == 1)) {
                            r = r + 1;
                            img.setImageResource(R.drawable.ship);
                            num.setText(R.string.lvl3);
                            anw.setText(null);
                        }
                        else
                        if (String.valueOf(anw.getText()).equals(getString(R.string.Answer1_3)) && (r == 2)) {
                            r = r + 1;
                            anw.setText(null);
                        }
                        else {
                            Toast wrong2 = Toast.makeText(Translate.this, "Неверно", Toast.LENGTH_LONG);
                            wrong2.show();}
                        if (r == 3) {
                            AlertDialog.Builder a_builder = new AlertDialog.Builder(Translate.this);
                            a_builder.setMessage(R.string.Congrats)
                                    .setCancelable(false)
                                    .setNegativeButton(R.string.comeback, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int i) {
                                            Intent endof1 = new Intent(Translate.this, LearnActivity.class);
                                            startActivity(endof1);
                                        }
                                    });
                            AlertDialog alert = a_builder.create();
                            alert.show();
                        }

                    }
                }
        );


    } }
