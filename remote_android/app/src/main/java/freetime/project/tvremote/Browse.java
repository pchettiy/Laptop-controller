package freetime.project.tvremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Browse extends AppCompatActivity {

    String addr;
    String TAG="browse";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        addr=getIntent().getStringExtra("ip");
    }
    public void up(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"10");
        myClientTask.execute();
        Log.d(TAG, "up");
    }
    public void down(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"11");
        myClientTask.execute();
        Log.d(TAG, "down");
    }
    public void left(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"12");
        myClientTask.execute();
        Log.d(TAG, "left");
    }
    public void right(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"13");
        myClientTask.execute();
        Log.d(TAG, "right");
    }
    public void enter(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"14");
        myClientTask.execute();
        Log.d(TAG, "enter");
    }
    public void exit(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"15");
        myClientTask.execute();
        Log.d(TAG, "exit");
    }
    public void vlc(View V){
        Intent intent=new Intent(this,Control.class);
        intent.putExtra("ip", addr);
        startActivity(intent);
    }
    public void back(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"16");
        myClientTask.execute();
        Log.d(TAG, "exit");
    }
    public void altright(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"17");
        myClientTask.execute();
        Log.d(TAG, "alt left");
    }
    public void altleft(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"18");
        myClientTask.execute();
        Log.d(TAG, "alt left");
    }
    public void ok(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"19");
        myClientTask.execute();
        Log.d(TAG, "ok");
    }
}


