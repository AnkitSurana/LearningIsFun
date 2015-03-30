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
import android.view.View.OnClickListener;

import java.util.Locale;


public class alphabet extends ActionBarActivity implements OnClickListener, TextToSpeech.OnInitListener {

    TextToSpeech mtslearn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Alphabets");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mtslearn = new TextToSpeech(this, this);
        int idList[] = {R.id.a, R.id.b, R.id.c, R.id.d, R.id.e,
                R.id.f, R.id.g, R.id.h,
                R.id.i, R.id.j, R.id.k,
                R.id.l, R.id.m, R.id.n, R.id.o,
                R.id.p, R.id.q, R.id.r, R.id.s, R.id.t, R.id.u, R.id.v, R.id.w, R.id.x, R.id.y, R.id.z};

        for (int id : idList) {
            View v = findViewById(id);
            v.setOnClickListener(this);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alphabet, menu);
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
            case R.id.a:
                mtslearn.speak("A", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.b:
                mtslearn.speak("B", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.c:
                mtslearn.speak("C", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.d:
                mtslearn.speak("D", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.e:
                mtslearn.speak("E", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.f:
                mtslearn.speak("F", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.g:
                mtslearn.speak("G", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.h:
                mtslearn.speak("H", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.i:
                mtslearn.speak("I", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.j:
                mtslearn.speak("J", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.k:
                mtslearn.speak("K", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.l:
                mtslearn.speak("L", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.m:
                mtslearn.speak("M", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.n:
                mtslearn.speak("N", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.o:
                mtslearn.speak("O", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.p:
                mtslearn.speak("P", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.q:
                mtslearn.speak("Q", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.r:
                mtslearn.speak("R", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.s:
                mtslearn.speak("S", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.t:
                mtslearn.speak("T", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.u:
                mtslearn.speak("U", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.v:
                mtslearn.speak("V", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.w:
                mtslearn.speak("W", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.x:
                mtslearn.speak("X", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.y:
                mtslearn.speak("Y", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.z:
                mtslearn.speak("Z", TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            default:
                break;

        }
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
                convertTtS();

            }
        } else {
            Log.e("error", "Initilization Failed!");
        }

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void convertTtS() {
        mtslearn.speak("Welcome To Alphabets", TextToSpeech.QUEUE_FLUSH, null, null);
    }
}