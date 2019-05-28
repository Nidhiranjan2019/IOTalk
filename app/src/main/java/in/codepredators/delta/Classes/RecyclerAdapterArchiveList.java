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


public class RecyclerAdapterArchiveList extends RecyclerView.Adapter<RecyclerAdapterArchiveList.ViewHolderArchive> {
    private List<ArchiveList> archivepeopleList;


    public class ViewHolderArchive extends RecyclerView.ViewHolder {
        public TextView archiveListName;
        public ImageView archiveListProfilePic;
        public TextView textViewTimeOfMessageArchiveList;


        public ViewHolderArchive(@NonNull View itemView) {
            super(itemView);

            archiveListName = itemView.findViewById(R.id.archiveListName);
            archiveListProfilePic = itemView.findViewById(R.id.archiveListProfilePic);
            textViewTimeOfMessageArchiveList = itemView.findViewById(R.id.textViewTimeOfMessageArchiveList);

        }
    }
    public RecyclerAdapterArchiveList(List<ArchiveList> archivepeopleList) {
        this.archivepeopleList = archivepeopleList;
    }
    @NonNull
    @Override
    public ViewHolderArchive onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.archiverecyclerview,viewGroup,false);
        return new ViewHolderArchive(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArchive viewHolder, int i) {
        ArchiveList archivepeople = archivepeopleList.get(i);
        viewHolder. archiveListName.setText(archivepeople.getArchiveListName());
        viewHolder.textViewTimeOfMessageArchiveList.setText(archivepeople.getTextViewTimeOfMessageArchiveList());

    }

    @Override
    public int getItemCount() {

        return archivepeopleList.size();
    }

}

