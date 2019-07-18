package in.codepredators.delta.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.codepredators.delta.R;


public class RecyclerAdapterCode extends RecyclerView.Adapter<RecyclerAdapterCode.ViewHolderCode> {
    private List<User> userList;
    private Context context;


    public class ViewHolderCode extends RecyclerView.ViewHolder {
        public TextView codeMessageSender;
        public View codeProfilePic;
        public TextView codeMessageReceiver;
        public ImageView codeArrowimageView;
        public TextView codeMessagetextView;
        public TextView codeTimeOfMessagetextView;



        public ViewHolderCode(@NonNull View itemView) {
            super(itemView);

            codeMessageSender = itemView.findViewById(R.id.codeMessageSender);
            codeArrowimageView = itemView.findViewById(R.id.codeArrowimageView);
            codeProfilePic = itemView.findViewById(R.id.codeProfilePic);
            codeMessageReceiver = itemView.findViewById(R.id.StarredMessagesMessageReceiver);
            codeMessagetextView = itemView.findViewById(R.id.codeMessagetextView);
            codeTimeOfMessagetextView = itemView.findViewById(R.id.codeTimeOfMessagetextView);;

        }
    }
    public RecyclerAdapterCode(Context context  , List<User> userList) {

        this.context = context;
        this.userList = userList;
    }
    @NonNull
    @Override
    public ViewHolderCode onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coderecyclerview,viewGroup,false);
        return new ViewHolderCode(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCode viewHolder, int i) {
        User user = userList.get(i);
//        viewHolder. codeMessageSender.setText(user.getcodeMessageSender());
//        viewHolder.codeMessageReceiver.setText(user.getcodeMessageReceiver());
////        viewHolder.codeMessagetextView.setText(user.getUserCode()); //doubt how to get 1st string element from hashmap of UserCode
//        viewHolder.codeTimeOfMessagetextView.setText(user.getcodeTimeOfMessagetextView());

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

