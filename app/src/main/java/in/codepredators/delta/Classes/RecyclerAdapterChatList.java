package in.codepredators.delta.Classes;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import in.codepredators.delta.Activities.Chat;
import in.codepredators.delta.Activities.ChatList;
import in.codepredators.delta.Activities.NewGroupFormation;
import in.codepredators.delta.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static in.codepredators.delta.Activities.ChatList.layoutVisible;


public class RecyclerAdapterChatList extends RecyclerView.Adapter<RecyclerAdapterChatList.ViewHolderChatScreen> {
    private List<User> userList;
    private  Context context;


    public class ViewHolderChatScreen extends RecyclerView.ViewHolder {
        public TextView textViewTimeOfMessage;
        public TextView chatListName;
        public View chatListProfilePic;
        public ImageView imageViewAttachIcon;
        public TextView textViewNoOfUnseenMessages;
        public View profilePic;





        public ViewHolderChatScreen(@NonNull View itemView) {
            super(itemView);

            textViewTimeOfMessage = itemView.findViewById(R.id.textViewTimeOfMessage);
            chatListName = itemView.findViewById(R.id.chatListName);
            chatListProfilePic = itemView.findViewById(R.id.chatListProfilePic);
            imageViewAttachIcon = itemView.findViewById(R.id.imageViewAttachIcon);
            textViewNoOfUnseenMessages = itemView.findViewById(R.id.textViewNoOfUnseenMessages);
            profilePic=itemView.findViewById(R.id.chatListProfilePic);

        }
    }
    public RecyclerAdapterChatList(Context context ,List<User> userList)
    {
        this.context=context;
        this.userList = userList;
    }
    public void updateList(List<User> updatedList)
    {
        userList = updatedList;
        notifyDataSetChanged();
    }
    public ViewGroup viewGroup1;
    @NonNull
    @Override
    public ViewHolderChatScreen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        viewGroup1 = viewGroup;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chatrecyclerview,viewGroup,false);
        return new ViewHolderChatScreen(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderChatScreen viewHolder, int i) {

        viewHolder.profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loadPhoto();

            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String messagesenderUID = "getMessagesenderUID()";
                ((ChatList)context).openChat(messagesenderUID);

            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                layoutVisible();


                return true;
            }}
        );




        User user = userList.get(i);
        viewHolder.chatListName.setText(user.getUserName());
//        viewHolder.textViewTimeOfMessage.setText(user.getTextViewTimeOfMessage());

//        viewHolder.textViewNoOfUnseenMessages.setText(user.getTextViewNoOfUnseenMessages());

    }

    @Override
    public int getItemCount() {
//        return 1;
        return userList.size();
    }
    private void loadPhoto()
    {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = (View) inflater.inflate(R.layout.profilepicture_popup,viewGroup1,false);
        ImageView image = (ImageView) layout.findViewById(R.id.viewProfilePicPopup1);
        image.requestLayout();
        dialog.setContentView(layout);
        dialog.show();

    }



}

