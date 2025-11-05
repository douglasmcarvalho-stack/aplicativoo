package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu); // Certifique-se de ter o arquivo menu.xml em res/layout

        // Botão para abrir o ConversorActivity
        Button btnConversor = findViewById(R.id.btnAbrirConversor);
        btnConversor.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ConversorActivity.class);
            startActivity(intent);
        });

        // Botão para abrir o HomeActivity
        Button btnFrases = findViewById(R.id.btnAbrirFrases);
        btnFrases.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}

