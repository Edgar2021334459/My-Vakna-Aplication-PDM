package com.example.myvaknaaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CadastroVakna extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton btn_seta_cv;
    private TextView text_realizar_login_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vakna);

        IniciarComponentes();

        btn_seta_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1cv = new Intent(CadastroVakna.this,MainActivity.class);
                startActivity(intent_1cv);
            }
        });

        text_realizar_login_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_2cv = new Intent(CadastroVakna.this,LoginVakna.class);
                startActivity(intent_2cv);
            }
        });
    }
    private void IniciarComponentes(){
        btn_seta_cv = findViewById(R.id.btn_seta_cv);
        text_realizar_login_cv = findViewById(R.id.text_realizar_login_cv);
    }
}