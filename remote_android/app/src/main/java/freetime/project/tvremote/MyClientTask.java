package freetime.project.tvremote;

/**
 * Created by praba1110 on 19/12/15.
 */

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * Created by praba1110 on 5/12/15.
 */


public class MyClientTask extends AsyncTask<Void, Void, Void> {

    String dstAddress;
    int dstPort;
    String response = "";

    MyClientTask(String addr, int port,String message){
        //dstAddress = values2.getInstance().SERVER_IP;
        dstAddress=addr;
        dstPort = port;
        response=message;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {

            socket = new Socket(dstAddress, dstPort);

            ByteArrayOutputStream byteArrayOutputStream =
                    new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];

            int bytesRead;
            InputStream inputStream = socket.getInputStream();

    /*
     * notice:
     * inputStream.read() will block if no data return
     */
            //while ((bytesRead = inputStream.read(buffer)) != -1){
            //byteArrayOutputStream.write(buffer, 0, bytesRead);
            // response += byteArrayOutputStream.toString("UTF-8");
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())),
                    true);
            out.println(response);


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "IOException: " + e.toString();
        }finally{
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // textResponse.setText(response);
        super.onPostExecute(result);
    }

}


