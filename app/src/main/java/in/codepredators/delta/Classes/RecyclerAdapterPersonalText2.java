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


public class RecyclerAdapterPersonalText2 extends RecyclerView.Adapter<RecyclerAdapterPersonalText2.ViewHolderText2> {
    private List<PersonalText> personalTextList ;


    public class ViewHolderText2 extends RecyclerView.ViewHolder {
        public TextView messagebodyMyMessage2;
        public TextView textViewTimeMyMessage2;


        public ViewHolderText2(@NonNull View itemView) {
            super(itemView);

            messagebodyMyMessage2= itemView.findViewById(R.id.messagebodyMyMessage2);
            textViewTimeMyMessage2 = itemView.findViewById(R.id.textViewTimeMyMessage2);
        }
    }
    public RecyclerAdapterPersonalText2(List<PersonalText> personalTextList) {
        this.personalTextList = personalTextList;
    }
    @NonNull
    @Override
    public ViewHolderText2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_message2,viewGroup,false);
        return new ViewHolderText2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderText2 viewHolder, int i) {
        PersonalText personalText = personalTextList.get(i);
        viewHolder. messagebodyMyMessage2.setText(personalText.getMessage());
        viewHolder.textViewTimeMyMessage2.setText(personalText.getTimeOfMessage());
    }

    @Override
    public int getItemCount() {

        return personalTextList.size();
    }

}

