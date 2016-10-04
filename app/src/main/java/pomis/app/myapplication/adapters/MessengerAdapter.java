package pomis.app.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pomis.app.myapplication.R;
import pomis.app.myapplication.models.MessageModel;
import pomis.app.myapplication.models.MessengerObject;
import pomis.app.myapplication.models.NotificationModel;

/**
 * Created by romanismagilov on 04.10.16.
 */

public class MessengerAdapter extends ArrayAdapter {

    ArrayList<MessengerObject> list;

    public MessengerAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.list = (ArrayList<MessengerObject>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (list.get(position) instanceof MessageModel) {
            MessageViewHolder holder;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_message, null);
                holder = new MessageViewHolder(
                        (TextView) convertView.findViewById(R.id.tv_message_text),
                        (TextView) convertView.findViewById(R.id.tv_sender_name),
                        (TextView) convertView.findViewById(R.id.tv_time)
                );
                convertView.setTag(holder);

            } else {
                holder = (MessageViewHolder) convertView.getTag();
            }

            MessageModel message = (MessageModel) list.get(position);
            holder.sender.setText(message.sender);
            holder.text.setText(message.text);
            holder.time.setText(message.time);

        } else if (list.get(position) instanceof NotificationModel) {
            NotificationViewHolder holder;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_notification, null);
                holder = new NotificationViewHolder(
                        (TextView) convertView.findViewById(R.id.tv_notification_text)
                );
                convertView.setTag(holder);

            } else {
                holder = (NotificationViewHolder) convertView.getTag();
            }

            NotificationModel notification = (NotificationModel) list.get(position);
            holder.text.setText(notification.text);
        }


        return convertView;
    }

    class MessageViewHolder {
        TextView text;
        TextView sender;
        TextView time;

        public MessageViewHolder(TextView text, TextView sender, TextView time) {
            this.text = text;
            this.sender = sender;
            this.time = time;
        }
    }

    class NotificationViewHolder {
        TextView text;

        public NotificationViewHolder(TextView text) {
            this.text = text;
        }
    }

}
