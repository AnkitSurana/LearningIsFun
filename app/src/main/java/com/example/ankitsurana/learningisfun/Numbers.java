package com.example.ankitsurana.learningisfun;

import android.annotation.TargetApi;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Locale;


public class Numbers extends ActionBarActivity implements View.OnClickListener, TextToSpeech.OnInitListener{

    TextToSpeech mtsnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Numbers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mtsnum = new TextToSpeech(this, this);
        int idList[] = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
                R.id.button6, R.id.button7, R.id.button8,R.id.button9,R.id.button10};

        for (int id : idList) {
            View v = findViewById(id);
            v.setOnClickListener(this);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_numbers, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button1:
                mtsnum.speak("One", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.button2:
                mtsnum.speak("Two", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.button3:
                mtsnum.speak("Three", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.button4:
                mtsnum.speak("Four", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.button5:
                mtsnum.speak("Five", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.button6:
                mtsnum.speak("Six", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.button7:
                mtsnum.speak("Seven", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.button8:
                mtsnum.speak("Eight", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.button9:
                mtsnum.speak("Nine", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.button10:
                mtsnum.speak("Zero", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            default:
                break;
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = mtsnum.setLanguage(Locale.US);
            //convertTextToSpeech();
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("error", "This Language is not supported");
            } else {
                convertTextToSpeechn();

            }
        } else {
            Log.e("error", "Initilization Failed!");
        }

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void convertTextToSpeechn() {
        mtsnum.speak("Welcome To Numbers", TextToSpeech.QUEUE_FLUSH, null, null);
    }
}
