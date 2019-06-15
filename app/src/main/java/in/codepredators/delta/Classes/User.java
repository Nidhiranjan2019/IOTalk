package in.codepredators.delta.Classes;

import java.util.HashMap;

public class User {
    private String UID;
    private String userName;
    private String userNumber;
    private String userBio;
    private String userCountry;
    private String userProfilePic;
    private HashMap<String, String> userLanguages;                 //Languages used by user - Selected at the time of sign in -(Java,SigninTime)
    private HashMap<String, String> userStarredMessages;           //Starred message by user - (Message,time)
    private HashMap<String, String> userArchiveChats;                  //Archives message by user - (Message,time)
    private HashMap<String, String> userCode;        //(Code(message id),time)code messages
    private HashMap<String, String> userPinChats;

    public HashMap<String, String> getUserArchiveChats() {
        return userArchiveChats;
    }

    public void setUserArchiveChats(HashMap<String, String> userArchiveChats) {
        this.userArchiveChats = userArchiveChats;
    }

    public HashMap<String, String> getUserPinChats() {
        return userPinChats;
    }

    public void setUserPinChats(HashMap<String, String> userPinChats) {
        this.userPinChats = userPinChats;
    }

    private String userLastSeen;
    private HashMap<String, String> userPersonalChats;             //(Id,time of start of chat)
    private HashMap<String, String> userGroupChats;                // (Id,time of group formation)
    private HashMap<String, String> userLastSeenVisibility;        //(visibility type, time of changing setting)

    public User(String UID, String userName, String userNumber, String userBio, String userCountry, String userProfilePic, HashMap<String, String> userLanguages, HashMap<String, String> userStarredMessages, HashMap<String, String> userArchives, HashMap<String, String> userCode, String userLastSeen, HashMap<String, String> userPersonalChats, HashMap<String, String> userGroupChats, HashMap<String, String> userLastSeenVisibility) {
        this.UID = UID;
        this.userName = userName;
        this.userNumber = userNumber;
        this.userBio = userBio;
        this.userCountry = userCountry;
        this.userProfilePic = userProfilePic;
        this.userLanguages = userLanguages;
        this.userStarredMessages = userStarredMessages;
        this.userArchiveChats= userArchives;
        this.userCode = userCode;
        this.userLastSeen = userLastSeen;
        this.userPersonalChats = userPersonalChats;
        this.userGroupChats = userGroupChats;
        this.userLastSeenVisibility = userLastSeenVisibility;
    }


    public User() {
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserProfilePic() {
        return userProfilePic;
    }

    public void setUserProfilePic(String userProfilePic) {
        this.userProfilePic = userProfilePic;
    }

    public HashMap<String, String> getUserLanguages() {
        return userLanguages;
    }

    public void setUserLanguages(HashMap<String, String> userLanguages) {
        this.userLanguages = userLanguages;
    }

    public HashMap<String, String> getUserStarredMessages() {
        return userStarredMessages;
    }

    public void setUserStarredMessages(HashMap<String, String> userStarredMessages) {
        this.userStarredMessages = userStarredMessages;
    }



    public HashMap<String, String> getUserCode() {
        return userCode;
    }

    public void setUserCode(HashMap<String, String> userCode) {
        this.userCode = userCode;
    }

    public String getUserLastSeen() {
        return userLastSeen;
    }

    public void setUserLastSeen(String userLastSeen) {
        this.userLastSeen = userLastSeen;
    }

    public HashMap<String, String> getUserPersonalChats() {
        return userPersonalChats;
    }

    public void setUserPersonalChats(HashMap<String, String> userPersonalChats) {
        this.userPersonalChats = userPersonalChats;
    }

    public HashMap<String, String> getUserGroupChats() {
        return userGroupChats;
    }

    public void setUserGroupChats(HashMap<String, String> userGroupChats) {
        this.userGroupChats = userGroupChats;
    }

    public HashMap<String, String> getUserLastSeenVisibility() {
        return userLastSeenVisibility;
    }

    public void setUserLastSeenVisibility(HashMap<String, String> userLastSeenVisibility) {
        this.userLastSeenVisibility = userLastSeenVisibility;
    }
}
