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


public class RecyclerAdapterPersonalText1 extends RecyclerView.Adapter<RecyclerAdapterPersonalText1.ViewHolderText> {
    private List<PersonalText> personalTextList ;


    public class ViewHolderText extends RecyclerView.ViewHolder {
        public TextView messagebodyMyMessage1;
        public TextView textViewTimeMyMessage1;


        public ViewHolderText(@NonNull View itemView) {
            super(itemView);

            messagebodyMyMessage1 = itemView.findViewById(R.id.messagebodyMyMessage1);
            textViewTimeMyMessage1 = itemView.findViewById(R.id.textViewTimeMyMessage1);
        }
    }
    public RecyclerAdapterPersonalText1(List<PersonalText> personalTextList) {
        this.personalTextList = personalTextList;
    }
    @NonNull
    @Override
    public ViewHolderText onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_message1,viewGroup,false);
        return new ViewHolderText(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderText viewHolder, int i) {
        PersonalText personalText = personalTextList.get(i);
        viewHolder. textViewTimeMyMessage1.setText(personalText.getTimeOfMessage());
        viewHolder.messagebodyMyMessage1.setText(personalText.getMessage());
    }

    @Override
    public int getItemCount() {

        return personalTextList.size();
    }

}

