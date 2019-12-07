package in.codepredators.delta.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import in.codepredators.delta.Classes.DatabaseHelperPersonDetail;
import in.codepredators.delta.Classes.Group;
import in.codepredators.delta.Classes.Message;
import in.codepredators.delta.Classes.PersonalMessage;
import in.codepredators.delta.Classes.RecyclerAdapterChatList;
import in.codepredators.delta.Classes.User;
import in.codepredators.delta.Fragment.ArchiveFragment;
import in.codepredators.delta.Fragment.ChatFragment;
import in.codepredators.delta.Fragment.CodeFragment;
import in.codepredators.delta.R;

/**
 * {@link #chatListObject()}                                       Sets and returns an object of class ChatListItem
 * {@link #selectedChat(ChatListItem, int)}                        Handles the clicking and selecting of any chat
 * {@link #sendNotificationToUser(String, String)}                 Sends notification to user that a message has been received
 */

public class ChatList extends AppCompatActivity {


    ImageView backArrow;
    static  TextView noOfChatsSelected;
    ImageView pinChat;
    ImageView muteChat;
    ImageView archiveChat;
    ImageView searchIcon;
    EditText searchEditText ;
    TextView iotalkText;


    ViewPager viewPager;
    TabLayout tabs;


    String testNames[] = {
            "Raj Kothari",
            "Kumar Harsh",
            "Parth Sharma",
            "Garima Singh",
            "Anushka Chandel",
            "Rakshita Jain",
            "Raj Kothari 2",
            "Kumar Harsh 2",
            "Parth Sharma 2",
            "Garima Singh 2"
    };

    public static String UID = "abcd";
    RecyclerView chatListRecycler;
    LinearLayoutManager layoutManager;
    RecyclerAdapterChatList recyclerAdapterChatList;
    List<ChatListItem> chatList;
    DatabaseHelperPersonDetail databaseHelperPersonDetail;
    FloatingActionButton floatingActionButton;
    public static LinearLayout linearLayout , linearLayout2 ;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iotalkactivity_chatscreen);

//        showChatList();

        floatingActionButton = findViewById(R.id.floatingActionNewChat);
        backArrow = findViewById(R.id.imageViewBackButton);
        noOfChatsSelected= findViewById(R.id.noOfItemsSelected);
        pinChat= findViewById(R.id.pushPinIconImageView);
        muteChat= findViewById(R.id.muteIconImageView);
        archiveChat= findViewById(R.id.archiveIconImageView);
        searchIcon = findViewById(R.id.viewSearchChatScreen);
        searchEditText = findViewById(R.id.editTextSearchChatScreen);
        iotalkText = findViewById(R.id.textViewIOTalkChatScreen);
        viewPager = findViewById(R.id.viewpagerChatList);
        linearLayout = findViewById(R.id.selectedChatScreenActionBar);
        linearLayout2 = findViewById(R.id.linearLayout3ChatScreen);
        tabs = findViewById(R.id.tabs);
        sharedPreferences = getSharedPreferences("IOTalk",0);
        editor = sharedPreferences.edit();

        viewPager.setAdapter(new ChatListPagerAdapter(getSupportFragmentManager()));
//        tabs.setupWithViewPager(viewPager);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Log.i("sendmessageClicked","done") ;
                        Log.i("abcdefg","ChatLine312");


                          PersonalMessage  personalMessage = new PersonalMessage();
                            personalMessage.setPersonalUserOne(sharedPreferences.getString("UserOne","NOTFOUND"));
                            personalMessage.setPID(sharedPreferences.getString("PID","NOTFOUND"));
                            personalMessage.setPersonalUserTwo(sharedPreferences.getString("UserTwo","NOTFOUND"));

                            // personalMessage.setPID(getPID(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber(),user2.getUserNumber()));
                            personalMessage.setPID("PID"+"8318711855"+"6205572993");
                            personalMessage.setPersonalUserOne("MeINhuTy1oYhjiM81QIbzZFhqup1");
                            personalMessage.setPersonalUserTwo("8FM1u4ZmRoXwlnOcdBDnATbd8Fw1");

                            editor.putString("UserOne",personalMessage.getPersonalUserOne());
                            editor.putString("UserTwo",personalMessage.getPersonalUserTwo());
                            editor.putString("Messages","messageblock");
                            editor.commit();
                            FirebaseDatabase.getInstance().getReference().child("personalMessage").child(personalMessage.getPID()).setValue(personalMessage);

            }
        });


        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(),true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

    });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        pinChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        muteChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        archiveChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditText.setVisibility(View.VISIBLE);
                iotalkText.setVisibility(View.GONE);

            }
        });




            chatList = new ArrayList<>();
        databaseHelperPersonDetail = new DatabaseHelperPersonDetail(this);
