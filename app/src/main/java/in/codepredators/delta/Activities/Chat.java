package in.codepredators.delta.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import in.codepredators.delta.Classes.GlideApp;
import in.codepredators.delta.Classes.Message;
import in.codepredators.delta.Classes.PersonalMessage;
import in.codepredators.delta.Classes.RecyclerAdapterChatRecycler;
import in.codepredators.delta.Classes.User;
import in.codepredators.delta.R;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Chat extends AppCompatActivity {
    HashMap<String,String> hashmap = new HashMap<>();

    ImageView testImage;
    StorageReference riversRef;
    ImageView chatU2ProfilePic;
    TextView chatU2Name;
    TextView chatU2Status;
    ImageView memeImage;
    ImageView selectContent;
    LinearLayout pinIconLayout;

    ImageView phoneGallery;
    ImageView phoneCamera;
    ImageView phoneDocument;
    ImageView sendMessage;
    CheckBox codecheckBox;
    EditText messageContent;
    RecyclerView messagesRecycler;
    RecyclerView codeRecycler;
    LinearLayout codeListLinearLayout;
    LinearLayout chatActionBar;
    LinearLayout selectedChatActionBar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editor2;
    String UID;
    FirebaseAuth mAuth;
    RecyclerAdapterChatRecycler recyclerAdapterGroupText1;
    String typeOfMessage;
    String TypeDay = "N";
    String TEXT = "0";
    static String IMAGE = "0";
    String CONTACT = "0";
    String FILE = "0";
    String REPLIED = "0";
    PersonalMessage personalMessage;

    RecyclerView.LayoutManager mLayoutManager;
    Message m ;
    DatabaseReference messageReference,s;
    ChildEventListener childEventListener;

    int a=0;
    int g=0;
    int RESULT_LOAD_IMAGE =0;
    int RESULT_LOAD_DOCUMENT = 0;
    Uri imageUri;
    String downloadUrl;
    String timeOfDataSaving;
    TextView selectedMessageNumber;
    ImageView selectedChatStar;
    ImageView deleteSelectedMessage;
    ImageView copySelectedMessage;

    //ImageView sendingmessageImage;
    List<Message> messageList = new ArrayList<>();
    private StorageReference mStorageRef;
    Bitmap bitmap;
//       static List<Message> selectedMessageList = new ArrayList<>();
//
//    public static void selectedMessage(Message m,int a)
//    {
//     if(a>=1)
//     {
//         selectedMessageList.add(m);
//         Log.i("selectedMessageAdded","done");
//         if(a == 1)
//         {
//             //make the layout visible
//             chatActionBar.setVisibility(View.GONE);
//             selectedChatActionBar.setVisibility(View.VISIBLE);
//         }
//     }
//     else
//     {
//         selectedMessageList.remove(m);
//         Log.i("selectedMessageAdded","reversedone");
//         if(a==0)
//         {
//             //after selecting one layout will be se into visible so after nothimg is selected u have to gone it
//             chatActionBar.setVisibility(View.VISIBLE);
//             selectedChatActionBar.setVisibility(View.GONE);
//         }
//     }
//    }

    //    public void showPdf(String filePath){
//            Log.i("showingPdf", "strat");
//        Uri fileURI = Uri.fromFile(new File(filePath));
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            Log.i("showingPdf", "intentcreated");
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//            intent.setDataAndType(fileURI, "application/pdf");
//            Log.i("showingPdf", "intentcreatedforpdf");
//            startActivity(intent);
//    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("abcdefg","ChatLine144");
        if (RESULT_LOAD_IMAGE == 1)
        {
            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK)
            {
                imageUri = data.getData();
                try
                {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                }
                catch (IOException e)
                {
                    Log.i("unabletogetbitymap","GoneWrong");
                    e.printStackTrace();
                }
                IMAGE = "1";
                timeOfDataSaving = getTime();
                riversRef = mStorageRef.child(timeOfDataSaving + ".jpg");

            }
            Log.i("abcdefg","ChatLine162");
        }

        if(RESULT_LOAD_DOCUMENT == 1)
        {
            if (requestCode == RESULT_LOAD_DOCUMENT && resultCode == RESULT_OK)
            {
                imageUri = data.getData();
                FILE = "1";
                Log.i("pdfselected","pdfinside");
                timeOfDataSaving = getTime();
                riversRef = mStorageRef.child(timeOfDataSaving + ".pdf");
            }
            Log.i("abcdefg","ChatLine174");
        }
        Log.i("pdfselected","pdfoutside");

        Log.i("pdfselected","callingsetRecyclerAndFirebase");
        RESULT_LOAD_DOCUMENT = 0;
        RESULT_LOAD_IMAGE = 0;
        setRecyclerAndFirebase(TEXT, IMAGE, CONTACT, FILE, REPLIED);

        // sendingmessageImage.setImageURI(imageUri);

    }
    @Override
    protected void onCreate(final Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.iotalkactivity_personalchat);
        Log.i("abcdefg","ChatLine190");
        chatU2ProfilePic = findViewById(R.id.profilePicChatActivity);
        chatU2Name = findViewById(R.id.textViewContactNameChatActivity);
        chatU2Status = findViewById(R.id.textViewLastSeenGroupMembersChatActivity);
        memeImage = findViewById(R.id.imageViewMemesChatActivity);
        selectContent = findViewById(R.id.imageViewPinIconChatActivity);
        messageContent = findViewById(R.id.editTextEnterMessageChatActivity);
        sendMessage = findViewById(R.id.imageViewSendIconChatActivity);
        codecheckBox = findViewById(R.id.checkBoxCodeFileChatActivity);
        messagesRecycler = findViewById(R.id.recyclerViewMessagesChatActivity);
        codeRecycler = findViewById(R.id.recyclerViewChatCodeList);
        codeListLinearLayout = findViewById(R.id.linearLayoutChatCodeList);
        phoneGallery = findViewById(R.id.selectImageGallery);
        phoneCamera = findViewById(R.id.selectCamera);
        phoneDocument = findViewById(R.id.selectDocuments);
        pinIconLayout = findViewById(R.id.phoneDataSelection);
        chatActionBar = findViewById(R.id.chatActionBar);
        selectedChatActionBar = findViewById(R.id.selectedChatActionBar);

        selectedMessageNumber = findViewById(R.id.selectedMessageNumber);
        selectedChatStar = findViewById(R.id.selectedChatStarred);
        deleteSelectedMessage = findViewById(R.id.deleteSelectedMessage);
        copySelectedMessage = findViewById(R.id.copySelectedMessage);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        sendMessage.setClickable(false);

        m = new Message();

        hashmap.put("C","Raj");
        hashmap.put("d","Raj");
        hashmap.put("w","Raj");
        hashmap.put("r","Raj");
        hashmap.put("n","Raj");
        // final User user =new User("UIDabcd","Nameabcd","Numberabcd","Bioabcd","India","Profileabcd",hashmap,hashmap,hashmap,hashmap,"userLastseen",hashmap,hashmap,hashmap);
        final User user2 = new User();
        user2.setUID("8FM1u4ZmRoXwlnOcdBDnATbd8Fw1");
        user2.setUserLastSeen("Online");
