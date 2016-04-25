package com.example.willem.click;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnTok;
    Button btnReset;

    TextView txtTok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTok = (Button)findViewById(R.id.buttontok);
        btnReset = (Button)findViewById(R.id.buttonreset);

        txtTok = (TextView)findViewById(R.id.textViewCount);

        final MediaPlayer TokSound = MediaPlayer.create(this, R.raw.Tok_Sound);


        btnTok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countValue= txtTok.getText().toString();

                int intCountValue = Integer.parseInt(countValue);
                intCountValue++;

                txtTok.setText( String.valueOf(intCountValue));
                TokSound.start();
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txtTok.setText(String.valueOf(0));
            }

        });

    }
}
