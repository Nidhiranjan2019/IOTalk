package in.codepredators.delta.Classes;

public class PersonalMessage extends Message
{
    private String messageInfo;
    private String messageStatus;

    public String getMessageInfo() {
        return messageInfo;
    }
    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }
    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }
}
