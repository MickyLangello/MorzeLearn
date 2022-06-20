package com.example.quantorioum.morzelearn;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearnActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        addListenerOnButton();
    }
    public void addListenerOnButton() {
        btn1 = (Button)findViewById(R.id.TranslateGamemodeButton);
        btn2 = (Button)findViewById(R.id.ChooseRightPictureGamemodeButton);
        btn3 = (Button)findViewById(R.id.WriteGamemodeButton);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Gamemode1 = new Intent(LearnActivity.this, Translate.class);
                        startActivity(Gamemode1);
                    }
                }
        );

        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Gamemode2 = new Intent(LearnActivity.this, Choose.class);
                        startActivity(Gamemode2);
                    }
                }
        );

        btn3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent  Gamemode3 = new Intent(LearnActivity.this, Write.class);
                        startActivity(Gamemode3);
                    }
                }
        );

    }
}
