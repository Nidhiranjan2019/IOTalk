package in.codepredators.delta.Classes;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterUserList extends  RecyclerView.Adapter<ViewHolderUserList> {
    ArrayList<User> userList;

    public RecyclerAdapterUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolderUserList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUserList holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
