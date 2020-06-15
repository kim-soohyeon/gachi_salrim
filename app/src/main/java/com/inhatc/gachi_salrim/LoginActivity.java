package com.inhatc.gachi_salrim;

import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {

    public TextView btnGotoSingup;
    public Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                // 로그인 시도
            }
        });
    }
}
