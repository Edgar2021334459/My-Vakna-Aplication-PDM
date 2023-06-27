package com.example.myvaknaaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PerfilVakna extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton btn_logout_pv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_vakna);

        IniciarComponentes();

        btn_logout_pv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1pv = new Intent(PerfilVakna.this,MainActivity.class);
                startActivity(intent_1pv);
            }
        });
    }
    private void IniciarComponentes(){
        btn_logout_pv = findViewById(R.id.btn_logout_pv);
    }
}