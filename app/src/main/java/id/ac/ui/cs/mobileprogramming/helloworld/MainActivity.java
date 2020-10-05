package id.ac.ui.cs.mobileprogramming.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int numberOfClicks = 0;
    public TextView text;
    public Button button, stopwatchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        stopwatchButton = (Button) findViewById(R.id.stopwatchButton);
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

    public void handleOnClickStopwatch (View view) {
        Intent intent = new Intent(this, StopWatchActivity.class);
        this.startActivity(intent);

    }
}