package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu); // Certifique-se de ter menu.xml em res/layout

        // Botões do menu (tudo em minúsculo)
        Button btnabrirfrase = findViewById(R.id.btnabrirfrase);
        Button btnabrirmoedas = findViewById(R.id.btnabrirmoedas);
        Button btnabrirtemperatura = findViewById(R.id.btnabrirtemperatura);
        Button btnabrircep = findViewById(R.id.btnabrircep);
        Button btnabrirlistacompras = findViewById(R.id.btnabrirlistacompras);
        Button btnabrircapturaimg = findViewById(R.id.btnabrircapturaimg);
        Button btnabrircachorro = findViewById(R.id.btnabrircachorro);

        // Botão para abrir a tela de frases
        btnabrirfrase.setOnClickListener(v -> {
            Intent intent = new Intent(MenuAcitivity.this, HomeActivity.class);
            startActivity(intent);
        });

        // Botão para abrir a tela de conversão de moedas
        btnabrirmoedas.setOnClickListener(v -> {
            Intent intent = new Intent(MenuAcitivity.this, ConversorActivity.class);
            startActivity(intent);
        });

        // Botão para abrir a tela de temperatura
        btnabrirtemperatura.setOnClickListener(v -> {
            Intent intent = new Intent(MenuAcitivity.this, Temperatura.class);
            startActivity(intent);
        });

        // Botão para abrir a tela de busca de CEP
        btnabrircep.setOnClickListener(v -> {
            Intent intent = new Intent(MenuAcitivity.this, cepActivity.class);
            startActivity(intent);
        });

        btnabrircachorro.setOnClickListener(v -> {
            Intent intent = new Intent(MenuAcitivity.this, Cachorro.class);
            startActivity(intent);
        });

        btnabrirlistacompras.setOnClickListener(v -> {
            Intent intent = new Intent(MenuAcitivity.this, ListaCompras.class);
            startActivity(intent);
        });

        btnabrircapturaimg.setOnClickListener(v -> {
            Intent intent = new Intent(MenuAcitivity.this, capturaImagem.class);
            startActivity(intent);
        });

    }
}
