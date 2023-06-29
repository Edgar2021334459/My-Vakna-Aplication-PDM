package com.example.myvaknaaplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginVakna extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton btn_seta_lv;
    private TextView text_realizar_login_lv;

    private EditText edit_email_lv, edit_senha_lv;
    private Button  btn_cadastrar_lv;

    String[] mensagens = {"Preencha todos os campos", " Login realizado com sucesso" };


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

        btn_cadastrar_lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edit_email_lv.getText().toString();
                String senha = edit_senha_lv.getText().toString();

                if (email.isEmpty()  || senha.isEmpty() ) {

                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT );
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                }else {

                    AutenticarUsuario(view);
                    //TelaPrincipal();

                }

            }
        });


    }

    /*private void TelaPrincipal(){

        Intent it = new Intent(LoginVakna.this, TelaPrincipal().class);
        startActivity(it);
        finish();

    }*/

    private void AutenticarUsuario(View v){

        String email = edit_email_lv.getText().toString();
        String senha = edit_senha_lv.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    Snackbar snackbar = Snackbar.make(v , mensagens[1], Snackbar.LENGTH_SHORT );
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                } {



                }

            }
        });

    }

    private void IniciarComponentes(){
        btn_seta_lv = findViewById(R.id.btn_seta_lv);
        text_realizar_login_lv = findViewById(R.id.text_realizar_cadastro_lv);

        edit_email_lv = findViewById(R.id.edit_email_lv);
        edit_senha_lv = findViewById(R.id.edit_senha_lv);
        btn_cadastrar_lv = findViewById(R.id.btn_cadastrar_lv);

    }
}