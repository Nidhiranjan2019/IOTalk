package in.codepredators.delta.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.codepredators.delta.R;


public class RecyclerAdapterChatScreen extends RecyclerView.Adapter<RecyclerAdapterChatScreen.ViewHolderChatScreen> {
    private List<ChatScreen> chatpeopleList;


    public class ViewHolderChatScreen extends RecyclerView.ViewHolder {
        public TextView textViewTimeOfMessage;
        public TextView chatListName;
        public View chatListProfilePic;
        public ImageView imageViewAttachIcon;
        public TextView textViewNoOfUnseenMessages;


        public ViewHolderChatScreen(@NonNull View itemView) {
            super(itemView);

            textViewTimeOfMessage = itemView.findViewById(R.id.textViewTimeOfMessage);
            chatListName = itemView.findViewById(R.id.chatListName);
            chatListProfilePic = itemView.findViewById(R.id.chatListProfilePic);
            imageViewAttachIcon = itemView.findViewById(R.id.imageViewAttachIcon);
            textViewNoOfUnseenMessages = itemView.findViewById(R.id.textViewNoOfUnseenMessages);

        }
    }
    public RecyclerAdapterChatScreen(List<ChatScreen> chatList) {
        this.chatpeopleList = chatList;
    }
    @NonNull
    @Override
    public ViewHolderChatScreen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chatrecyclerview,viewGroup,false);
        return new ViewHolderChatScreen(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderChatScreen viewHolder, int i) {
        ChatScreen chatpeople = chatpeopleList.get(i);
        viewHolder. textViewTimeOfMessage.setText(chatpeople.getTextViewTimeOfMessage());
        viewHolder.chatListName.setText(chatpeople.getChatListName());
        viewHolder.textViewNoOfUnseenMessages.setText(chatpeople.getTextViewNoOfUnseenMessages());

    }

    @Override
    public int getItemCount() {

        return chatpeopleList.size();
    }

}

