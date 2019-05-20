package in.codepredators.delta.Classes;

public class Message {
    private String messageTime;
    private String messageFormat;
    private String messageText;

    private String senderUID;
    private String starredStatus;
    private String archiveStatus;


    public Message() {
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageFormat() {
        return messageFormat;
    }

    public void setMessageFormat(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }



    public String getSenderUid() {
        return senderUID;
    }

    public void setSenderUid(String senderUID) {
        this.senderUID = senderUID;
    }

    public String getArchiveStatus() {
        return archiveStatus;
    }
    public void setArchiveStatus(String archiveStatus) {
        this.archiveStatus = archiveStatus;
    }

    public String getStarredStatus() {
        return starredStatus;
    }

    public void setStarredStatus(String starredStatus) {
        this.starredStatus = starredStatus;
    }
}
