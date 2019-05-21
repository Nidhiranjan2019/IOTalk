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


public class RecyclerAdapterCodeLanguages extends RecyclerView.Adapter<RecyclerAdapterCodeLanguages.ViewHolderCodeLanguages> {
    private List<Codelanguages> languageList;


    public class ViewHolderCodeLanguages extends RecyclerView.ViewHolder {
        public TextView codeLanguageEnter;
        public ImageView codeLanguageCheckboximageView;


        public ViewHolderCodeLanguages(@NonNull View itemView) {
            super(itemView);

            codeLanguageEnter = itemView.findViewById(R.id.codeLanguageEnter);
            codeLanguageCheckboximageView = itemView.findViewById(R.id.codeLanguageCheckboximageView);

        }
    }
    public RecyclerAdapterCodeLanguages(List<Codelanguages> languageList) {
        this.languageList = languageList;
    }
    @NonNull
    @Override
    public ViewHolderCodeLanguages onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.codelanguagesrecyclerview,viewGroup,false);
        return new ViewHolderCodeLanguages(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCodeLanguages viewHolder, int i) {
        Codelanguages codelanguages = languageList.get(i);
        viewHolder. codeLanguageEnter.setText(codelanguages.getCodeLanguageEnter());

    }

    @Override
    public int getItemCount() {

        return languageList.size();
    }

}

