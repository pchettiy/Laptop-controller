package freetime.project.tvremote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Control extends AppCompatActivity {

    String TAG="control";
    public String addr;
    ImageButton play_pause;
    Boolean alternate=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        addr=getIntent().getStringExtra("ip");
        play_pause= (ImageButton) findViewById(R.id.imageButton);
    }
    public void space(View V){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"01");
        myClientTask.execute();
        if(alternate){
        play_pause.setImageResource(android.R.drawable.ic_media_play);}
        else{
            play_pause.setImageResource(android.R.drawable.ic_media_pause);
        }
       // Toast.makeText(Control.this, addr, Toast.LENGTH_SHORT).show();
        Log.d(TAG,"pause/play");
        alternate=true;

    }
    public void fast5(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"02");
        myClientTask.execute();
        Log.d(TAG, "fast3");
    }
    public void fastmin(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"03");
        myClientTask.execute();
        Log.d(TAG, "fast 1min");
    }
    public void rewmin(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"04");
        myClientTask.execute();
        Log.d(TAG, "rewind 1min");
    }
    public void rew(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"05");
        myClientTask.execute();
        Log.d(TAG, "rewind 3secs");
    }
    public void volumeplus(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"06");
        myClientTask.execute();
        Log.d(TAG, "volume+");
    }
    public void volumeminus(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"07");
        myClientTask.execute();
        Log.d(TAG, "volume-");
    }
    public void fullscreen(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"08");
        myClientTask.execute();
        Log.d(TAG, "fullscreen");
    }
    public void time(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"09");
        myClientTask.execute();
        Log.d(TAG, "passed time");
    }
}
