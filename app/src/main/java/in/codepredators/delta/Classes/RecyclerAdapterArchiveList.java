package in.codepredators.delta.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.codepredators.delta.R;


public class RecyclerAdapterArchiveList extends RecyclerView.Adapter<RecyclerAdapterArchiveList.ViewHolderArchive> {
    private List<User> userList;
    private Context context;



    public class ViewHolderArchive extends RecyclerView.ViewHolder {
        public TextView chatListName;
        public ImageView chatListProfilePic;
        public TextView textViewTimeOfMessage;
        public ImageView imageViewAttachIcon;
        public TextView textViewNoOfUnseenMessages;
        public ImageView chatListTickImageView;


        public ViewHolderArchive(@NonNull View itemView) {
            super(itemView);

            chatListName = itemView.findViewById(R.id.chatListName);
            chatListProfilePic = itemView.findViewById(R.id.chatListProfilePic);
            textViewTimeOfMessage = itemView.findViewById(R.id.textViewTimeOfMessage);
            imageViewAttachIcon=itemView.findViewById(R.id.imageViewAttachIcon);
            textViewNoOfUnseenMessages=itemView.findViewById(R.id.textViewNoOfUnseenMessages);
            chatListTickImageView=itemView.findViewById(R.id.chatListTickImageView);
            imageViewAttachIcon.setVisibility(View.INVISIBLE);
            textViewNoOfUnseenMessages.setVisibility(View.INVISIBLE);
            chatListTickImageView.setVisibility(View.INVISIBLE);


        }
    }
    public RecyclerAdapterArchiveList(Context context , List<User> userList) {

        this.context= context;
        this.userList = userList;
    }
    @NonNull
    @Override
    public ViewHolderArchive onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chatrecyclerview,viewGroup,false);
        return new ViewHolderArchive(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArchive viewHolder, int i) {
        User user = userList.get(i);
        viewHolder. chatListName.setText(user.getUserName());

    }

    @Override
    public int getItemCount() {

        return 1;
//        return userList.size();
    }

    public void updateList(List<User> updatedList)
    {
        userList = updatedList;
        notifyDataSetChanged();
    }
}

