package freetime.project.tvremote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_VLC#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_VLC extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageButton b;
    Boolean alternate=false;
    public Frag_VLC() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_VLC.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_VLC newInstance(String param1, String param2) {
        Frag_VLC fragment = new Frag_VLC();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.frag__vlc, container, false);
        b= (ImageButton) v.findViewById(R.id.imageButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyClientTask myClientTask=new MyClientTask(mParam1,12345,"01");
                myClientTask.execute();
                if(!alternate){
                    b.setImageResource(android.R.drawable.ic_media_play);
                    alternate=true;}
                else{
                    b.setImageResource(android.R.drawable.ic_media_pause);
                    alternate=false;
                }
                // Toast.makeText(Control.this, addr, Toast.LENGTH_SHORT).show();
                Log.d("vlc", "pause/play");
            }
        });
        return v;
    }

}
