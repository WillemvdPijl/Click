package com.appje.willem.click;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

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
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9625527540511485~8681038055");

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

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_ads, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
