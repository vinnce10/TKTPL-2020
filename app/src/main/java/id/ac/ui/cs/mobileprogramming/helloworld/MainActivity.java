package id.ac.ui.cs.mobileprogramming.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public int numberOfClicks = 0;
    public TextView text;
    public Button button, stopwatchButton, exitApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        stopwatchButton = (Button) findViewById(R.id.stopwatchButton);
        exitApp = (Button) findViewById(R.id.exitAppHome);
        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleExitApp(v);

            }
        });
        stopwatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClickStopwatch(v);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClick(v);
                text = findViewById(R.id.numOfClicks);
                text.setText("Number Of Clicks: "+Integer.toString(numberOfClicks));
            }
        });
    }

    public void handleOnClick (View view){
        numberOfClicks++;
    }

    public void handleExitApp (View view) { finish(); }

    public void handleOnClickStopwatch (View view) {
        Intent intent = new Intent(this, StopWatchActivity.class);
        this.startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setMessage("Please press the Exit App button to exit the App")
                .setNeutralButton("OK",null).show();
//                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                })
//                .setNegativeButton("NO",null).show();
        }
    }
