package com.inhatc.gachi_salrim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;

public class SignupActivity extends Activity {

    EditText editName;
    EditText editId;
    EditText editPw;
    EditText editPwChk;
    EditText editEmail;
    EditText editPhone;
    Spinner spinArea;
    Button btnSingup;

    private DatabaseReference mDatabase;    //firebase DB 정보 선언

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mDatabase = FirebaseDatabase.getInstance().getReference();  //firebase 정의

        editName = findViewById(R.id.editTxtNm);
        editId = findViewById(R.id.editTxtId);
        editPw = findViewById(R.id.editTxtPw);
        editPwChk = findViewById(R.id.editTxtPwChk);
        editEmail = findViewById(R.id.editTxtEmail);
        editPhone = findViewById(R.id.editTxtPone);
        spinArea = findViewById(R.id.spinArea);

        // 회원가입 버튼
        btnSingup = findViewById(R.id.btnSignup);
        btnSingup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // 회원가입 validation
                signUpUser();
                // 회원가입
            }
        });
    }

    private void signUpUser(){
        User user = new User(
                editName.getText().toString()
                ,editId.getText().toString()
                ,editPw.getText().toString()
                ,editEmail.getText().toString()
                ,editPhone.getText().toString()
        );
        mDatabase.child("users").child(editId.getText().toString()).setValue(user)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(SignupActivity.this, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent); // 로그인 화면으로 이동
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // Write failed
                    Toast.makeText(SignupActivity.this, "회원가입을 실패하였습니다.", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
