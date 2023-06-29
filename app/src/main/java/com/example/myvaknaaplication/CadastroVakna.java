package com.example.myvaknaaplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CadastroVakna extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton btn_seta_cv;
    private TextView text_realizar_login_cv;


    private EditText edit_email_cv, edit_senha_cv, edit_nome_cv;
    private Button btn_cadastrar_cv;
    String[] mensagens = {"Não esqueça de preencher todos os campos", " Cadastro realizado com sucesso" };
    String usuarioID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vakna);

        IniciarComponentes();

        btn_seta_cv.setOnClickListener(v -> {
            Intent intent_1cv = new Intent(CadastroVakna.this,MainActivity.class);
            startActivity(intent_1cv);
        });

        text_realizar_login_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_2cv = new Intent(CadastroVakna.this,LoginVakna.class);
                startActivity(intent_2cv);
            }
        });

        btn_cadastrar_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = edit_nome_cv.getText().toString();
                String email = edit_email_cv.getText().toString();
                String senha = edit_senha_cv.getText().toString();

                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){

                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT );
                    snackbar.setBackgroundTint(Color.GRAY);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    CadastrarUsuario(view);
                }

            }
        });

    }

    private void CadastrarUsuario(View v){

        String email = edit_email_cv.getText().toString();
        String senha = edit_senha_cv.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    SalvarDadosUsuario();

                    Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT );
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    String erro;
                    try {
                        throw task.getException();

                    }catch (FirebaseAuthWeakPasswordException e ){
                        erro = "Digite uma senha com no minimo de 6 caracters";
                    }catch (FirebaseAuthUserCollisionException e ){
                        erro = "Este email ja esta em uso";
                    }catch (FirebaseAuthInvalidCredentialsException e ){
                        erro = "Email invalido";
                    }catch (Exception e ){
                        erro = "Erro ao realizar o cadastro";
                    }

                    Snackbar snackbar = Snackbar.make(v, erro, Snackbar.LENGTH_SHORT );
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                }


            }
        });

    }

    private void SalvarDadosUsuario(){

        String nome = edit_nome_cv.getText().toString();

        FirebaseFirestore bd = FirebaseFirestore.getInstance();

        Map<String, Object> usuarios = new HashMap<>();
        usuarios.put("nome", nome);

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference = bd.collection("Usuarios").document(usuarioID);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                Log.d("bd", "sucesso ao salvar os dados");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Log.d("db_error", "Erro ao salvar os dados"+ e);

            }
        });

    }

    private void IniciarComponentes(){
        btn_seta_cv = findViewById(R.id.btn_seta_cv);
        text_realizar_login_cv = findViewById(R.id.text_realizar_login_cv);

        edit_nome_cv = findViewById(R.id.edit_nome_cv);
        edit_email_cv = findViewById(R.id.edit_email_cv) ;
        edit_senha_cv = findViewById(R.id.edit_senha_cv);
        btn_cadastrar_cv = findViewById(R.id.btn_cadastrar_cv);
    }



}