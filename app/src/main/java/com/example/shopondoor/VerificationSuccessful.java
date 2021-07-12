package com.example.shopondoor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VerificationSuccessful extends AppCompatActivity {
    Button PasswordVisble;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_successful);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        PasswordVisble = findViewById(R.id.passwordVisible);
        PasswordVisble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().isEmpty()){
                    password.setError("Please Enter Pass word");
                } else {
                    if(PasswordVisble.getText().toString().equals("Show")){
                        PasswordVisble.setText("Hide");
                        password.setTransformationMethod(null);
                    } else {
                        PasswordVisble.setText("Show");
                        password.setTransformationMethod(new PasswordTransformationMethod());
                    }
                }
            }
        });
        Button click = findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getText().toString().isEmpty()&&(!password.getText().toString().isEmpty())) {
                    Toast.makeText(VerificationSuccessful.this, "you have entered email id " + email.getText().toString() + "Password " + password.getText().toString(), Toast.LENGTH_LONG).show();
                } else {
                    email.setError("Please Enter Email id");
                    password.setError("Please Enter Pass word");
                }
            }
        });
    }
}