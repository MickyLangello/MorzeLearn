package com.example.quantorioum.morzelearn;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.support.v7.app.AlertDialog;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import java.io.IOException;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private Camera camera;
    Parameters parameters;
    private Button flash;

    private  Button copyT;
    private EditText textIn;
    private Button Delete;
    private Button transBtn;
    private TextView textM;
    private char[] russ = new char[] {' ','а','б','в','г','д','е','ж','з','и','й','к','л',
            'м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ь','ы','ъ','э','ю','я','1',
            '2','3','4','5','6','7','8','9','0','.',',',':','?','!','-','(',')'};


    private String [] morze = new String[]{"  ","•-","-•••","•--","--•","-••","•","•••-","--••","••",
            "•---","-•-","•-••","--","-•","---", "•--•","•-•","•••","-","••-","••-•","••••","-•-•", "---•",
            "----","--•-","-••-", "-•--","-••-","••-••","••--","•-•-","•----","••---", "•••--","••••-","•••••",
            "-••••","--•••","---••","----•","-----","••••••","•-•-•-", "---•••","••--••", "--••--","-••••-",
            "-•--•-","-•--•-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        flash =(Button) findViewById(R.id.btn_switch);
        copyT = (Button) findViewById(R.id.copy);
        Delete = (Button) findViewById(R.id.clean);
        textM = (TextView) findViewById(R.id.kodeTxt);
        textIn = (EditText) findViewById(R.id.inTxt);
        transBtn = (Button) findViewById(R.id.translateBtn);

        addListenerOnButton();
    }
        private void showCameraAlert() {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.error_title)
                    .setMessage(R.string.error_text)
                    .setPositiveButton(R.string.exit_message, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }


    private void setFlashLigthOn() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (camera != null) {

                    camera = Camera.open();
                    parameters = camera.getParameters();
                    if (parameters != null) {
                        List supportedFlashModes = parameters.getSupportedFlashModes();
                        if (supportedFlashModes.contains(Parameters.FLASH_MODE_TORCH)) {
                            parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                        } else if (supportedFlashModes.contains(Parameters.FLASH_MODE_ON)) {
                            parameters.setFlashMode(Parameters.FLASH_MODE_ON);
                        } else camera = null;

                        if (camera != null) {
                            camera.setParameters(parameters);
                            camera.startPreview();
                            try {       //для работы на nexus5
                                camera.setPreviewTexture(new SurfaceTexture(0));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }
    private void setFlashLightOff() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (camera != null) {
                    parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                    camera.stopPreview();
                }
            }
        }).start();
    }

    public void addListenerOnButton () {
        transBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View a) {
                        int k, i;
                        String strTxt = textIn.getText().toString();
                        char[] txtToArr = strTxt.toCharArray();     //thxToArr массив введённого текста
                        for (k = 0; k < txtToArr.length; k++) {     // массив типа данных charsequence
                            for (i = 0; i < russ.length; i++) {
                                if (txtToArr[k] == russ[i]) {
                                    textM.append(morze[i]+" ");
                                }
                            }
                        }
                    }
                }
        );

        Delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View b) {
                        textIn.setText(null);
                        textM.setText(null);
                    }
                }
        );

        copyT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(textM.getText().toString() != "" ){
                            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                            ClipData clip = ClipData.newPlainText("", textM.getText().toString());
                            clipboard.setPrimaryClip(clip);
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Скопирвано в буфер обмена.", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else{
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Пустое поле вывода.", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    }
                }
        );
        flash.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View c) {
                        boolean isCameraFlash = getApplicationContext().getPackageManager()
                                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

                        if (!isCameraFlash) {
                            showCameraAlert();
                        } else {
//                            int k, i;
//                            String strTxt = textIn.getText().toString();
//                            char[] txtToArr = strTxt.toCharArray();
//                            for (k = 0; k < txtToArr.length; k++) {
//                                for (i = 0; i < russ.length; i++) {
//                                    if (txtToArr[k] == russ[i]) {
//                                        textM.append(morze[i]);
//                                    }
//                                }
//                            }
                            int n;
                            String strMorze = textM.getText().toString();
                            char[] morzeToArr = strMorze.toCharArray();
                            for (n = 0; n < morzeToArr.length; n++) {
                                switch (morzeToArr[n]) {
                                    case ' ':
                                        try {
                                            Thread.sleep(600);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    case '•':
                                        setFlashLigthOn();
                                        try {
                                            Thread.sleep(150);
                                            break;
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        setFlashLightOff();
                                        break;
                                    case '-':
                                        setFlashLigthOn();
                                        try {
                                            Thread.sleep(500);
                                            break;
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        setFlashLightOff();
                                }
                            }
//                            if (camera != null) {
//                                camera.release(); //вылетает
//                                camera = null;
//                            }
                        }
                    }
                }
        );

    }
    }