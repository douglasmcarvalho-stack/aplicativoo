package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Temperatura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversortemp);

        // Componentes do layout
        EditText txtValorTemp = findViewById(R.id.txtValorTemp);
        Spinner spTempDe = findViewById(R.id.spTempDe);
        Spinner spTempPara = findViewById(R.id.spTempPara);
        Button btnConverter = findViewById(R.id.btnConverter);
        TextView txtResultadoTemp = findViewById(R.id.txtResultadoTemp);

        // Configura os spinners
        String[] escalas = {"Celsius", "Fahrenheit", "Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, escalas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTempDe.setAdapter(adapter);
        spTempPara.setAdapter(adapter);

        // Clique do botão
        btnConverter.setOnClickListener(v -> {
            String valorStr = txtValorTemp.getText().toString().trim();

            if (valorStr.isEmpty()) {
                Toast.makeText(Temperatura.this, "Digite uma temperatura", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double valor = Double.parseDouble(valorStr);
                String de = spTempDe.getSelectedItem().toString();
                String para = spTempPara.getSelectedItem().toString();

                double resultado = converterTemperatura(valor, de, para);
                txtResultadoTemp.setText(String.format("Resultado: %.2f %s", resultado, para));

            } catch (NumberFormatException e) {
                Toast.makeText(Temperatura.this, "Valor inválido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Função de conversão de temperatura
    private double converterTemperatura(double valor, String de, String para) {
        if (de.equals(para)) return valor;

        switch (de + "->" + para) {
            case "Celsius->Fahrenheit": return (valor * 9 / 5) + 32;
            case "Celsius->Kelvin": return valor + 273.15;
            case "Fahrenheit->Celsius": return (valor - 32) * 5 / 9;
            case "Fahrenheit->Kelvin": return ((valor - 32) * 5 / 9) + 273.15;
            case "Kelvin->Celsius": return valor - 273.15;
            case "Kelvin->Fahrenheit": return ((valor - 273.15) * 9 / 5) + 32;
            default: return 0;
        }
    }
}
