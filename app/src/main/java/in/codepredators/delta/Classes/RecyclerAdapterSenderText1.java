package in.codepredators.delta.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.codepredators.delta.R;


public class RecyclerAdapterSenderText1 extends RecyclerView.Adapter<RecyclerAdapterSenderText1.ViewHolderText> {
    private List<PersonalText> personalText2List ;


    public class ViewHolderText extends RecyclerView.ViewHolder {
        public TextView messagebodyTheirMessage1;
        public TextView textViewTimeTheirMessage1;


        public ViewHolderText(@NonNull View itemView) {
            super(itemView);

            messagebodyTheirMessage1 = itemView.findViewById(R.id.messagebodyTheirMessage1);
            textViewTimeTheirMessage1 = itemView.findViewById(R.id.textViewTimeTheirMessage1);
        }
    }
    public RecyclerAdapterSenderText1(List<PersonalText> personalText2List) {
        this.personalText2List = personalText2List;
    }
    @NonNull
    @Override
    public ViewHolderText onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.their_message1,viewGroup,false);
        return new ViewHolderText(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderText viewHolder, int i) {
        PersonalText personalText2 = personalText2List.get(i);
        viewHolder. messagebodyTheirMessage1.setText(personalText2.getMessage());
        viewHolder.textViewTimeTheirMessage1.setText(personalText2.getTimeOfMessage());
    }

    @Override
    public int getItemCount() {

        return personalText2List.size();
    }

}

