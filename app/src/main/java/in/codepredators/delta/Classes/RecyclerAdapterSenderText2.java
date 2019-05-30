package in.codepredators.delta.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.codepredators.delta.R;


public class RecyclerAdapterSenderText2 extends RecyclerView.Adapter<RecyclerAdapterSenderText2.ViewHolderText> {
    private List<PersonalText> personalText2List ;


    public class ViewHolderText extends RecyclerView.ViewHolder {
        public TextView messagebodyTheirMessage2;
        public TextView textViewTimeTheirMessage2;


        public ViewHolderText(@NonNull View itemView) {
            super(itemView);

            messagebodyTheirMessage2 = itemView.findViewById(R.id.messagebodyTheirMessage2);
            textViewTimeTheirMessage2 = itemView.findViewById(R.id.textViewTimeTheirMessage2);
        }
    }
    public RecyclerAdapterSenderText2(List<PersonalText> personalText2List) {
        this.personalText2List = personalText2List;
    }
    @NonNull
    @Override
    public ViewHolderText onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.their_message2,viewGroup,false);
        return new ViewHolderText(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderText viewHolder, int i) {
        PersonalText personalText2 = personalText2List.get(i);
        viewHolder. messagebodyTheirMessage2.setText(personalText2.getMessage());
        viewHolder.textViewTimeTheirMessage2.setText(personalText2.getTimeOfMessage());
    }

    @Override
    public int getItemCount() {

        return personalText2List.size();
    }

}

