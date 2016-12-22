package com.appje.willem.click;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {


    Button btnTok;
    Button btnReset;

    TextView txtTok;

    SoundPool mySound;
    SoundPool mySound2;

    int soundId;

    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";

    public void Tok(){
        String countValue= txtTok.getText().toString();

        int intCountValue = Integer.parseInt(countValue);
        intCountValue++;

        txtTok.setText( String.valueOf(intCountValue));
        mySound.play(1, 1, 1, 1, 0, 1);
    }

    public void WegTok(){
        txtTok.setText(String.valueOf(0));
        mySound2.play(1, 1, 1, 1, 0, 1);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTok = (Button)findViewById(R.id.buttontok);
        btnReset = (Button)findViewById(R.id.buttonreset);

        txtTok = (TextView)findViewById(R.id.textViewCount);

        mySound = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        mySound2 = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundId = mySound.load(this, R.raw.toksound, 1);
        soundId = mySound2.load(this, R.raw.kukalaku, 1);
        //final MediaPlayer TokSound = MediaPlayer.create(this, R.raw.toksound);



        //final MediaPlayer Kukalaku = MediaPlayer.create(this, R.raw.kukalaku);



        btnTok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tok();
                //TokSound.stop();
                //TokSound.start();
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                WegTok();
            }

        });

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
        Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();

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

