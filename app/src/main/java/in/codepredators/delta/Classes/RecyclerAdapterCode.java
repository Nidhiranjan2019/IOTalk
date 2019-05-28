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


public class RecyclerAdapterCode extends RecyclerView.Adapter<RecyclerAdapterCode.ViewHolderCode> {
    private List<Code> codeList;


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
    public RecyclerAdapterCode(List<Code> codeList) {
        this.codeList = codeList;
    }
    @NonNull
    @Override
    public ViewHolderCode onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coderecyclerview,viewGroup,false);
        return new ViewHolderCode(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCode viewHolder, int i) {
        Code code = codeList.get(i);
        viewHolder. codeMessageSender.setText(code.getcodeMessageSender());
        viewHolder.codeMessageReceiver.setText(code.getcodeMessageReceiver());
        viewHolder.codeMessagetextView.setText(code.getcodeMessagetextView());
        viewHolder.codeTimeOfMessagetextView.setText(code.getcodeTimeOfMessagetextView());

    }

    @Override
    public int getItemCount() {

        return codeList.size();
    }

}

