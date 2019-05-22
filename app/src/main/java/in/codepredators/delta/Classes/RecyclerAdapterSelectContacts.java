package in.codepredators.delta.Classes;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.codepredators.delta.R;


public class RecyclerAdapterSelectContacts extends RecyclerView.Adapter<RecyclerAdapterSelectContacts.ViewHolderContacts> {
    private List<ContactSelect> contactList;


    public class ViewHolderContacts extends RecyclerView.ViewHolder {
        public TextView selectContactsName;
        public ImageView selectContactsProfilePic;
        public TextView selectContactsPhoneNo;
        public TextView selectContactsStatus;


        public ViewHolderContacts(@NonNull View itemView) {
            super(itemView);

            selectContactsStatus = itemView.findViewById(R.id.selectContactsStatus);
            selectContactsPhoneNo = itemView.findViewById(R.id.selectContactsPhoneNo);
            selectContactsStatus = itemView.findViewById(R.id.selectContactsStatus);
            selectContactsProfilePic = itemView.findViewById(R.id.selectContactsProfilePic);

        }
    }
    public RecyclerAdapterSelectContacts(List<ContactSelect> contactList) {
        this.contactList = contactList;
    }
    @NonNull
    @Override
    public ViewHolderContacts onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.selectcontactsrecyclerview,viewGroup,false);
        return new ViewHolderContacts(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderContacts viewHolder, int i) {
        ContactSelect contactselect = contactList.get(i);
        viewHolder. selectContactsName.setText(contactselect.getSelectContactsName());
        viewHolder. selectContactsPhoneNo.setText(contactselect.getSelectContactsPhoneNo());
        viewHolder. selectContactsStatus.setText(contactselect.getSelectContactsStatus());
    }

    @Override
    public int getItemCount() {

        return contactList.size();
    }

}

