package pomis.app.myapplication.network;

import android.content.Context;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by romanismagilov on 25.10.16.
 */

public class AuthAtask extends AsyncTask {

    Context context;
    @Override
    protected Object doInBackground(Object[] params) {
        context = (Context) params[0];
        JSONObject authJSON = new JSONObject();
        try {
            authJSON.put("name", "keka");
            authJSON.put("password", "keka123");
            String response = Connection.withJSON(
                    "http://" + Connection.host + "/auth",
                    "POST",
                    authJSON
            );

            response = response.substring(0, 32);

            if (response.length() > 10 && response.length() < 100) {
                PreferenceManager.getDefaultSharedPreferences(context)
                        .edit()
                        .putString("access_token", response)
                        .apply();
            }
            Log.d("kek", response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
