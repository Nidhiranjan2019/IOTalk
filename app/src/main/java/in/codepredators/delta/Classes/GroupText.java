package in.codepredators.delta.Classes;

import android.widget.TextView;


public class GroupText {
    public String nameGroupMessage;
    public String  Message;
    public String Time;
    public GroupText() {
    }

    public GroupText(String nameGroupMessage, String Message, String Time) {
        this.nameGroupMessage = nameGroupMessage;
        this.Time = Time;
        this.Message= Message;
    }

    public String getNameGroupMessage() {
        return nameGroupMessage;
    }

    public void setNameGroupMessage(String nameGroupMessage) {
        this.nameGroupMessage = nameGroupMessage;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
}