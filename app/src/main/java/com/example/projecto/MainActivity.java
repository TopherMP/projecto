package com.example.projecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button entrar;
    ProgressBar pb;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progressBar);
        entrar = findViewById(R.id.btnEntrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);
                Timer timer = new Timer();

                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        counter++;
                        pb.setProgress(counter);

                        if (counter==100){
                            timer.cancel();
                            pb.setVisibility(View.INVISIBLE);

                            Intent entrar = new Intent(MainActivity.this, Menu.class);
                            startActivity(entrar);

                            counter = 0;
                        }
                    }
                };

                timer.schedule(timerTask,50,50);
            }
        });
    }
}