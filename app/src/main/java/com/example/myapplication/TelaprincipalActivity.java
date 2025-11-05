package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TelaPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file); // ⚠️ Certifique-se de que "file.xml" realmente existe em res/layout/

        TextView txxUsuario = findViewById(R.id.txtUsuario);
        Button txtsenha= findViewById(R.id.txtSenha);
        Button btnButton = findViewById(R.id.btnButton);
        ImageView image02 = findViewById(R.id.image02);


        int[] imagens = {
                R.drawable.image03,
                R.drawable.image04,
                R.drawable.image05,
                R.drawable.image06
        };

        String[] frases = {
                "Acredite em você!",
                "Nunca desista!",
                "Você é capaz!",
                "Continue tentando!",
                "Você é fera!",
                "Com grandes poderes vêm grandes responsabilidades!"
        };

        btnFrase.setOnClickListener(v -> {
            int numero = new Random().nextInt(frases.length);
            txtFrase.setText(frases[numero]);
            img.setImageResource(imagens[numero]);
        });

        // Botão voltar — volta para a tela anterior (por exemplo, MainActivity)
        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaPrincipalActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

