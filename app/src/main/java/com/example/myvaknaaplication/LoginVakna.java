package com.example.myvaknaaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginVakna extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton btn_seta_lv;
    private TextView text_realizar_login_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_vakna);

        IniciarComponentes();

        btn_seta_lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1lv = new Intent(LoginVakna.this,MainActivity.class);
                startActivity(intent_1lv);
            }
        });

        text_realizar_login_lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_2lv = new Intent(LoginVakna.this,CadastroVakna.class);
                startActivity(intent_2lv);
            }
        });
    }
    private void IniciarComponentes(){
        btn_seta_lv = findViewById(R.id.btn_seta_lv);
        text_realizar_login_lv = findViewById(R.id.text_realizar_cadastro_lv);
    }
}