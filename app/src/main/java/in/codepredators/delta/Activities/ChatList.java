package in.codepredators.delta.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import in.codepredators.delta.Classes.ChatFragment;
import in.codepredators.delta.Classes.CodeFragment;
import in.codepredators.delta.Classes.Message;
import in.codepredators.delta.Classes.ArchiveFragment;
import in.codepredators.delta.Classes.PersonalMessage;
import in.codepredators.delta.Classes.RecyclerAdapterChatList;
import in.codepredators.delta.Classes.User;
import in.codepredators.delta.Classes.ViewPagerAdapter;
import in.codepredators.delta.R;

public class ChatList extends AppCompatActivity {
    private ImageView searchIcon;
    private ImageView backIcon;
    private ImageView optionsIcon;

    private FloatingActionButton newChatButton;
    private RecyclerView recyclerView;
    private EditText searchBar;
    DatabaseReference mChatMessagesDb;
    PersonalMessage personalMessage = new PersonalMessage();
    Message messages = new Message();
    public List<User> userList;

    private TextView iotalk;
    private TabLayout tabLayout;
    RecyclerAdapterChatList Object1;
    public static LinearLayout linearLayout;
    public static LinearLayout linearLayout1;
    public static ImageView backIconCAB;
    public static ImageView pinIcon;
    public static ImageView muteIcon;
    public static ImageView archiveIcon;
    public static ImageView optionsIconCAB;





    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//    public int listSize = Object.getItemCount();

    private ViewPager viewPager;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iotalkactivity_chatscreen);


        viewPager = (ViewPager) findViewById(R.id.viewpagerChatList);


        searchIcon = findViewById(R.id.viewSearchChatScreen);
        optionsIcon = findViewById(R.id.viewSettingsChatScreen);
        newChatButton = findViewById(R.id.floatingActionNewChat);
//        mChatMessagesDb = FirebaseDatabase.getInstance().getReference().child("personalMessage").child(personalMessage.getPID()).child("messages");

        tabLayout = findViewById(R.id.tabs);
        iotalk = findViewById(R.id.textViewIOTalkChatScreen);
        searchBar = findViewById(R.id.editTextSearchChatScreen);
        backIcon = findViewById(R.id.imageViewBackButton);
        linearLayout = findViewById(R.id.selectedChatScreenActionBar);
        linearLayout1 = findViewById(R.id.linearLayout3ChatScreen);
        backIconCAB = findViewById(R.id.imageViewBackArrow);
        pinIcon = findViewById(R.id.pushPinIconImageView);
        muteIcon = findViewById(R.id.muteIconImageView);
        archiveIcon = findViewById(R.id.archiveIconImageView);
        optionsIconCAB = findViewById(R.id.settingsIconImageView);


//        tabLayout.setupWithViewPager(viewPager);



        userList = new ArrayList<>();
        userList.add(new User(" Anushka"));
        userList.add(new User("Srishti"));
        userList.add(new User("Garima"));


        recyclerView = findViewById(R.id.chatlistchatrecycler);
        Object1 = new RecyclerAdapterChatList(this,userList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(Object1);




//

        optionsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(ChatList.this, optionsIcon);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.show();//showing popup menu
            }
        });


        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabLayout.setVisibility(View.GONE);
                iotalk.setVisibility(View.GONE);
                searchIcon.setVisibility(View.GONE);
                optionsIcon.setVisibility(View.GONE);
                searchBar.setVisibility(View.VISIBLE);
                backIcon.setVisibility(View.VISIBLE);


//                Object.filter(text);
                backIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tabLayout.setVisibility(View.VISIBLE);
                        iotalk.setVisibility(View.VISIBLE);
                        searchIcon.setVisibility(View.VISIBLE);
                        optionsIcon.setVisibility(View.VISIBLE);
                        searchBar.setVisibility(View.GONE);

                       onBackPressed();

                    }
                });

            }
        });



        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        newChatButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatList.this, NewChatButton.class);
                startActivity(intent);
                finish();
            }
        });


    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, ChatList.class);
        startActivity(intent);
        finish();
    }

    public void filter(String text)
    {

        Log.i("searchboxtext",text);
         List<User> filteredList = new ArrayList<>();
        for(User user : userList)
        {
            if(user.getUserName().toLowerCase().contains(text.toLowerCase()))
            {
                Log.i("ifblocklist",user.getUserName());
                filteredList.add(user);
            }
        }

        Object1.updateList(filteredList);

    }

    public  void openChat(String messagesenderUID)
    {
        Intent intent = new Intent(ChatList.this , Chat.class);
        intent.putExtra("MessageSenderUid",messagesenderUID);
        startActivity(intent);
        finish();
    }
    public static void layoutVisible()
    {
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout1.setVisibility(View.GONE);
        backIconCAB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {




            }
        });
        pinIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });
        muteIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

            }
        });
        archiveIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        optionsIconCAB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

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


