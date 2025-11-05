package com.example.myapplication;

public class Temperatura {
    package com.example.applicativoteste;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class TemperaturaActivity extends AppCompatActivity {
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.conversor_temperatura);

            EditText txtValorTemp = findViewById(R.id.txtValorTemp);
            Spinner spTempDe = findViewById(R.id.spTempDe);
            Spinner spTempPara = findViewById(R.id.spTempPara);
            Button btnConverter = findViewById(R.id.btnConverter);
            TextView txtResultadoTemp = findViewById(R.id.txtResultadoTemp);

            String[] escalas = {"Celsius", "Fahrenheit", "Kelvin"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, escalas);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spTempDe.setAdapter(adapter);
            spTempPara.setAdapter(adapter);

            btnConverter.setOnClickListener(v -> {
                String valorStr = txtValorTemp.getText().toString();
                if (!valorStr.isEmpty()) {
                    double valor = Double.parseDouble(valorStr);
                    String de = spTempDe.getSelectedItem().toString();
                    String para = spTempPara.getSelectedItem().toString();
                    double resultado = converterTemperatura(valor, de, para);
                    txtResultadoTemp.setText(String.format("Resultado: %.2f %s", resultado, para));
                } else {
                    Toast.makeText(TemperaturaActivity.this, "Digite uma temperatura", Toast.LENGTH_SHORT).show();
                }
            });

        }

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
}
