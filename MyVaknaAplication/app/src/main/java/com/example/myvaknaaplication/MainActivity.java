package com.example.myvaknaaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton btn_cadastro_bv;
    private androidx.appcompat.widget.AppCompatButton btn_login_bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        btn_cadastro_bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1bv = new Intent(MainActivity.this,CadastroVakna.class);
                startActivity(intent_1bv);
            }
        });

        btn_login_bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_2bv = new Intent(MainActivity.this,LoginVakna.class);
                startActivity(intent_2bv);
            }
        });
    }
    private void IniciarComponentes(){
        btn_cadastro_bv = findViewById(R.id.btn_cadastro_bv);
        btn_login_bv = findViewById(R.id.btn_login_bv);
    }
}