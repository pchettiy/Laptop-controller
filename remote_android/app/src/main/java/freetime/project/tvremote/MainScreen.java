package freetime.project.tvremote;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import freetime.project.tvremote.slidingtabpackage.SlidingTabLayout;

public class MainScreen extends AppCompatActivity {

    String addr,TAGB="browse",TAGV="vlc",TAGO="office";
    ViewPager pager;
    SlidingTabLayout mtabs;
    Boolean alternate=false;
    ImageButton play_pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        pager= (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mtabs= (SlidingTabLayout) findViewById(R.id.tabs);
        mtabs.setDistributeEvenly(true);
        mtabs.setViewPager(pager);
        play_pause= (ImageButton) findViewById(R.id.imageButton);
        addr=getIntent().getStringExtra("ip");
    }
    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] titles={"Browse","VLC","Office"};
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
//            TestFragment testFragment=TestFragment.newInstance(position);
            if(position==0){
                fragment=new Frag_Browse();
            }
            else if(position==1){
                Frag_VLC frag_vlc=Frag_VLC.newInstance(addr,"");
                return frag_vlc;
            }
            else
            {
                fragment=new Frag_Office();
            }
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return titles[position];
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
    public void up(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"10");
        myClientTask.execute();
        Log.d(TAGB, "up");
    }
    public void down(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"11");
        myClientTask.execute();
        Log.d(TAGB, "down");
    }
    public void left(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"12");
        myClientTask.execute();
        Log.d(TAGB, "left");
    }
    public void right(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"13");
        myClientTask.execute();
        Log.d(TAGB, "right");
    }
    public void enter(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"14");
        myClientTask.execute();
        Log.d(TAGB, "enter");
    }
    public void exit(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"15");
        myClientTask.execute();
        Log.d(TAGB, "exit");
    }
    public void vlc(View V){
        Intent intent=new Intent(this,Control.class);
        intent.putExtra("ip", addr);
        startActivity(intent);
    }
    public void back(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"16");
        myClientTask.execute();
        Log.d(TAGB, "exit");
    }
    public void altright(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"17");
        myClientTask.execute();
        Log.d(TAGB, "alt left");
    }
    public void altleft(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"18");
        myClientTask.execute();
        Log.d(TAGB, "alt left");
    }
    public void ok(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"19");
        myClientTask.execute();
        Log.d(TAGB, "ok");
    }
    public void space(View V){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"01");
        myClientTask.execute();
        if(!alternate){
            play_pause.setImageResource(android.R.drawable.ic_media_play);
            alternate=true;}
        else{
            play_pause.setImageResource(android.R.drawable.ic_media_pause);
            alternate=false;
        }
        // Toast.makeText(Control.this, addr, Toast.LENGTH_SHORT).show();
        Log.d(TAGV,"pause/play");

    }
    public void fast5(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"02");
        myClientTask.execute();
        Log.d(TAGV, "fast3");
    }
    public void fastmin(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"03");
        myClientTask.execute();
        Log.d(TAGV, "fast 1min");
    }
    public void rewmin(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"04");
        myClientTask.execute();
        Log.d(TAGV, "rewind 1min");
    }
    public void rew(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"05");
        myClientTask.execute();
        Log.d(TAGV, "rewind 3secs");
    }
    public void volumeplus(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"06");
        myClientTask.execute();
        Log.d(TAGV, "volume+");
    }
    public void volumeminus(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"07");
        myClientTask.execute();
        Log.d(TAGV, "volume-");
    }
    public void fullscreen(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"08");
        myClientTask.execute();
        Log.d(TAGV, "fullscreen");
    }
    public void time(View v){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"09");
        myClientTask.execute();
        Log.d(TAGV, "passed time");
    }
    public void slide(View V){
        MyClientTask myClientTask=new MyClientTask(addr,12345,"20");
        myClientTask.execute();
        Log.d(TAGO, "slideshow");
    }

}
