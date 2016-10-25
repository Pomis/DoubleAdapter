package pomis.app.myapplication.network;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pomis.app.myapplication.MainActivity;
import pomis.app.myapplication.models.MessageModel;
import pomis.app.myapplication.models.MessengerObject;

/**
 * Created by romanismagilov on 25.10.16.
 */

public class MessageAtask extends AsyncTask {
    String response;
    ArrayList<MessengerObject> list = new ArrayList<>();
    MainActivity activity;
    @Override
    protected Object doInBackground(Object[] params) {
        // подключение
        try {
            activity = (MainActivity) params[0];
            response = Connection.get("http://"+Connection.host+"/messages/100");
            Log.d("kek", response);

            JSONArray messages = new JSONArray(response);
            for (int i = 0; i < messages.length(); i++) {
                JSONObject message = messages.getJSONObject(i);
                list.add(new MessageModel(
                        message.getString("text"),
                        message.getString("senderName"),
                        ""
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        activity.initArray(list);
    }
}
