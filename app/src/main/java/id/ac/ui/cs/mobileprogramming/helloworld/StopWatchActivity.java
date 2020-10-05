package id.ac.ui.cs.mobileprogramming.helloworld;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//init week 3
public class StopWatchActivity extends AppCompatActivity {

    public Button exitApp, home;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        exitApp = (Button) findViewById(R.id.exitApp);
        home  = (Button) findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClickHome(v);
            }
        });


    }

    public void handleOnClickHome( View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);

    }



}
