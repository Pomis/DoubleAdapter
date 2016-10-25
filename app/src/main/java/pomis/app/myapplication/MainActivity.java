package pomis.app.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import pomis.app.myapplication.adapters.MessengerAdapter;
import pomis.app.myapplication.models.MessengerObject;
import pomis.app.myapplication.network.AuthAtask;
import pomis.app.myapplication.network.MessageAtask;
import pomis.app.myapplication.network.SendAtask;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MessengerAdapter adapter;
    ArrayList<MessengerObject> arrayList;
    Button bSend;
    EditText etMessageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new AuthAtask().execute(this);
        new MessageAtask().execute(this);
    }

    public void initArray(ArrayList<MessengerObject> list) {
        arrayList = list;
        bindViews();
        initAdapter();
    }

    private void bindViews() {
        listView = (ListView) findViewById(R.id.lv_messages);
        bSend = (Button) findViewById(R.id.b_send);
        etMessageText = (EditText) findViewById(R.id.et_message_text);
        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SendAtask().execute(getApplicationContext(),
                        etMessageText.getText());
            }
        });
    }


    private void initAdapter() {
        adapter = new MessengerAdapter(this, 0, arrayList);
        
        listView.setAdapter(adapter);
    }
}
