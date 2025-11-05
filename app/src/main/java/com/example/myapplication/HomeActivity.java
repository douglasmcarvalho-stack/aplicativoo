package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {


    private int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); // Certifique-se de que o arquivo home.xml está em res/layout
        TextView txtFrase = findViewById(R.id.txtFrase);
        Button btnFrase = findViewById(R.id.btnFrase);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        ImageView img = findViewById(R.id.img);


        int[] imagens = {
                R.drawable.img01,
                R.drawable.img02,
                R.drawable.img03,
                R.drawable.img04,
                R.drawable.img05,
                R.drawable.img06
        };

        String [] frases={
                "Acredite em você!",
                "Nunca desista!",
                "Você é capaz!",
                "Continue tentando!",
                "Você fera!",
                "Com grandes poderes ,vem grandes responsabilidades!"
        };
        btnFrase.setOnClickListener(v-> {
            int numero = new Random().nextInt(frases.length);
            txtFrase.setText(frases[numero]);
            img.setImageResource(imagens[numero]);
        });

        btnVoltar.setOnClickListener(v-> {
            onBackPressed();
        });

    }
}