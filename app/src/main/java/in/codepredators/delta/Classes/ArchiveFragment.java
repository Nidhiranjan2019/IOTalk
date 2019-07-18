package in.codepredators.delta.Classes;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.codepredators.delta.Activities.ChatList;
import in.codepredators.delta.R;

public class ArchiveFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    List<User> userList;
    static RecyclerAdapterArchiveList Object1;
    public User Obj = new User();

    public ArchiveFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        userList = new ArrayList<>();

        userList.add(new User("Anushka"));
        userList.add(new User("Anushka"));
        userList.add(new User("Anushka"));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.chatlistchatrecycler, container, false);
        recyclerView= v.findViewById(R.id.viewpagerChatRecycler);
        Object1 = new RecyclerAdapterArchiveList(getContext(),userList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(Object1);
        return v;
    }


}
