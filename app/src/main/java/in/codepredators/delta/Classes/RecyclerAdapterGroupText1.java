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


public class RecyclerAdapterGroupText1 extends RecyclerView.Adapter<RecyclerAdapterGroupText1.ViewHolderText> {
    private List<GroupText> groupTextList ;


    public class ViewHolderText extends RecyclerView.ViewHolder {
        public TextView nameGroupMessage;
        public TextView messagebodyGroupMessage;
        public TextView textViewTimeGroupMessage;
           public ImageView imageViewStarGroupMessage;
        public View viewColourGroupMessage;


        public ViewHolderText(@NonNull View itemView) {
            super(itemView);

            nameGroupMessage = itemView.findViewById(R.id.nameGroupMessage);
            messagebodyGroupMessage = itemView.findViewById(R.id.messagebodyGroupMessage);
            textViewTimeGroupMessage=itemView.findViewById(R.id.textViewTimeGroupMessage);
imageViewStarGroupMessage=itemView.findViewById(R.id.viewColourGroupMessage);
            viewColourGroupMessage=itemView.findViewById(R.id.viewColourGroupMessage);
        }
    }
    public RecyclerAdapterGroupText1(List<GroupText> groupTextList) {
        this.groupTextList=groupTextList;
    }
    @NonNull
    @Override
    public ViewHolderText onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grouptheir_message2,viewGroup,false);
        return new ViewHolderText(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderText viewHolder, int i) {
        GroupText groupText = groupTextList.get(i);
        viewHolder. nameGroupMessage.setText(groupText.getNameGroupMessage());
        viewHolder.messagebodyGroupMessage.setText(groupText.getMessage());
        viewHolder.textViewTimeGroupMessage.setText(groupText.getTime());
    }

    @Override
    public int getItemCount() {

        return groupTextList.size();
    }

}

