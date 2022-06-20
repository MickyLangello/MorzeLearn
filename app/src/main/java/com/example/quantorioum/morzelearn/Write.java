package com.example.quantorioum.morzelearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Write extends AppCompatActivity {

    private int r;
    private Button nextlvlbtn;
    private TextView exercise, num;
    private EditText anw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        buttonsEngine();
    }

    void buttonsEngine() {
        nextlvlbtn = (Button)findViewById(R.id.nxlvlbtn);
        exercise = (TextView)findViewById(R.id.exerc);
        num = (TextView)findViewById(R.id.numoflvl);
        anw = (EditText)findViewById(R.id.answer1);

        nextlvlbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if ((String.valueOf(anw.getText()).equals(getString(R.string.lvl3_1)))&&(r == 0)) {
                            r = r + 1;
                            num.setText(R.string.lvl2);
                            exercise.setText(R.string.lvl3_2anw);
                            anw.setText(null);
                        }
                        else
                        if ((String.valueOf(anw.getText()).equals(getString(R.string.lvl3_2)))&&(r == 1)) {
                            r = r + 1;
                            num.setText(R.string.lvl3);
                            exercise.setText(R.string.lvl3_3anw);
                            anw.setText(null);
                        }
                        else
                        if ((String.valueOf(anw.getText()).equals(getString(R.string.lvl3_3)))&&(r == 2)) {
                            r = r + 1;
                            AlertDialog.Builder a_builder = new AlertDialog.Builder(Write.this);
                            a_builder.setMessage(R.string.Congrats)
                                    .setCancelable(false)
                                    .setNegativeButton(R.string.comeback, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int i) {
                                            Intent comeback = new Intent(Write.this, LearnActivity.class);
                                            startActivity(comeback);
                                        }
                                    });
                            AlertDialog alert = a_builder.create();
                            alert.show();
                        }
                        else {Toast wrong = Toast.makeText(Write.this, "Неверно", Toast.LENGTH_LONG);
                            wrong.show();}
                    }
                }
        );
    }
}
