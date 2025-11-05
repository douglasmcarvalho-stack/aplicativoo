package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivy extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button btnabrirfrase = findViewById(R.id.btnabrirfrase);
        Button btnbtnabrirmoedasEntrar = findViewById(R.id.btnabrirmoedas);
        Button btnbtnabrirtemperaturaEntrar = findViewById(R.id.btnabrirtemperatura);
        Button btnabrircep = findViewById(R.id.btnabrircep);
        btnabrircep.setOnClickListener(v -> {
                    //ABRIR NOVA VISUALIZAÇÃO
                    Intent intent = new Intent(ViewActivy.this, HomeActivity.class);
                    startActivity(intent);
                }
        );

    }


}
