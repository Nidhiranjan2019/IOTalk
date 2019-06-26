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


public class RecyclerAdapterChatList extends RecyclerView.Adapter<RecyclerAdapterChatList.ViewHolderChatScreen> {
    private List<ChatList> chatpeopleList;

//    public void filter(String text) {
//        text = text.toLowerCase();
//        chatpeopleList.clear();
//        if (text.length() == 0) {
//            worldpopulationlist.addAll(arraylist);
//        }
//        else
//        {
//            for (WorldPopulation wp : arraylist)
//            {
//                if (wp.getCountry().toLowerCase().contains(charText))
//                {
//                    worldpopulationlist.add(wp);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }


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
    public RecyclerAdapterChatList(List<ChatList> chatList)
    {
        this.chatpeopleList = chatList;
    }
    @NonNull
    @Override
    public ViewHolderChatScreen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        if
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chatrecyclerview,viewGroup,false);
        return new ViewHolderChatScreen(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderChatScreen viewHolder, int i) {
//        ChatList chatpeople = chatpeopleList.get(i);
//        viewHolder. textViewTimeOfMessage.setText(chatpeople.getTextViewTimeOfMessage());
//        viewHolder.chatListName.setText(chatpeople.getChatListName());
//        viewHolder.textViewNoOfUnseenMessages.setText(chatpeople.getTextViewNoOfUnseenMessages());

    }

    @Override
    public int getItemCount() {
return 1;
//        return chatpeopleList.size();
    }

}

