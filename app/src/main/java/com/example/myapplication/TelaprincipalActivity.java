package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TelaprincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telaprincipalactivity_main);

        EditText txtUsuario = findViewById(R.id.txtUsuario);
        EditText txtSenha = findViewById(R.id.txtSenha);
        Button btnEntrar = findViewById(R.id.btnEntrar);
        ImageView imageFundo = findViewById(R.id.imageFundo);

        btnEntrar.setOnClickListener(v -> {
            String usuario = txtUsuario.getText().toString();
            String senha = txtSenha.getText().toString();

            if (usuario.equals("admin") && senha.equals("1234")) {
                Intent intent = new Intent(TelaprincipalActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                txtSenha.setError("Usuário ou senha incorretos");
            }
        });
    }
}
