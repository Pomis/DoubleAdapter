package pomis.app.myapplication.models;

/**
 * Created by romanismagilov on 04.10.16.
 */

public class MessageModel extends MessengerObject {
    public String sender;
    public String time;

    public MessageModel(String text, String sender, String time) {
        this.text = text;
        this.sender = sender;
        this.time = time;
    }
}
