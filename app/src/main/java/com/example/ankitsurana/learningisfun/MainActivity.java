package com.example.ankitsurana.learningisfun;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends ActionBarActivity implements TextToSpeech.OnInitListener {
    //EditText editText;
    TextToSpeech mtslearn,mtsabout;
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // editText = (EditText) findViewById(R.id.elearn);
        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Learning Is Fun");
        b1 = (Button) findViewById(R.id.learn);
        b2 = (Button) findViewById(R.id.about);
        b3 = (Button) findViewById(R.id.exit);
        mtslearn = new TextToSpeech(this, this);
        mtsabout= new TextToSpeech(this,this);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Exit!!", Toast.LENGTH_LONG).show();
                //startActivity(new Intent(MainActivity.this, Learn.class));
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);

                dlgAlert.setMessage("Do you really want to exit");
                dlgAlert.setTitle("Exit");

                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                System.exit(0);
                            }
                        });
                dlgAlert.create().show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Know About App!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, About.class));
                convertTextToSpeech1();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Keep Learning!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, Learn.class));
                convertTextToSpeech();
            }
        });
       // convertTextToSpeech();

    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = mtslearn.setLanguage(Locale.ENGLISH);
            //convertTextToSpeech();
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("error", "This Language is not supported");
            } else {
                mtslearn.speak("Welcome To Learning is Fun", TextToSpeech.QUEUE_FLUSH, null, null);

            }
        } else {
            Log.e("error", "Initilization Failed!");
        }

    }



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void convertTextToSpeech() {
        //String Speak = editText.getText().toString();
        //if (null == Speak || "".equals(Speak)) {
        //    Speak = "Please give some input.";
        //}
        mtslearn.speak("Learn", TextToSpeech.QUEUE_FLUSH, null,null);
         }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void convertTextToSpeech1(){
        mtsabout.speak("About",TextToSpeech.QUEUE_FLUSH,null,null);
    }
}



