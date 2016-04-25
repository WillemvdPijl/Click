package com.example.willem.click;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnTok;
    Button btnReset;

    TextView txtTok;

    SoundPool mySound;
    int soundId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTok = (Button)findViewById(R.id.buttontok);
        btnReset = (Button)findViewById(R.id.buttonreset);

        txtTok = (TextView)findViewById(R.id.textViewCount);

        mySound = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundId = mySound.load(this, R.raw.toksound, 1);
        //final MediaPlayer TokSound = MediaPlayer.create(this, R.raw.toksound);
        final MediaPlayer Kukalaku = MediaPlayer.create(this, R.raw.kukalaku);


        btnTok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countValue= txtTok.getText().toString();

                int intCountValue = Integer.parseInt(countValue);
                intCountValue++;

                txtTok.setText( String.valueOf(intCountValue));
                mySound.play(1, 1, 1, 1, 0, 1);
                //TokSound.stop();
                //TokSound.start();
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txtTok.setText(String.valueOf(0));
                Kukalaku.start();
            }

        });

    }
}
