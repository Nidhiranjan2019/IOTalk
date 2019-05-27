package in.codepredators.delta.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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


import in.codepredators.delta.Classes.ChatScreen;
import in.codepredators.delta.R;

public class Registration extends AppCompatActivity
{
    private EditText mPhoneNumber , mCode ;
    private TextView mContinue, mLogin;
    private View flag;
    private TextView mText, orText;
    private TextView mRegistration ;
    private ImageView icon;
    private LinearLayout textBox;
    private TextView warning ;


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks ;
    String mVerificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iotalkactivity_registration);
        FirebaseApp.initializeApp(this);
        textBox = findViewById(R.id.linearLayout2RegistrationFailed);
        icon = findViewById(R.id.viewRegistrationFailed);
        warning = findViewById(R.id.textViewOtpFailedRegistrationFailed);
        orText = findViewById(R.id.textView8);
        mCode =findViewById(R.id.editTextPhoneNoRegistrationFailed);
        mRegistration = findViewById(R.id.editTextPhoneNoRegistrationFailed);
        flag = findViewById(R.id.viewCountryFlagRegistrationFailed);
        mText = findViewById(R.id.textViewEnterRegistrationFailed);
        mPhoneNumber = findViewById(R.id.editTextPhoneNoRegistrationFailed);
        mContinue = findViewById(R.id.textViewContinueRegistrationFailed);
        mLogin = findViewById(R.id.viewLoginSignIn);
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
                orText.setVisibility(View.GONE);
                mLogin.setVisibility(View.GONE);
//                icon.setImageResource();
                mText.setText("Enter the OTP sent to your mobile number.");
                mRegistration.setHint("Enter OTP");
                flag.setVisibility(View.GONE);

                if(mVerificationId!= null)
                {
                    Log.i("DEBUG", mCode.getText().toString());
                    verifyPhoneNumberWithCode(mVerificationId,mCode.getText().toString());
                }
                else
                    startPhoneNumberVerification();
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this,ChatList.class);
                startActivity(intent);
                finish();


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
                else
                {
//                    icon.setImageResource();

                    mContinue.setText("Registration");
                    orText.setVisibility(View.VISIBLE);
                    mLogin.setVisibility(View.VISIBLE);
                    mText.setText("Enter your mobile number we will send you OTP to register account or simply login to your existing account.");
                    mRegistration.setText("Enter OTP");
                    flag.setVisibility(View.VISIBLE);
                    warning.setText("OTP verification failed");
                    mContinue.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            mContinue.setText("Verify");
                            orText.setVisibility(View.GONE);
                            mLogin.setVisibility(View.GONE);
//                icon.setImageResource();
                            mText.setText("Enter the OTP sent to your mobile number.");
                            mRegistration.setHint("Enter OTP");
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

            }
        });
    }

    private void userIsLoggedIn()
    {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            mRegistration.setText("Verified");
            mText.setText("Your phone number has been successfully verified.");
            mContinue.setText("Continue");
            textBox.setVisibility(View.GONE);
//            icon.setImageResource();

            mContinue.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), ChatScreen.class));
                    finish();
                    return;
                }
            });
        }
    }

    private void startPhoneNumberVerification()
    {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(

                mPhoneNumber.getText().toString(),
//                "+919455349314",
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks);
    }
}
