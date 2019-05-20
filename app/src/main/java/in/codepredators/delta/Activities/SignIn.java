package in.codepredators.delta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import in.codepredators.delta.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SignIn extends AppCompatActivity {
    int a=0;
    View createAccount ;
    View login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        createAccount = findViewById(R.id.viewCreateAccountSignIn);
        login = findViewById(R.id.viewLoginSignIn);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send to activity_registration
                a=0;
                Log.i("DEBUG", "1");
                Intent intent = new Intent(SignIn.this, UserDetail.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send to registration confirmation
                a=1;
                Log.i("DEBUG", "2");
                Intent intent = new Intent(SignIn.this, Registration.class);
                startActivity(intent);
                finish();

            }
        });


    }
}