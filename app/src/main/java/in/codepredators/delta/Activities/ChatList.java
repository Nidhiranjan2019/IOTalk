package in.codepredators.delta.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;

import java.util.List;
import java.util.Locale;

import in.codepredators.delta.Classes.Message;
import in.codepredators.delta.Classes.PersonalMessage;
import in.codepredators.delta.Classes.RecyclerAdapterChatList;
import in.codepredators.delta.Classes.RecyclerAdapterSelectContacts;
import in.codepredators.delta.R;

public class ChatList extends AppCompatActivity {
    private ImageView searchIcon;
    private ImageView backIcon;
    private ImageView optionsIcon;
    private TextView chats;
    private TextView archives;
    private TextView code;
    private FloatingActionButton newChatButton;
    private RecyclerView recyclerView;
    private EditText searchBar;
    DatabaseReference mChatMessagesDb;
    PersonalMessage personalMessage= new PersonalMessage();
    Message messages= new Message();
    static RecyclerAdapterChatList Object;
    List<in.codepredators.delta.Classes.ChatList> chatList;
    private TextView iotalk;
    private TabLayout tabLayout;

//    public int listSize = Object.getItemCount();




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iotalkactivity_chatscreen);
        searchIcon = findViewById(R.id.viewSearchChatScreen);
        optionsIcon = findViewById(R.id.viewSettingsChatScreen);
        newChatButton = findViewById(R.id.floatingActionNewChat);
//        mChatMessagesDb = FirebaseDatabase.getInstance().getReference().child("personalMessage").child(personalMessage.getPID()).child("messages");
//        recyclerView = findViewById(R.id.chatlistchatrecycler);
        tabLayout=findViewById(R.id.tabs);
        iotalk=findViewById(R.id.textViewIOTalkChatScreen);
        searchBar=findViewById(R.id.editTextSearchChatScreen);
        backIcon=findViewById(R.id.imageViewBackButton);


//
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        Object = new RecyclerAdapterChatList(chatList);
//        recyclerView.setAdapter(Object);

        optionsIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(ChatList.this, optionsIcon);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.show();//showing popup menu
            }
        });






        searchIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tabLayout.setVisibility(View.GONE);
                iotalk.setVisibility(View.GONE);
                searchIcon.setVisibility(View.GONE);
                optionsIcon.setVisibility(View.GONE);
                searchBar.setVisibility(View.VISIBLE);
                backIcon.setVisibility(View.VISIBLE);

                String text = searchBar.getText().toString().toLowerCase();
//                Object.filter(text);

            }
        });

        newChatButton.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ChatList.this , NewChatButton.class);
                startActivity(intent);
                finish();
            }
        });





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
}