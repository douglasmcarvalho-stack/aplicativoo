package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); // Certifique-se que home.xml existe

        // Referências do layout
        TextView txtFrase = findViewById(R.id.txtFrase);
        Button btnFrase = findViewById(R.id.btnFrase);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        // Array de frases com emojis
        String[] frases = {
                "Acredite em você! 💪",
                "Nunca desista! 🚀",
                "Você é capaz! 🌟",
                "Continue tentando! 🔥",
                "Você fera! 🏆",
                "Com grandes poderes, vem grandes responsabilidades! 🕷️"
        };

        // Botão para mostrar frase aleatória
        btnFrase.setOnClickListener(v -> {
            int numero = new Random().nextInt(frases.length);
            txtFrase.setText(frases[numero]);
        });

        // Botão voltar
        btnVoltar.setOnClickListener(v -> onBackPressed());
    }
}
