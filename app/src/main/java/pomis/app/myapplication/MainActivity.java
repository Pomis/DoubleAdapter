package pomis.app.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import pomis.app.myapplication.adapters.MessengerAdapter;
import pomis.app.myapplication.models.MessageModel;
import pomis.app.myapplication.models.MessengerObject;
import pomis.app.myapplication.models.NotificationModel;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MessengerAdapter adapter;
    ArrayList<MessengerObject> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initArray();
        bindViews();
        initAdapter();
    }

    private void initArray() {
        arrayList = new ArrayList<>();
        arrayList.add(new MessageModel("Прифффффетки", "Кека", "15:01"));
        arrayList.add(new MessageModel("САЛАМ АЛЕЙКУМ!", "Джон", "15:02"));
        arrayList.add(new MessageModel("Каг дела?", "МЕДВЕД", "15:06"));
        arrayList.add(new MessageModel("НАРМАС)))", "Анонимус", "15:07"));
        arrayList.add(new NotificationModel("Кореец вошёл в чат"));
        arrayList.add(new MessageModel("Го дота", "Кореец", "15:08"));
    }

    private void bindViews() {
        listView = (ListView) findViewById(R.id.lv_messages);
    }


    private void initAdapter() {
        adapter = new MessengerAdapter(this, 0, arrayList);
        
        listView.setAdapter(adapter);
    }
}
