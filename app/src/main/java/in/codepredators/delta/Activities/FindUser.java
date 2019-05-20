package in.codepredators.delta.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import in.codepredators.delta.R;

public class FindUser extends AppCompatActivity {
    private RecyclerView mUserList;
    private RecyclerView.Adapter mUserListAdapter;
    private RecyclerView.LayoutManager mUserListLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
//        initializeRecyclerView();

    }}

//private void initializeRecyclerView()
//{
//    mUserList = findViewById(R.id.);
//    mUserList.setNestedScrollingEnabled(false);
//
//
//}}