package com.example.senseiservice1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignAct extends AppCompatActivity {

    private EditText EmailNumberET, PasswordET;
    private FirebaseAuth mAuth;
    private Button buttonReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        init();

    }
    private void init()
    {
        EmailNumberET = findViewById(R.id.EmailNumberET);
        PasswordET = findViewById(R.id.PasswordET);
        mAuth = FirebaseAuth.getInstance();
        buttonReg = (Button) findViewById(R.id.buttonReg);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegAct();
            }
        });
    }
    public void openRegAct(){
        Intent i = new Intent(this, RegAct.class);
        startActivity(i);
    }
    public void onClickSignIn(View view)
    {
        if(!TextUtils.isEmpty(EmailNumberET.getText().toString()) && !TextUtils.isEmpty(PasswordET.getText().toString()))
        {
            mAuth.signInWithEmailAndPassword(EmailNumberET.getText().toString(), PasswordET.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Успешная авторизация", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(SignAct.this, ListOrderAct.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Ошибка авторизации", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}