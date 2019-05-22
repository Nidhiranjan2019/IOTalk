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


public class RecyclerAdapterStarredMessages extends RecyclerView.Adapter<RecyclerAdapterStarredMessages.ViewHolderStarredMessages> {
    private List<Starredmessage> starredmessageList;


    public class ViewHolderStarredMessages extends RecyclerView.ViewHolder {
        public TextView StarredMessagesMessageSender;
        public ImageView imageViewArrowStarredMessages;
        public View StarredMessagesProfilePic;
        public TextView StarredMessagesMessageReceiver;
        public ImageView StarredMessagesForwardimageView;
        public TextView StarredMessagesDatetextView;
        public TextView StarredMessagesMessagetextView;
        public ImageView StarredMessagesStarimageView;
        public TextView StarredMessagesTimetextView;



        public ViewHolderStarredMessages(@NonNull View itemView) {
            super(itemView);

            StarredMessagesMessageSender = itemView.findViewById(R.id.StarredMessagesMessageSender);
            StarredMessagesProfilePic = itemView.findViewById(R.id.StarredMessagesProfilePic);
            imageViewArrowStarredMessages = itemView.findViewById(R.id.imageViewArrowStarredMessages);
            StarredMessagesMessageReceiver = itemView.findViewById(R.id.StarredMessagesMessageReceiver);
            StarredMessagesForwardimageView = itemView.findViewById(R.id.StarredMessagesForwardimageView);
            StarredMessagesDatetextView = itemView.findViewById(R.id.StarredMessagesDatetextView);
            StarredMessagesMessagetextView = itemView.findViewById(R.id.StarredMessagesMessagetextView);
            StarredMessagesStarimageView = itemView.findViewById(R.id.StarredMessagesStarimageView);
            StarredMessagesTimetextView = itemView.findViewById(R.id.StarredMessagesTimetextView);

        }
    }
    public RecyclerAdapterStarredMessages(List<Starredmessage> starredmessageList) {
        this.starredmessageList = starredmessageList;
    }
    @NonNull
    @Override
    public ViewHolderStarredMessages onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.starredmessagesrecyclerview,viewGroup,false);
        return new ViewHolderStarredMessages(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderStarredMessages viewHolder, int i) {
        Starredmessage starredmessage = starredmessageList.get(i);
        viewHolder. StarredMessagesMessageSender.setText(starredmessage.getStarredMessagesMessageSender());
        viewHolder.StarredMessagesMessageReceiver.setText(starredmessage.getStarredMessagesMessageReceiver());
        viewHolder.StarredMessagesDatetextView.setText(starredmessage.getStarredMessagesDatetextView());
        viewHolder.StarredMessagesMessagetextView.setText(starredmessage.getStarredMessagesMessagetextView());
        viewHolder.StarredMessagesTimetextView.setText(starredmessage.getStarredMessagesTimetextView());

    }

    @Override
    public int getItemCount() {

        return starredmessageList.size();
    }

}

