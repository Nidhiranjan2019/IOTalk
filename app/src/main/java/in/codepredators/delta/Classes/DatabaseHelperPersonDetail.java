package in.codepredators.delta.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperPersonDetail extends SQLiteOpenHelper {
    private static final String dbName="IOTalkPersonDetail";
    public static final String ChatTable="PersonTable";
    public String colDatabaseID = "ID";
    public String colDatabaseParticipant = "Participant";//UID of user
    public String colDatabaseName = "Name";
    public String colDatabaseDescription = "Discription";
    public String colDatabaseCountry = "Country";
    public String colDatabaseTime_Creator = "Time_Creator";//creating time and creator id
    public String colDatabaseImage = "Image";//User and image - image //Personal - id of opposite user
    public String colDatabaseLanguage = "Language";
    public String colDatabseArchievePinChat = "ArchievePinChat";
    public String colDatabaseAdmin = "Admin";
    public DatabaseHelperPersonDetail(Context context)
    {
        super(context,dbName,null,33);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists " + ChatTable + "(" + colDatabaseID + " String, " + colDatabaseAdmin + " String, "
                + colDatabaseCountry + " String, " + colDatabseArchievePinChat + " String, " + colDatabaseTime_Creator + " String, "
                + colDatabaseParticipant  + " String, " + colDatabaseName + " String, " + colDatabaseLanguage + " String, " +
                colDatabaseImage + " String, " + colDatabaseDescription + " String " + ");");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
//about personal chat icon image
    // in chat list the image will come from database
    // when user tap on image than it will download from firebase and it will update database image
    //and same work will be done when personal chat is open by user
    public long insertUserDetail(User user,String Image,String language)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(colDatabaseID,user.getUID());
        values.put(colDatabaseName,user.getUserName());
        values.put(colDatabaseDescription,user.getUserBio());
        values.put(colDatabaseTime_Creator,user.getUserTime());
        values.put(colDatabaseImage,Image);
        values.put(colDatabaseLanguage,language);
        long ID = DB.insert(ChatTable, null, values);
        DB.close();
        return ID;
    }
    public long insertPersonalChatDetail(PersonalMessage personalMessage, String Image, String Time,String description)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(colDatabaseID,personalMessage.getPID());
        values.put(colDatabaseParticipant,personalMessage.getPersonalUserOne() + "|" + personalMessage.getPersonalUserTwo());
        values.put(colDatabaseImage,Image);
        values.put(colDatabaseTime_Creator,Time);
        values.put(colDatabseArchievePinChat,"false");
        values.put(colDatabaseDescription,description);
        long ID = DB.insert(ChatTable,null,values);
        DB.close();
        return ID;
    }
    public void insertGroupChatDetail()
    {
        //these is remaining
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
    }
}
