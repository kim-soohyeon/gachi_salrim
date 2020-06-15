package com.inhatc.gachi_salrim;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class SignupActivity extends Activity {

    EditText editName;
    EditText editId;
    EditText editPw;
    EditText editPwChk;
    EditText editEmail;
    EditText editPhone;
    EditText editErea;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
    }
}
