package freetime.project.tvremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText iptext;
    String ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iptext= (EditText) findViewById(R.id.editText);

    }
    public void proceed(View V){
        ip=iptext.getText().toString();
        Intent intent=new Intent(this,Browse.class);
        intent.putExtra("ip",ip);
        startActivity(intent);
    }
}
