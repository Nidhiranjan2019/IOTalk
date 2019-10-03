package in.codepredators.delta.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.signature.MediaStoreSignature;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import in.codepredators.delta.Activities.ChatList;
import in.codepredators.delta.Classes.Message;
import in.codepredators.delta.Classes.PersonalMessage;
import in.codepredators.delta.Classes.RecyclerAdapterChatList;
import in.codepredators.delta.Classes.User;
import in.codepredators.delta.R;

public class ChatFragment extends Fragment {

    RecyclerView recyclerView;
    FirebaseAuth mAuth;
    List<ChatList.ChatListItem> chatListItemList;
    RecyclerAdapterChatList recyclerAdapterChatList ;
    @Override
    public void onStart() {
        super.onStart();
        chatListItemList = new ArrayList<>();
        Log.i("on","start");
        ChatList.ChatListItem chatListItem = new ChatList.ChatListItem();
        User user = new User();
        Message message  = new Message();
        user.setUserName("Anushka");
        message.setMessageTime("12:00");
        chatListItem.setUser(user);
        chatListItem.setMessage(message);
        chatListItemList.add(chatListItem);
        chatListItemList.add(chatListItem);
        recyclerView = getView().findViewById(R.id.viewpagerChatRecycler);
        LinearLayoutManager mlayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerAdapterChatList = new RecyclerAdapterChatList(getActivity().getApplicationContext() , chatListItemList);
        recyclerView.setAdapter(recyclerAdapterChatList);
        Log.i("value of recycler", String.valueOf(recyclerAdapterChatList.getItemCount()));


        //TODO first you have to assign variables here and than you can use setonclicklistener in onstart
        showChatList();
    }
    void showChatList() {


        final ChatList.ChatListItem[] chatListItem = new ChatList.ChatListItem[1];
        mAuth = FirebaseAuth.getInstance();
//        final String UID = mAuth.getCurrentUser().getUid();
        final String UID = "MeINhuTy1oYhjiM81QIbzZFhqup1";
        final String userNumber = FirebaseDatabase.getInstance().getReference().child("users").child(UID).child("userNumber").getKey();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference().child("personalMessage");


        // Attach a listener to read the data at our posts reference
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.i("The read is successful", "Here!");
                String tt = dataSnapshot.child("pid").getKey();
                Log.i("The read ",tt);
                DataSnapshot rr = dataSnapshot.child("pid");
                Log.i("The read is successful1", "Here!");
                String value = dataSnapshot.child("pid").getValue(String.class);
                Log.i("The read is successful", value);
                long msgNo = dataSnapshot.child("messages").getChildrenCount();



//                for(DataSnapshot child : dataSnapshot.getChildren()) {
                String pID[] = new String[2];
                pID[0] = value.substring(2, 12);
                pID[1] = value.substring(12, 22);
                if (pID[0].equals(userNumber) || pID[1].equals(userNumber)) {
                    User user = new User();
                    PersonalMessage personalMessage = new PersonalMessage();
                    chatListItem[0] = new ChatList.ChatListItem();
                    chatListItem[0].setArchive(false);
                    chatListItem[0].setPinStatus(false);


                    personalMessage.setPID(value);
                    String userOneID = dataSnapshot.child("personalUserOne").getKey();
                    String userTwoID = dataSnapshot.child("personalUserTwo").getKey();
                    personalMessage.setPersonalUserOne(userOneID);
                    personalMessage.setPersonalUserTwo(userTwoID);
//                         chatListItem.personalMessage.setPersonalUserOneStatus();
//                         chatListItem.personalMessage.setPersonalUserTwoStatus();

                    chatListItem[0].setPersonalMessage(personalMessage);


                    String otherPersonID;
                    if (userOneID.equals(UID)) {
                        user.setUID(userTwoID);
                        otherPersonID = userTwoID;
                    } else {
                        otherPersonID = userOneID;
                    }
                    user.setUID(otherPersonID);
                    user.setUserName(FirebaseDatabase.getInstance().getReference().child("users").child(otherPersonID).child("userName").getKey());
                    user.setUserNumber(FirebaseDatabase.getInstance().getReference().child("users").child(otherPersonID).child("userNumber").getKey());
                    user.setUserBio(FirebaseDatabase.getInstance().getReference().child("users").child(otherPersonID).child("userBio").getKey());
                    user.setUserCountry("India");
                    user.setUserProfilePic(FirebaseDatabase.getInstance().getReference().child("users").child(otherPersonID).child("userProfilePic").getKey());

                    chatListItem[0].setUser(user);
                    chatListItemList.add(chatListItem[0]);
//                    final Query lastChild = FirebaseDatabase.getInstance().getReference().child("personalMessage").child(value).child("messages").orderByKey().limitToLast(1);
//                    lastChild.addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
//                            Message message = new Message();
//                            message.setMessageTime(dataSnapshot1.child("messageTime").getKey());
//                            chatListItem[0].setMessage(message);
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError1) {
//
//                        }
//                    });
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
        });


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_chatlist,container,false);
        Log.i("on","create");
        return rootView;


    }
}
