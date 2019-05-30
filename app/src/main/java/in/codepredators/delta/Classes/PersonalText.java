package in.codepredators.delta.Classes;

public class PersonalText {
    public String Message;
    public String TimeOfMessage;

    public PersonalText() {
    }

    public PersonalText(String Message, String TimeOfMessage) {
        this.Message = Message;
        this.TimeOfMessage = TimeOfMessage;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getTimeOfMessage() {
        return TimeOfMessage;
    }

    public void setTimeOfMessage(String TimeOfMessage) {
        this.TimeOfMessage = TimeOfMessage;
    }
}