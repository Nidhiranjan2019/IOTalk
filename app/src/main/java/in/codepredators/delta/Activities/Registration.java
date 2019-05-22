package in.codepredators.delta.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

import java.util.concurrent.TimeUnit;

import in.codepredators.delta.Activities.ChatList;
import in.codepredators.delta.R;

public class Registration extends AppCompatActivity
{
    private EditText mPhoneNumber , mCode;
    private TextView mContinue;
    private View flag;
    private TextView mText;
    private TextView mRegistration ;


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks ;
    String mVerificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        FirebaseApp.initializeApp(this);
        mCode =findViewById(R.id.editTextPhoneNoRegistration);
        mRegistration = findViewById(R.id.textViewRegistration);
        flag = findViewById(R.id.viewCountryFlagRegistration);
        mText = findViewById(R.id.textViewEnterRegistration);
        mPhoneNumber = findViewById(R.id.editTextPhoneNoRegistration);
        mContinue = findViewById(R.id.textViewContinueRegistration);
        mCallbacks = new OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
                Log.i("Verification Complete", phoneAuthCredential.getSmsCode());
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                e.printStackTrace();

            }

            @Override
            public void onCodeSent(String VerificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(VerificationId, forceResendingToken);
                Log.i("OnCodeSent", "" + VerificationId);
                mVerificationId= VerificationId;
            }
        };



        mContinue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mContinue.setText("Verify");
                mText.setText("Enter 6-digit OTP");
                mRegistration.setText("Enter OTP");
                flag.setVisibility(View.GONE);
                if(mVerificationId!= null)
                {
                    verifyPhoneNumberWithCode(mVerificationId,mCode.getText().toString());
                }
                else
                    startPhoneNumberVerification();
            }
        });
    }
    private void verifyPhoneNumberWithCode(String verificationId , String code)
    {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                    userIsLoggedIn();

            }
        });
    }

    private void userIsLoggedIn()
    {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            startActivity(new Intent(getApplicationContext(), ChatList.class));
            finish();
            return;
        }
    }

    private void startPhoneNumberVerification()
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mPhoneNumber.getText().toString(),
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks);
    }
}
