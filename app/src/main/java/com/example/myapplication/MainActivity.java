package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private Integer x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //  Referenciando os elementos da interface
        EditText txtUsuario = findViewById(R.id.txtUsuario);
        EditText txtSenha = findViewById(R.id.txtSenha);
        Button btnEntrar = findViewById(R.id.btnEntrar);

        //  Definindo ação ao clicar no botão
        btnEntrar.setOnClickListener(v -> {
            String usuario=txtUsuario.getText().toString();
            String senha=txtSenha.getText().toString();

            if(usuario.equals("admin") &&  senha.equals("admin")){
                //ABRIR NOVA VISUALIZAÇÃO
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
            }

        });

    }
}