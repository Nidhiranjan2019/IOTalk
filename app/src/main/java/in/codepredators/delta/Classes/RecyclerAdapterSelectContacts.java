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
    private static List<User> contactList;
    private static List<User> selectedContacts;


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
    public RecyclerAdapterSelectContacts(List<User> contactList) {
        this.contactList = contactList;
    }
    @NonNull
    @Override
    public ViewHolderContacts onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.selectcontactsrecyclerview,viewGroup,false);
        return new ViewHolderContacts(view);
    }
    public void updateList(List<User> updatedList)
    {
        contactList = updatedList;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderContacts viewHolder, int i) {
        final User contactselect = contactList.get(i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }


        });

        viewHolder. selectContactsName.setText(contactselect.getUserName());
        viewHolder. selectContactsPhoneNo.setText(contactselect.getUserNumber());
        viewHolder. selectContactsStatus.setText(contactselect.getUserBio());
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setSelectedContacts(contactselect);
                return false;
            }

            });


    }


    @Override
    public int getItemCount() {

        return contactList.size();
    }
    public void setSelectedContacts(User user)
    {
        selectedContacts.add(user);
    }



}

