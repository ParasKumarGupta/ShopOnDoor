package com.example.shopondoor;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class EnterMobileNumberForOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_mobile_number_for_otp);

        final EditText inputmobile = findViewById(R.id.edt_getMobileNumber);
        final Button buttongetotp = findViewById(R.id.btn_getOtp);

        // #1

        final ProgressBar progressBar =  findViewById(R.id.progressbarforotp);

        buttongetotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

                if (!inputmobile.getText().toString().trim().isEmpty()){
                    if ((inputmobile.getText().toString().trim()).length() == 10){

//                         #2
                        progressBar.setVisibility(View.VISIBLE);
                        buttongetotp.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + inputmobile.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                EnterMobileNumberForOTP.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                        progressBar.setVisibility(View.GONE);
                                        buttongetotp.setVisibility(View.VISIBLE);

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        buttongetotp.setVisibility(View.VISIBLE);
                                        Toast.makeText(EnterMobileNumberForOTP.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String verficationid, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(View.GONE);
                                        buttongetotp.setVisibility(View.VISIBLE);
                                        Intent intent = new Intent(getApplicationContext(),OTPEnter.class);
                                        intent.putExtra("mobile",inputmobile.getText().toString());
                                        intent.putExtra("verfication",verficationid);
                                        startActivity(intent);
                                    }
                                }

                        );



                    }else {
                        Toast.makeText(EnterMobileNumberForOTP.this,"Please enter correct number",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(EnterMobileNumberForOTP.this,"Enter Mobile number",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
