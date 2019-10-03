package in.codepredators.delta.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import in.codepredators.delta.R;

public class ArchiveFragment extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity().getApplicationContext(),"archive fragment",Toast.LENGTH_SHORT).show();
        //TODO first you have to assign variables here and than you can use setonclicklistener in onstart
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_chatlist,container,false);
        return rootView;
    }
}
