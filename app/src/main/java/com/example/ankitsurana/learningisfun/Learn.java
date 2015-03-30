package com.example.ankitsurana.learningisfun;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Learn extends ActionBarActivity {
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Learn");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b1 = (Button) findViewById(R.id.alphabets);
        b2 = (Button) findViewById(R.id.numbers);
        b3 = (Button) findViewById(R.id.animals);
        b4 = (Button) findViewById(R.id.fruits);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Learn.this, "Learn Alphabets!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Learn.this, alphabet.class));

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Learn.this, "Learn Numbers!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Learn.this, Numbers.class));

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Learn.this, "Learn Animals!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Learn.this, Animals.class));

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Learn.this, "Learn Fruits!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Learn.this, TicTacToe.class));

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn, menu);
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
}
