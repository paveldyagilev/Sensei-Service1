package com.example.senseiservice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListOrderAct extends AppCompatActivity {

    private Button sidebar_btn;
    private Button Plus_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);

        sidebar_btn = (Button) findViewById(R.id.sidebar_btn);
        sidebar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSidebarAct();
            }
        });
        Plus_btn = (Button) findViewById(R.id.button22);
        Plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewAdAct();
            }
        });
    }
    public void openSidebarAct(){
        Intent i = new Intent(this, SidebarAct.class);
        startActivity(i);
    }
    public void openNewAdAct(){
        Intent i = new Intent(this, NewAd.class);
        startActivity(i);
    }
}