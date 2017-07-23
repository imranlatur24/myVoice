package com.androiddeveloper.imran.voiceapp;


import java.util.ArrayList;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.speech.RecognizerIntent;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends Activity implements OnClickListener {

    public ListView mList;
    public Button speakButton;

    public static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speakButton = (Button) findViewById(R.id.btn_speak);
        speakButton.setOnClickListener(this);

        voiceinputbuttons();
    }

    public void informationMenu() {
        startActivity(new Intent("android.intent.action.INFOSCREEN"));
    }

    public void voiceinputbuttons() {
        speakButton = (Button) findViewById(R.id.btn_speak);
        mList = (ListView) findViewById(R.id.list);
    }

    public void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Speech recognition demo");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        startVoiceRecognitionActivity();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
            ArrayList matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            mList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, matches));


            if (matches.contains("information")) {
                informationMenu();
            }
            if (matches.contains("silent mode")) {
                silent();
            }
            if (matches.contains("vibrate mode")) {
                vibrate();
            }
            if (matches.contains("ring mode")) {
                ringing();
            }
            if(matches.contains("take screenshots")){

            }
            if (matches.contains("landscape")) {
                landscape();
            }
            if (matches.contains("portrait")) {
                portrait();
            }

            if (matches.contains("file manager")) {
                filemanager();
            }

            if (matches.contains("Email")) {
                smsemail();
            }
            if (matches.contains("SMS")) {
                sendsms();
            }
            if (matches.contains("open whatsapp")) {
                whatsapp();
            }
            if (matches.contains("calculator")) {
                cal();
            }
            if (matches.contains("camera")) {
                came();
            }
            if (matches.contains("chrome")) {
                chr();
            }
            if (matches.contains("clock")) {
                clc();
            }
            if (matches.contains("contacts")) {
                cts();
            }
            if(matches.contains("drive")){
                drv();
            }
            if(matches.contains("gallary")){
                gal();
            }
            if(matches.contains("animation")){
                gif();
            }
            if(matches.contains("Gmail")){
                gma();
            }
            if(matches.contains("Play Store")){
                ps();
            }
            if(matches.contains("hardware")){
                hd();
            }
            if(matches.contains("Internet")){
                inte();
            }
            if(matches.contains("IRCTC")){
                tr();
            }
            if(matches.contains("maps")){
                map();
            }
            if(matches.contains("messages")){
                mes();
            }
            if(matches.contains("files")){
                files();
            }
            if(matches.contains("radio")){
                rad();
            }

            if(matches.contains("videos")){
                video();
            }
            if(matches.contains("You Tube")){
                you();
            }
            if(matches.contains("memo")){
                mem();
            }
            if(matches.contains("paytm")){
                pay();
            }
            if(matches.contains("play music")){
                musicplay();
            }

        }
    }

    private void mem() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.samsung.android.app.memo");
        startActivity(mIntent);
    }

    private void you() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
        startActivity(mIntent);
    }
    private void videos() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.samsung.android.video");
        startActivity(mIntent);
    }

    private void rad() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.fm");
        startActivity(mIntent);
    }

    private void pay() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
        startActivity(mIntent);
    }
    private void files() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.myfiles");
        startActivity(mIntent);
    }

    private void mes() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.android.mms");
        startActivity(mIntent);
    }

    private void map() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
        startActivity(mIntent);
    }

    private void tr() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("cris.org.in.prs.ima");
        startActivity(mIntent);
    }

    private void inte() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.sbrowser");
        startActivity(mIntent);
    }

    private void hd() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.dama.hardwareinfo");
        startActivity(mIntent);
    }

    private void ps() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
        startActivity(mIntent);
    }

    private void gma() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
        startActivity(mIntent);
    }

    private void gif() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.imran.mycloud.gifani");
        startActivity(mIntent);
    }

    private void gal() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.gallery3d");
        startActivity(mIntent);
    }

    private void drv() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.docs");
        startActivity(mIntent);
    }

    private void cts() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.android.contacts");
        startActivity(mIntent);
    }

    private void clc() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.clockpackage");
        startActivity(mIntent);
    }

    private void chr() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
        startActivity(mIntent);
    }

    private void came() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.camera");
        startActivity(mIntent);
    }
    private void cal() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.popupcalculator");
        startActivity(mIntent);
    }

    private void whatsapp() {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        startActivity(mIntent);
    }

    private void sendsms() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.imran.mycloud.sendsms");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }
    }

    private void smsemail() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.imran.mycloud.emailsend");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }
    }

    private void filemanager() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.imran.mycloud.filemanager");
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
    }

    private void video() {
        setContentView(R.layout.music);
        VideoView view = (VideoView) findViewById(R.id.video);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.aw;
        view.setVideoURI(Uri.parse(path));
        view.start();
    }

    private void musicplay() {
        MediaPlayer mPlay = MediaPlayer.create(MainActivity.this, R.raw.tu_dua);
        mPlay.start();
    }

    private void portrait() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toast.makeText(getApplicationContext(), "PORTRAIT", Toast.LENGTH_LONG).show();
    }

    private void landscape() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Toast.makeText(getApplicationContext(), "LANDSCAPE", Toast.LENGTH_LONG).show();
    }
    private void ringing() {
        final AudioManager am = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        Toast.makeText(getApplicationContext(), "Mode:Normal Mode Activited..!", Toast.LENGTH_SHORT).show();
    }

    private void vibrate() {
        final AudioManager am = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        Toast.makeText(getApplicationContext(), "Mode:Vibrate Mode Activited..!", Toast.LENGTH_SHORT).show();
    }

    private void silent() {
        final AudioManager am = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        Toast.makeText(getApplicationContext(), "Mode:Silent Mode Activited..!", Toast.LENGTH_SHORT).show();
    }
}