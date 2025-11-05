package com.example.dogapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ImageView imgCachorro;
    private Button btnMostrarCachorro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCachorro = findViewById(R.id.imgCachorro);
        btnMostrarCachorro = findViewById(R.id.btnMostrarCachorro);

        // Quando clicar no botão, chama o método para buscar o cachorro
        btnMostrarCachorro.setOnClickListener(v -> buscarCachorro());
    }

    private void buscarCachorro() {
        new Thread(() -> {
            try {
                // 1️⃣ Faz requisição para a API
                URL url = new URL("https://dog.ceo/api/breeds/image/random");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // 2️⃣ Lê o retorno da API
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // 3️⃣ Pega o link da imagem
                JSONObject json = new JSONObject(response.toString());
                String imageUrl = json.getString("message");

                // 4️⃣ Faz o download da imagem
                URL image = new URL(imageUrl);
                HttpURLConnection imgConnection = (HttpURLConnection) image.openConnection();
                imgConnection.setDoInput(true);
                imgConnection.connect();
                InputStream input = imgConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(input);

                // 5️⃣ Atualiza a tela com a imagem
                runOnUiThread(() -> imgCachorro.setImageBitmap(bitmap));

            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() ->
                        btnMostrarCachorro.setText("Erro ao carregar imagem!"));
            }
        }).start();
    }
}
