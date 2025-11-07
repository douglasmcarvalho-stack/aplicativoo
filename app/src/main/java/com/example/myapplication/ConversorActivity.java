package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ConversorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor);

        final double taxaDolar = 0.20; // 1 BRL = 0.20 USD
        final double taxaEuro = 0.18;  // 1 BRL = 0.18 EUR

        // Criar a lista de opções
        String[] moedas = {"Dólar", "Euro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, moedas
        );
        // Definir o layout do dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        EditText txtValor = findViewById(R.id.txtValor);
        Spinner spMoeda = findViewById(R.id.spMoeda);
        Button btnConversor = findViewById(R.id.btnConversor);
        Button btnVoltarConversor = findViewById(R.id.btnConversor);
        TextView txtResultado = findViewById(R.id.txtResultado);

        // Aplicar o adapter ao Spinner
        spMoeda.setAdapter(adapter);

        btnConversor.setOnClickListener(v->{
            String valorStr = txtValor.getText().toString();
            if (valorStr.isEmpty()) { // verifica se esta em branco
                Toast.makeText(ConversorActivity.this, "Digite um valor em Reais", Toast.LENGTH_SHORT).show();
                return; }

            double valorReal = Double.parseDouble(valorStr);
            double resultado = 0;
            String moeda = spMoeda.getSelectedItem().toString();


            if (moeda.equals("Dólar")) {
                resultado = valorReal * taxaDolar;
            } else if (moeda.equals("Euro")) {
                resultado = valorReal * taxaEuro;
            }
            txtResultado.setText(String.format("Valor convertido: %.2f %s", resultado, moeda));
        });



    }
}