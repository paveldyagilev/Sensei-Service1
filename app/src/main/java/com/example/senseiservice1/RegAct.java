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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;

public class RegAct extends AppCompatActivity {

    private EditText EmailNumberET, PasswordET;
    private FirebaseAuth mAuth;
    private Button buttonSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if(cUser != null)
        {

        }
        else
        {

        }
    }

    private void init()
    {
        EmailNumberET = findViewById(R.id.EmailNumberET);
        PasswordET = findViewById(R.id.PasswordET);
        mAuth = FirebaseAuth.getInstance();
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignAct();
            }
        });
    }
    public void onClickReg(View view)
    {
        if(!TextUtils.isEmpty(EmailNumberET.getText().toString()) && !TextUtils.isEmpty(PasswordET.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(EmailNumberET.getText().toString(), PasswordET.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Пользователь зарегистрирован", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(RegAct.this, SignAct.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Пользователь уже зарегистрирован", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Введите данные", Toast.LENGTH_SHORT).show();
        }
    }
    public void openSignAct(){
        Intent i = new Intent(this, SignAct.class);
        startActivity(i);
    }
}