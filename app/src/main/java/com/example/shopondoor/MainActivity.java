package com.example.shopondoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    static int TIMEOUT_MILLIS = 1000;
    FirebaseUser user;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
       // if (user != null) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent i;
                    i = new Intent(MainActivity.this, login.class);
                    startActivity(i);
                    finish();
                }
            }, TIMEOUT_MILLIS);
        //}
    }
}