package in.codepredators.delta.Classes;

public class ChatList {
    public String chatListName;
    public int textViewNoOfUnseenMessages;
    public String textViewTimeOfMessage;
    public ChatList() {
    }

    public ChatList(String chatListName, int textViewNoOfUnseenMessages, String textViewTimeOfMessage) {
        this.chatListName = chatListName;
        this.textViewNoOfUnseenMessages = textViewNoOfUnseenMessages;
        this.textViewTimeOfMessage = textViewTimeOfMessage;
    }

    public String getChatListName() {
        return chatListName;
    }

    public void setChatListName(String chatListName) {
        this.chatListName = chatListName;
    }

    public String getTextViewTimeOfMessage() {
        return textViewTimeOfMessage;
    }

    public void setTextViewTimeOfMessage(String textViewTimeOfMessage) {
        this.textViewTimeOfMessage = textViewTimeOfMessage;
    }

    public int getTextViewNoOfUnseenMessages() {
        return textViewNoOfUnseenMessages;
    }

    public void setTextViewNoOfUnseenMessages(int textViewNoOfUnseenMessages) {
        this.textViewNoOfUnseenMessages = textViewNoOfUnseenMessages;
    }
}