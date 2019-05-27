package in.codepredators.delta.Activities;//package in.codepredators.delta.Activities;
//
//import android.os.Bundle;
//import android.widget.LinearLayout;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;

import in.codepredators.delta.Classes.User;
import in.codepredators.delta.R;

public class ChatList extends AppCompatActivity {
    private RecyclerView mUserList;
    private RecyclerView.Adapter mUserListAdapter;
    private RecyclerView.LayoutManager mUserListLayoutManager;
    ArrayList<User> userList ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iotalkactivity_chatlist);
        System.out.println("hello");

    }}

//private void initializeRecyclerView()
//{
//    mUserList = findViewById(R.id.userList);
//    mUserList.setNestedScrollingEnabled(false);
//    mUserList.setHasFixedSize(false);
//    mUserListLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL,false);
//    mUserList.setLayoutManager(mUserListLayoutManager);
//    mUserListAdapter = new RecyclerAdapterUserList(userList);
//    mUserList.setAdapter(mUserListAdapter);
//
//
//
//}}