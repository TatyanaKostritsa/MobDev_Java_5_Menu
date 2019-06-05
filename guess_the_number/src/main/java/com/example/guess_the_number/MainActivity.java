package com.example.guess_the_number;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Button bNew;
    Random random1 = new Random();
    String str = new String();
    int count;
    int maxim = 100;
    int minim = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        bNew = findViewById(R.id.button2);
        count = random1.nextInt(100 - 0 + 1);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        if (item.getItemId() == R.id.exit) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        if (item.getItemId() == R.id.easy) {
            tvInfo.setText(getString(R.string.soob1));
            minim = 0;
            maxim = 10;
            count = random1.nextInt(10 - 0 + 1);
        }
        if (item.getItemId() == R.id.hard) {
            tvInfo.setText(getString(R.string.soob2));
            minim = 1;
            maxim = 100;
            count = random1.nextInt(100 - 0 + 1);
        }
        if (item.getItemId() == R.id.middle) {
            tvInfo.setText(getString(R.string.soob3));
            minim = 2;
            maxim = 50;
            count = random1.nextInt(50 - 0 + 1);
        }
        if (item.getItemId() == R.id.newgame) {
            tvInfo.setText(getString(R.string.WOW));
            if (minim == 1) {
                count = random1.nextInt(100 - 0 + 1);
            }
            else if (minim==2){
                count = random1.nextInt(50 - 0 + 1);
            }
            else {
                count = random1.nextInt(10 - 0 + 1);
            }
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClick(View view) {

        str = etInput.getText().toString();

        if (str.length() == 0) {
            tvInfo.setText(getString(R.string.ERROR));
        } else {
            int value = Integer.parseInt(etInput.getText().toString());

            if (value < 1 || value > maxim) {
                tvInfo.setText(getString(R.string.ERROR1));
                etInput.setText("");
            } else {
                if (value == count) {
                    tvInfo.setText(getString(R.string.WIN));
                    etInput.setText("");
                }
                if (value < count) {
                    tvInfo.setText(getString(R.string.littleone));
                    etInput.setText("");
                }
                if (value > count) {
                    tvInfo.setText(getString(R.string.bigone));
                    etInput.setText("");
                }
            }

        }
    }
    public void onNewButtonClick(View view) {
        tvInfo.setText(getString(R.string.WOW));
        if (minim == 1) {
            count = random1.nextInt(100 - 0 + 1);
        }
        else if (minim==2){
            count = random1.nextInt(50 - 0 + 1);
        }
        else {
            count = random1.nextInt(10 - 0 + 1);
        }
    }
}
