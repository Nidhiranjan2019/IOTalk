package in.codepredators.delta.Classes;

public class StarredMessage {
    public String StarredMessagesMessageSender;
    public String StarredMessagesMessageReceiver;
    public String StarredMessagesDatetextView;
    public String StarredMessagesMessagetextView;
    public String StarredMessagesTimetextView;
    public StarredMessage() {
    }

    public StarredMessage(String StarredMessagesMessageSender, String StarredMessagesMessageReceiver, String StarredMessagesDatetextView, String StarredMessagesMessagetextView, String StarredMessagesTimetextView) {
        this.StarredMessagesMessageSender=StarredMessagesMessageSender;
        this.StarredMessagesMessageReceiver=StarredMessagesMessageReceiver;
        this.StarredMessagesDatetextView=StarredMessagesDatetextView;
        this.StarredMessagesMessagetextView=StarredMessagesMessagetextView;
        this.StarredMessagesTimetextView= StarredMessagesTimetextView;
    }

    public String getStarredMessagesMessageSender() {
        return StarredMessagesMessageSender;
    }

    public void setStarredMessagesMessageSender(String StarredMessagesMessageSender) {
        this.StarredMessagesMessageSender = StarredMessagesMessageSender;
    }

    public String getStarredMessagesMessageReceiver() {
        return StarredMessagesMessageReceiver;
    }

    public void setStarredMessagesMessageReceiver(String StarredMessagesMessageReceiver) {
        this.StarredMessagesMessageReceiver = StarredMessagesMessageReceiver;
    }

    public String getStarredMessagesDatetextView() {
        return StarredMessagesDatetextView;
    }

    public void setStarredMessagesDatetextView(String StarredMessagesDatetextView) {
        this.StarredMessagesDatetextView = StarredMessagesDatetextView;
    }

    public String getStarredMessagesMessagetextView() {
        return StarredMessagesMessagetextView;
    }

    public void setStarredMessagesMessagetextView(String StarredMessagesMessagetextView) {
        this.StarredMessagesMessagetextView = StarredMessagesMessagetextView;
    }

    public String getStarredMessagesTimetextView() {
        return StarredMessagesTimetextView;
    }

    public void setStarredMessagesTimetextView(String StarredMessagesTimetextView) {
        this.StarredMessagesTimetextView = StarredMessagesTimetextView;
    }

}