//user2.setUserNumber(FirebaseDatabase.getInstance().getReference().child("users").child(user2.getUID()).child("userNumber").getKey());
        user2.setUserName("User1");
        user2.setUserProfilePic("https://firebasestorage.googleapis.com/v0/b/iotalk-552e3.appspot.com/o/images.jpg?alt=media&token=7d23a8ac-8684-47be-9a79-5d9ebeb4346c");
        user2.setUserNumber("8318711855");
        user2.setUserLanguages(hashmap);
        mAuth = FirebaseAuth.getInstance();
//        UID = mAuth.getCurrentUser().getUid();
        UID ="MeINhuTy1oYhjiM81QIbzZFhqup1";

        chatU2Name.setText(user2.getUserName());
        chatU2Status.setText(user2.getUserLastSeen());

        sharedPreferences = getSharedPreferences("IOTalk",0);
        Log.i("abcdefg","ChatLine241");

        memeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        selectContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("abcdefg","ChatLine253");
                if(g==0)
                {
                    pinIconLayout.setVisibility(View.VISIBLE);
                    g=1;
                }
                else
                {
                    pinIconLayout.setVisibility(View.GONE);
                    g=0;
                }
            }
        });

        phoneGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_LOAD_IMAGE =1;
                Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
                gallery.setType("image/*");
                startActivityForResult(gallery, RESULT_LOAD_IMAGE);
            }
        });
        phoneDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_LOAD_DOCUMENT = 1;
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("application/pdf");
                Log.i("pdfselected","callingpdf");
                startActivityForResult(intent,RESULT_LOAD_DOCUMENT);
            }
        });
        phoneCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chat.this,IOCamera.class);
                startActivity(intent);
                if(IMAGE.equals("1"))
                {
                    setRecyclerAndFirebase(TEXT,IMAGE,CONTACT,FILE,REPLIED);
                }

            }
        });
        m = new Message();
        editor = sharedPreferences.edit();
        m.setMessageImage(sharedPreferences.getString("MessageImage","NOTFOUND"));
        m.setMessageType(TypeDay);
        messageList.add(m);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        messagesRecycler.setLayoutManager(mLayoutManager);
        recyclerAdapterGroupText1 = new RecyclerAdapterChatRecycler(messageList,Chat.this);
        messagesRecycler.setItemAnimator(new DefaultItemAnimator());
        messagesRecycler.setAdapter(recyclerAdapterGroupText1);
        m = new Message();
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("sendmessageClicked","done") ;
                Log.i("abcdefg","ChatLine312");
                if(a==0)
                {

                    personalMessage = new PersonalMessage();
                    personalMessage.setPersonalUserOne(sharedPreferences.getString("UserOne","NOTFOUND"));
                    personalMessage.setPID(sharedPreferences.getString("PID","NOTFOUND"));
                    personalMessage.setPersonalUserTwo(sharedPreferences.getString("UserTwo","NOTFOUND"));

                    // personalMessage.setPID(getPID(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber(),user2.getUserNumber()));
                    personalMessage.setPID(getPID("6205572993",user2.getUserNumber()));
                    personalMessage.setPersonalUserOne(UID);
                    personalMessage.setPersonalUserTwo(user2.getUID());

                    editor.putString("UserOne",personalMessage.getPersonalUserOne());
                    editor.putString("UserTwo",personalMessage.getPersonalUserTwo());
                    editor.putString("Messages","messageblock");
                    editor.commit();
                    FirebaseDatabase.getInstance().getReference().child("personalMessage").child(personalMessage.getPID()).setValue(personalMessage);
//
//
                    //    setRecyclerAndFirebase(TEXT,IMAGE,CONTACT,FILE,REPLIED);
                    Log.i("abcdefg","ChatLine334");
                    a=1;
                }
                else
                {
                    setRecyclerAndFirebase(TEXT,IMAGE,CONTACT,FILE,REPLIED);
                }

            }
        });

        messageReference = FirebaseDatabase.getInstance().getReference().child("personalMessage").child(getPID("6205572993",user2.getUserNumber())).child("messages");
        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull final DataSnapshot dataSnapshot, @Nullable String s) {
                Log.i("message is coming", "Yes");
                if(dataSnapshot.child("messagesenderUID").getValue(String.class).equals(user2.getUID()))
                {
                    Log.i("MessageComing","My message");
                }
                else
                {
                    final Message m = new Message();
                    m.setMessageType(dataSnapshot.child("messageType").getValue(String.class));
                    m.setMessagesenderUID(dataSnapshot.child("messagesenderUID").getValue(String.class));
                    Log.i("messagesenderuid",m.getMessagesenderUID());
                    m.setMID(dataSnapshot.child("mid").getValue(String.class));
                    Log.i("messageMID",m.getMID());
                    m.setMessageTime(dataSnapshot.child("messageTime").getValue(String.class));
                    Log.i("messageTime",m.getMessageTime());

//                       File localFile = null;
//                       try {
//                           localFile = File.createTempFile("images", "jpg");
//                       } catch (IOException e) {
//                           e.printStackTrace();
//                       }

// ImageView in your Activity

                    if(m.getMessageType().charAt(1) == '1')
                    {
//                            StorageReference storageReference = mStorageRef.child(dataSnapshot.child("messageImage").getValue(String.class));
//                       Log.i("GlideAppWorking","Start");
//                            GlideApp.with(Chat.this)
//                                    .load(storageReference)
//                                    .into(memeImage);
//                            Log.i("GlideAppWorking","End");
//                            memeImage.buildDrawingCache();
//                            Bitmap bitmap = memeImage.getDrawingCache();
//                            m.setMessageImageBitmap(bitmap);
                        m.setMessageImageBitmap(null);
                        m.setMessageImage(dataSnapshot.child("messageImage").getValue(String.class));
                        //convert memeimage back to meme icon
                    }
                    //Saving file is remaining

                    if(m.getMessageType().charAt(0) == '1') {
                        m.setMessageText(dataSnapshot.child("messageText").getValue(String.class));
                    }
                    if(m.getMessageType().charAt(3)=='1')
                    {
                        m.setMessageFileLocalAdress(null);
                        m.setMessageFile(dataSnapshot.child("messageFile").getValue(String.class));
                    }
                    messageList.add(m);
                    recyclerAdapterGroupText1.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        messageReference.addChildEventListener(childEventListener);

//
//        if(a==1) {
//            messageReference.addChildEventListener(childEventListener);
//        }
//        else
//        {
//            messageReference.removeEventListener(childEventListener);
//        }

        messageContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("EditTextClickes","insidebeforetextchanged");
                Log.i("abcdefg","ChatLine405");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("EditTextClickd","insideOntextchanged");
                Log.i("abcdefg","ChatLine411");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("abcdefg","ChatLine416");
                if(messageContent.getText().length()>0)
                {
                    sendMessage.setClickable(true);
                    TEXT = "1";
                }
                else
                {
                    TEXT = "0";
                }
            }
        });

        // On click listner of chatActionBar
        selectedChatStar = findViewById(R.id.selectedChatStarred);
        deleteSelectedMessage = findViewById(R.id.deleteSelectedMessage);


        selectedChatStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        deleteSelectedMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        copySelectedMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public static Bitmap bitmap2;
    public static void cameraImageBitmap(Bitmap b)
    {
        IMAGE = "1";
        bitmap2 = b;
        Log.i("cameraImageBitmap", String.valueOf(b));
    }
    public String getMID(String PID)
    {
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        date = date.replaceAll("[-]","");
        String MID;
        MID = "MID" + PID + date + getTime();
        return MID;
    }
    public String getTime()
    {
        Calendar calander = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        String  time = simpleDateFormat.format(calander.getTime());
        return time ;
    }
    public String getPID(String U1Number,String U2Number)
    {
        String PID;
        PID = "PID" + U1Number + U2Number;
        return PID;
    }
    public void setRecyclerAndFirebase(String T,String I,String C,String F,String R)
    {
        m.setMessageImageBitmap(bitmap);
        Log.i("abcdefg","ChatLine487");
        Log.i("setRecyclerAndFirebase","called") ;
        String Type;
        Type = T + I + C + F + R;

        m.setMessagesenderUID(UID);
        if(T.equals("1"))
        {
            m.setMessageText(messageContent.getText().toString());
        }
        m.setMessageTime(getTime());
        m.setMID(getMID(personalMessage.getPID()));
        if(I.equals("1"))
        {
            m.setMessageImage(timeOfDataSaving + ".jpg");
            m.setMessageImageBitmap(bitmap);
        }
        if(F.equals("1"))
        {
            Log.i("pdfselected","F.equals(1) downloadUrl");
            m.setMessageFileLocalAdress(imageUri.getPath());
            m.setMessageFile(timeOfDataSaving + ".pdf");
        }

        m.setMessageType(Type);
        messageList.add(m);
        Log.i("numberofobjectsinList", String.valueOf(messageList.size()));
        // recyclerAdapterGroupText1.updateMessageListItems(messageList);
        recyclerAdapterGroupText1.notifyDataSetChanged();
        if(I.equals("1") || F.equals("1"))
        {
            riversRef.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getApplicationContext(),"Image or file is uploaded",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(Chat.this, "image not selected", Toast.LENGTH_SHORT).show();
                            // Handle unsuccessful uploads
                            // ...
                        }
                    });
        }
        messageContent.setText("");
        sendMessage.setClickable(false);
        IMAGE = "0";
        TEXT = "0";
        CONTACT = "0";
        FILE = "0";
        REPLIED = "0";
        TypeDay="N";
        RESULT_LOAD_IMAGE = 0;
        RESULT_LOAD_DOCUMENT = 0;
        Log.i("numberofitems", String.valueOf(recyclerAdapterGroupText1.getItemCount()));
        editor.putString("MID",m.getMID());
        if(T.equals("1")) {
            editor.putString("MessageText", m.getMessageText());
        }
        editor.putString("MessageTime",m.getMessageTime());
        editor.putString("MessagesenderUID",m.getMessagesenderUID());
        editor.putString("MessageType",m.getMessageType());
        if(I.equals("1"))
        {
            editor.putString("MessageImage",m.getMessageImage());}
        if(F.equals("1"))
        {
            Log.i("pdfselected","F.equals(1)editor");
            editor.putString("MessageFile",m.getMessageFile());
        }
        editor.commit();
        m.setMessageImageBitmap(null);
        m.setMessageFileLocalAdress(null);
        //   FirebaseDatabase.getInstance().getReference().child("personalMessage").child(personalMessage.getPID()).child("messages").setValue(m);
        FirebaseDatabase.getInstance().getReference().child("personalMessage").child(personalMessage.getPID()).child("messages").child(m.getMID()).setValue(m);
        if(I.equals("1"))
            m.setMessageImageBitmap(bitmap);
        if(F.equals("1"))
            m.setMessageFileLocalAdress(imageUri.getPath());
        m = new Message();
    }

}
// Got the download URL for 'users/me/profile.png'
//                         Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
//                         while (!urlTask.isSuccessful()) ;
//                         Uri Url = urlTask.getResult();
//                         downloadUrl = Url.toString();
//
//                         Toast.makeText(Chat.this, downloadUrl, Toast.LENGTH_SHORT).show();
//                         Log.i("image url", downloadUrl);
//                         m.setMessageImage(downloadUrl);
//                         Log.i("image url by user", m.getMessageImage());
//      editor.putString("GroupPic",newgroup.getGroupPic());
///                          editor.putString("UserProfilePic", downloadUrl);