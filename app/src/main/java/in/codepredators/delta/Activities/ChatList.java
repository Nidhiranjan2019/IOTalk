package in.codepredators.delta.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import in.codepredators.delta.R;

public class ChatList extends AppCompatActivity {
    private ImageView searchIcon;
    private ImageView optionsIcon;
    private TextView chats;
    private TextView archives;
    private TextView code;
    private FloatingActionButton newChatButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatscreen);
        searchIcon = findViewById(R.id.viewSearchChatScreen);
        optionsIcon = findViewById(R.id.viewSettingsChatScreen);
        chats = findViewById(R.id.chatsChatScreen);
        archives = findViewById(R.id.archivesChatScreen);
        code = findViewById(R.id.codeChatScreen);
        newChatButton = findViewById(R.id.floatingActionNewChat);

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

        //Progress bar code when Garima finishes it.

        searchIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               //Complete this!
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




}}