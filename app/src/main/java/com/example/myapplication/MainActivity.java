package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);

        // Referenciando os elementos da interface
        EditText txtUsuario = findViewById(R.id.txtUsuario);
        EditText txtSenha = findViewById(R.id.txtSenha);
        Button btnApp = findViewById(R.id.btnApp);
        ImageView imgLogo = findViewById(R.id.imgLogo);

        // Definindo ação ao clicar no botão
        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = txtUsuario.getText().toString();
                String senha = txtSenha.getText().toString();

                if (usuario.equals("admin") && senha.equals("1234")) {
                    // Abrir nova activity (por exemplo, HomeActivity)
                    Intent intent = new Intent(MainActivity.this, MenuAcitivity.class);
                    startActivity(intent);
                } else {
                    txtUsuario.setError("Usuário ou senha incorretos!");
                }
            }
        });
    }
}