//        for(int i=0;i<10;i++)
//        {
//            chatList.add(chatListObject());
//            databaseHelperPersonDetail.insertPersonalChatDetail(chatList.get(i).getPersonalMessage(),"1:20pm","last message Id");
//            databaseHelperPersonDetail.insertUserDetail(chatList.get(i).getUser(),"string of image converted from bitmap of image","java/c/c++/python");
//        }
//        chatListRecycler = findViewById(R.id.chatlistchatrecycler);
//        layoutManager = new LinearLayoutManager(getApplicationContext());
//        chatListRecycler.setLayoutManager(layoutManager);

        //start

//
//    recyclerAdapterChatList = new RecyclerAdapterChatList(this,chatList);
//        sendNotificationToUser("puf", "Hi there puf!");
//        chatListRecycler.setAdapter(recyclerAdapterChatList);
       //end
        Toast.makeText(this,"List is completed, now we will update it",Toast.LENGTH_LONG).show();



}
    @Override
    public void onBackPressed()
    {


    }

    public ChatListItem chatListObject()
    {
        ChatListItem chatListItem = new ChatListItem();
        PersonalMessage personalMessage = new PersonalMessage();
        User user = new User();
        Message message = new Message();
        user.setUID("1234");
        user.setUserName("Raj kothari");
        user.setUserNumber("9876543210");
        message.setMessageType("10000");
        message.setMessageText("i am here");
        message.setMessageTime("1:20");
        personalMessage.setPersonalUserOne("raj");
        personalMessage.setPersonalUserTwo("Raj");
        personalMessage.setPID("rajandRaj");
        chatListItem.setArchive(false);
        chatListItem.setPinStatus(false);
        chatListItem.setMessage(message);
        chatListItem.setUser(user);
        chatListItem.setPersonalMessage(personalMessage);
        return chatListItem;
    }
    public static void sendNotificationToUser(String user, final String message) {
    }

    public enum ChatListItemType{
        PERSONAL,GROUP
    }
    public static class ChatListItem
    {
        private User user;
        private Message message;
        private PersonalMessage personalMessage;
        private String noOfUnseenMessage;
        private Boolean pinStatus;
        private Boolean archive;
        ChatListItemType chatListItemType;
        private Group group;

        public Group getGroup() {
            return group;
        }

        public void setGroup(Group group) {
            this.group = group;
        }

        public ChatListItemType getChatListItemType() {
            return chatListItemType;
        }

        public void setChatListItemType(ChatListItemType chatListItemType) {
            this.chatListItemType = chatListItemType;
        }

        public Boolean getArchive() {
            return archive;
        }

        public void setArchive(Boolean archive) {
            this.archive = archive;
        }

        public PersonalMessage getPersonalMessage() {
            return personalMessage;
        }

        public void setPersonalMessage(PersonalMessage personalMessage) {
            this.personalMessage = personalMessage;
        }
        public String getNoOfUnseenMessage() {
            return noOfUnseenMessage;
        }

        public void setNoOfUnseenMessage(String noOfUnseenMessage) {
            this.noOfUnseenMessage = noOfUnseenMessage;
        }

        public Boolean getPinStatus() {
            return pinStatus;
        }

        public void setPinStatus(Boolean pinStatus) {
            this.pinStatus = pinStatus;
        }

        public ChatListItem() {
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }



    class ChatListPagerAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> fragments;

        public ChatListPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(0,new ChatFragment());
            fragments.add(1,new ArchiveFragment());
            fragments.add(2,new CodeFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    static List<ChatListItem> selectedChatList = new ArrayList<>();
    static int selectedChatCount = 0;

    public static void selectedChat(ChatListItem m, int a) {
        selectedChatCount = a;
        if (selectedChatCount == 1) {
            linearLayout.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.GONE);
            noOfChatsSelected.setText(String.valueOf(selectedChatCount));
        }
        if (selectedChatCount == 0) {
            linearLayout.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.VISIBLE);
            noOfChatsSelected.setText(String.valueOf(selectedChatCount));
        }

        if (selectedChatList.size() > selectedChatCount) {
            selectedChatList.remove(m);
        } else {
            selectedChatList.add(m);
        }
        if (selectedChatCount > 1) {
            noOfChatsSelected.setText(String.valueOf(selectedChatCount));
        } else {
            noOfChatsSelected.setText(String.valueOf(selectedChatCount));
        }
    }





}


































//    private void seeMessages()
//    {
//        mChatMessagesDb.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                if (dataSnapshot.exists()) {
//                    String messageText = "",
//                            messagesenderUID = "";
//                    if (dataSnapshot.child(messages.getMID()).child("messageText").getValue() != null)
//                        messageText = dataSnapshot.child(messages.getMID()).child("messageText").getValue().toString();
//                    if (dataSnapshot.child(messages.getMID()).child("messagesenderUID").getValue() != null)
//                        messagesenderUID = dataSnapshot.child(messages.getMID()).child("messagesenderUID").getValue().toString();
//
//                }
//
//            }

//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @androidx.annotation.Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @androidx.annotation.Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }


