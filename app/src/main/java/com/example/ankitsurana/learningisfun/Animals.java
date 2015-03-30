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


public class Animals extends ActionBarActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    TextToSpeech mtslearn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Animals");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mtslearn = new TextToSpeech(this, this);

        int idList[] = {R.id.cat, R.id.dog, R.id.cow, R.id.goat, R.id.rabbit,
                R.id.horse, R.id.donkey, R.id.hen,
                R.id.duck, R.id.monkey};

        for (int id : idList) {
            View v = findViewById(id);
            v.setOnClickListener(this);

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animals, menu);
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


    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = mtslearn.setLanguage(Locale.ENGLISH);
            //convertTextToSpeech();
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("error", "This Language is not supported");
            } else {
                convertTextToSpeechi();

            }
        } else {
            Log.e("error", "Initilization Failed!");
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void convertTextToSpeechi() {
        mtslearn.speak("Welcome To Animal World!!", TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cat:
                mtslearn.speak("Cat", TextToSpeech.QUEUE_FLUSH, null,null);
                break;
            case R.id.dog:
                mtslearn.speak("Dog", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.cow:
                mtslearn.speak("Cow", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.goat:
                mtslearn.speak("Goat", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.rabbit:
                mtslearn.speak("Rabbit", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.horse:
                mtslearn.speak("Horse", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.donkey:
                mtslearn.speak("Donkey", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.hen:
                mtslearn.speak("Hen", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.duck:
                mtslearn.speak("Duck", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.monkey:
                mtslearn.speak("Monkey", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            default:
                break;
        }
    }

}
