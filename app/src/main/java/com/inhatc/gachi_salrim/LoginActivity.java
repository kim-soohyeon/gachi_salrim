package com.inhatc.gachi_salrim;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

import androidx.annotation.NonNull;

public class LoginActivity extends Activity {

    public TextView btnGotoSingup;
    public Button btnLogin;
    public EditText editId;
    public EditText editPw;

    private DatabaseReference mDatabase;    //firebase DB 정보 선언

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editId = findViewById(R.id.editId);
        editPw = findViewById(R.id.editPw);

        mDatabase = FirebaseDatabase.getInstance().getReference("users");  //firebase 정의

        // 회원가입 버튼
        btnGotoSingup = findViewById(R.id.btnGotoSignup);
        btnGotoSingup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent); // 회원가입 화면으로 이동
            }
        });

        // 로그인 버튼
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
                mDialog.setMessage("로그인중..");
                mDialog.show();

                // 로그인 시도
                mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //찾고자 하는 ID값은 key로 존재하는 값
                        if(dataSnapshot.child(editId.getText().toString()).exists())
                        {
                            User u = dataSnapshot.child(editId.getText().toString()).getValue(User.class);

                            if(u.getPw().equals(editPw.getText().toString()))
                            {
                                mDialog.dismiss();
                                Toast.makeText(getApplicationContext(),"로그인되었습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this,SetAreaActivity.class);
                                startActivity(intent); // 지역안내 화면으로 이동
                            }
                            else
                            {
                                mDialog.dismiss();
                                Toast.makeText(getApplicationContext(),"비밀번호가 잘못되었습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                        else{
                            mDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "ID가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
