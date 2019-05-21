package in.codepredators.delta.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import in.codepredators.delta.Classes.Codelanguages;
import in.codepredators.delta.Classes.RecyclerAdapterCodeLanguages;
import in.codepredators.delta.Classes.User;
import in.codepredators.delta.R;



public class UserDetail extends AppCompatActivity {

    private StorageReference mStorageRef;

    ImageView profilePic;
    EditText userName;
    EditText userBio;
    TextView proceedUserAccount;
    RecyclerView coderecycler;
    List<Codelanguages> codeList;
    TextView openrecyclerview;
    static List<String> userCodeList;
    static String codename[] = {
            "java",
            "xml",
            "C",
            "C++",
            "python"
    };
    public static void usercodelistfunc(int i){
        userCodeList.add(codename[i]);
    }
    User user;
    FirebaseAuth  mAuth;
    FirebaseDatabase mDatabase;
    DatabaseReference mReference;
    String UID;
    Uri imageUri;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageView imageView = (ImageView) findViewById(R.id.profilePicUserAccountInfo2);
    int RESULT_LOAD_IMAGE =1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iotalkactivity_useraccountinfo);
        profilePic = findViewById(R.id.profilePicUserAccountInfo);
        userBio = findViewById(R.id.editTextBioUserAccountInfo);
        userName = findViewById(R.id.editTextUserName);
        proceedUserAccount = findViewById(R.id.textViewProceedUserAccountInfo);
        openrecyclerview  = findViewById(R.id.textViewCodeLanguageRecyclerView);

        mStorageRef = FirebaseStorage.getInstance().getReference();





        StorageReference riversRef = mStorageRef.child("images.jpg");

        riversRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });



        mAuth = FirebaseAuth.getInstance();
        UID ="MeINhuTy1oYhjiM81QIbzZFhqup1";
        user = new User();
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference().child("users");
        coderecycler = findViewById(R.id.recyclerViewUserCodeLanguage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        coderecycler.setLayoutManager(linearLayoutManager);

        openrecyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coderecycler.setVisibility(View.VISIBLE);
            }
        });

        for(int i=0;i<=4;i++)
        {
            Codelanguages cl = new Codelanguages(codename[i]);
            codeList.add(cl);
        }
        RecyclerAdapterCodeLanguages adapter = new RecyclerAdapterCodeLanguages(codeList);
        coderecycler.setAdapter(adapter);
        sharedPreferences = getSharedPreferences("IOTalk",0);
        editor = sharedPreferences.edit();
        user.setUID(sharedPreferences.getString("UID","NOTFOUND"));
        user.setUserName(sharedPreferences.getString("UserName","NOTFOUND"));
        user.setUserBio(sharedPreferences.getString("UserBio","NOTFOUND"));

        ImageView imageView = (ImageView) findViewById(R.id.profilePicUserAccountInfo2);
        int RESULT_LOAD_IMAGE =1;

        Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
        gallery.setType("image/*");
        startActivityForResult(gallery, RESULT_LOAD_IMAGE);

        proceedUserAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                user.setUserBio(userBio.getText().toString());
                user.setUserName(userName.getText().toString());
                user.setUID(UID);
                editor.putString("UserName",user.getUserName());
                editor.putString("UserBio",user.getUserBio());
                editor.putString("UID",UID);
                editor.commit();
                FirebaseDatabase.getInstance().getReference().child("users").child(UID).setValue(user);
                coderecycler.setVisibility(View.GONE);
                Toast.makeText(UserDetail.this, "Work done", Toast.LENGTH_LONG).show();
            }
        });

    }
}
