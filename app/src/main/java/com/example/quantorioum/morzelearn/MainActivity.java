package com.example.quantorioum.morzelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button play, learn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton ();
    }

    public void addListenerOnButton() {
        play =  findViewById (R.id.PlayBtn);
        learn =  findViewById (R.id.learnBtn);

        play.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent playIntent = new Intent("com.example.quantorioum.morzelearn.GameActivity");
                        startActivity(playIntent);

                    }
                }
        );
        learn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent learnIntent = new Intent("com.example.quantorioum.morzelearn.LearnActivity");
                        startActivity(learnIntent);

                    }
                }
        );

    }
}
