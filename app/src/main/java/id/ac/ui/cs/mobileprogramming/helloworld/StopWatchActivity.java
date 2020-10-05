package id.ac.ui.cs.mobileprogramming.helloworld;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;
//init week 3
public class StopWatchActivity extends AppCompatActivity {

    Button exitApp, home;
    ImageButton  play, stop;
    boolean nowIsResume;
    int miliSecond,second,minute,hour;
    long timeMiliSecond,timeStart,timeBuffer,timeUpdate = 0L;
    Handler handler;
    Chronometer time;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        time = findViewById(R.id.timeChronometer);
        play = findViewById(R.id.bt_play);
        stop = findViewById(R.id.bt_stop);
        handler = new Handler();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClickPlay(v);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClickStop(v);
            }
        });

        exitApp = (Button) findViewById(R.id.exitAppStopwatch);
        home  = (Button) findViewById(R.id.homeButton);
        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleExitApp(v);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClickHome(v);
            }
        });


    }






    public void handleOnClickPlay (View v){
        if (!nowIsResume){

            timeStart = SystemClock.uptimeMillis();
            handler.postDelayed(runnable,0);
            time.start();
            nowIsResume = true;
            stop.setVisibility(View.GONE);
            play.setImageDrawable(getResources().getDrawable(R.drawable.pause_stopwatch));
        }

        else{

            timeBuffer += timeMiliSecond;
            handler.removeCallbacks(runnable);
            time.stop();
            nowIsResume = false;
            stop.setVisibility(View.VISIBLE);
            play.setImageDrawable(getResources().getDrawable(R.drawable.play_stopwatch));

        }
    }

    public void handleOnClickStop(View v){
        if (!nowIsResume){
            play.setImageDrawable(getResources().getDrawable(R.drawable.play_stopwatch));
            timeMiliSecond = timeStart=timeBuffer=timeUpdate = 0L;
            miliSecond = second = minute = hour = 0;
            time.setText("00:00:00:00");


        }
    }

    public void handleOnClickHome( View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);

    }

    public void handleExitApp (View view){
        finish();
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            timeMiliSecond = SystemClock.uptimeMillis()-timeStart;
            timeUpdate = timeBuffer+timeMiliSecond;
            second = (int) (timeUpdate/1000);
            minute = second/60;
            second = second%60;
            hour = minute/60;
            minute = minute%60;
            miliSecond = (int) (timeUpdate%100);
            String numOfDecimals = "%02d";
            String stringHours = String.format(numOfDecimals,hour);
            String stringMinutes = String.format(numOfDecimals,minute);
            String stringSeconds = String.format(numOfDecimals,second);
            String stringMiliSeconds = String.format(numOfDecimals,miliSecond);
            String stringTime = stringHours+":"+stringMinutes+":"+stringSeconds+":"+stringMiliSeconds;
            time.setText(String.format(stringTime));
            handler.postDelayed(this,60);

        }
    };



}
